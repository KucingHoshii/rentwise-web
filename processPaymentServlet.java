import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Payment;
import model.Rental;

public class processPaymentServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(processPaymentServlet.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Avoid creating a new session if one doesn't exist
        if (session == null) {
            logger.log(Level.SEVERE, "Session is null. Unable to proceed with payment processing.");
            response.getWriter().write("Session expired. Please start your booking process again.");
            return;
        }

        try {
            // Get user details from session
            Rental rental = (Rental) session.getAttribute("rental");
            String userName = (String) session.getAttribute("userName");
            String userEmail = (String) session.getAttribute("userEmail");
            Integer userContact = (Integer) session.getAttribute("userContact");

            Double totalPrice = (Double) session.getAttribute("totalPrice");
            Integer rentalId = (Integer) session.getAttribute("rentalId");

            if (rental == null || userName == null || userEmail == null || userContact == null || totalPrice == null || rentalId == null) {
                logger.log(Level.SEVERE, "One or more session attributes are null. Rental: {0}, userName: {1}, userEmail: {2}, userContact: {3}, totalPrice: {4}, rentalId: {5}",
                        new Object[]{rental, userName, userEmail, userContact, totalPrice, rentalId});
                response.getWriter().write("Required session data is missing. Please start your booking process again.");
                return;
            }

            int rmx100 = (int) (totalPrice * 100);

            String userSecretKey = "fd1vn0tk-j8hp-89zj-5vjd-2vo7xi7wkfci";
            String categoryCode = "kt09f3i9";
            String billName = "RentCar";
            String billDescription = "Rent Car RM" + totalPrice;
            String billReturnUrl = "https://d182-115-134-70-58.ngrok-free.app/RentWise/PaymentCallback";
            String billCallbackUrl = "https://d182-115-134-70-58.ngrok-free.app/RentWise/PaymentCallback";

            String postData = String.format(
                    "userSecretKey=%s&categoryCode=%s&billName=%s&billDescription=%s&billPriceSetting=1&billPayorInfo=1&billAmount=%d&billReturnUrl=%s&billCallbackUrl=%s&billTo=%s&billEmail=%s&billPhone=%s&billSplitPayment=0&billSplitPaymentArgs=&billPaymentChannel=0",
                    userSecretKey, categoryCode, billName, billDescription, rmx100, billReturnUrl, billCallbackUrl, userName, userEmail, userContact);

            URL url = new URL("https://dev.toyyibpay.com/index.php/api/createBill");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            writer.write(postData);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String responseLine = reader.lines().collect(Collectors.joining());
            reader.close();

            // Safely parsing JSON response
            String billcode = null;
            try {
                billcode = responseLine.split("\"BillCode\":\"")[1].split("\"")[0];
            } catch (ArrayIndexOutOfBoundsException e) {
                logger.log(Level.SEVERE, "Error parsing the response from the payment gateway: {0}", e.getMessage());
                response.getWriter().write("Error parsing the response from the payment gateway.");
                return;
            }

            // Insert data into payment table
            String paymentId = billcode;
            String paymentMethod = "None";
            String paymentStatus = "Pending";

            // Insert to payment table
            Payment payment = new Payment();
            payment.setPaymentId(paymentId);
            payment.setRentalId(rental.getRentalId());
            payment.setPaymentAmount(totalPrice);
            payment.setPaymentMethod(paymentMethod);
            payment.setPaymentStatus(paymentStatus);

            int paymentStatusInsert = PaymentDao.insertPayment(payment);

            if (paymentStatusInsert > 0) {
                response.sendRedirect("https://dev.toyyibpay.com/" + billcode);
            } else {
                logger.log(Level.SEVERE, "Error inserting payment data into the database.");
                response.getWriter().write("Error inserting payment data into the database.");
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred during payment processing: {0}", e.getMessage());
            response.getWriter().write("An error occurred while processing your payment. Please try again later.");
        }
    }
}
