import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import model.Car;
import model.Payment;
import model.Rental;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

@WebServlet("/PaymentCallbackServlet")
public class PaymentCallback extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String billcode = request.getParameter("billcode");

        if (billcode != null && !billcode.isEmpty()) {
            try {
                // Get Bill Transactions
                String apiUrl = "https://dev.toyyibpay.com/index.php/api/getBillTransactions";
                String postData = String.format("billCode=%s", billcode);

                URL url = new URL(apiUrl);
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

                // Log the response for debugging purposes
                System.out.println("ToyyibPay API response: " + responseLine);

                // Check if the response is a valid JSON array
                Object jsonResponse = new JSONTokener(responseLine).nextValue();
                if (jsonResponse instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) jsonResponse;
                    if (jsonArray.length() > 0) {
                        JSONObject transaction = jsonArray.getJSONObject(0);

                        // Check the payment status
                        String billStatus = transaction.getString("billpaymentStatus");

                        if ("1".equals(billStatus)) { // Assuming 1 means successful
                            // Set transaction details as request attributes
                            request.setAttribute("billName", transaction.getString("billName"));
                            request.setAttribute("billDescription", transaction.getString("billDescription"));
                            request.setAttribute("billTo", transaction.getString("billTo"));
                            request.setAttribute("billEmail", transaction.getString("billEmail"));
                            request.setAttribute("billPhone", transaction.getString("billPhone"));
                            request.setAttribute("billStatus", "Successful");
                            request.setAttribute("billpaymentChannel", transaction.getString("billpaymentChannel"));
                            request.setAttribute("billPaymentDate", transaction.getString("billPaymentDate"));
                            request.setAttribute("billpaymentAmount", transaction.getString("billpaymentAmount"));
                            request.setAttribute("billpaymentInvoiceNo", transaction.getString("billpaymentInvoiceNo"));
                            request.setAttribute("SettlementReferenceNo", transaction.getString("SettlementReferenceNo"));

                            // Update Payment Status to Approved
                            String paymentMethod = transaction.getString("billpaymentChannel");
                            String paymentStatus = "Approved";
                            // Update payment table
                            Payment e = new Payment();
                            e.setPaymentId(billcode);
                            e.setPaymentMethod(paymentMethod);
                            e.setPaymentStatus(paymentStatus);

                            PaymentDao.updatePaymentStatus(e);

                            // Get all data to display in order summary
                            // Get payment information from db
                            e = PaymentDao.getPaymentById(billcode);

                            // Get rental information
                            Rental rental = RentalDao.getSelectedRentalByRentalId(e.getRentalId());                      

                            // Retrieve dates and times from the rental object
                            Date pickupDate = rental.getStartDate();
                            Date returnDate = rental.getReturnDate();
                            Time pickupTime = rental.getStartTime();
                            Time returnTime = rental.getReturnTime();

                            // Convert SQL Date to LocalDate
                            LocalDate pickupLocalDate = pickupDate.toLocalDate();
                            LocalDate returnLocalDate = returnDate.toLocalDate();

                            // Convert SQL Time to LocalTime
                            LocalTime pickupLocalTime = pickupTime.toLocalTime();
                            LocalTime returnLocalTime = returnTime.toLocalTime();

                            // Format the date and time for display
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd, h:mm a");
                            String formattedPickupDateTime = LocalDateTime.of(pickupLocalDate, pickupLocalTime).format(dateTimeFormatter);
                            String formattedReturnDateTime = LocalDateTime.of(returnLocalDate, returnLocalTime).format(dateTimeFormatter);

                            // Retrieve data for booked car in car table in db
                            Car choosenCar = CarDao.getCarById(rental.getCarId());

                            // Retrieve user information that booked a car
                            User user = UserDao.getUserById(rental.getStudentId());     
                            
                            //Update Rental status in Rental table database
                            //Assign rental status to Approved
                            String rentalStatus = "Approved";
                            
                            int status = RentalDao.updateRentalStatus(rentalStatus , rental.getRentalId());

                            // Forward to success page
                            if (status > 0) {
                                // Save booking details and formatted dates in session
                                HttpSession session = request.getSession();

                                // Parse information in session to use in next page
                                session.setAttribute("rental", rental);
                                session.setAttribute("choosenCar", choosenCar);
                                session.setAttribute("user", user);
                                session.setAttribute("userId",user.getStudent_id());

                                // Set formatted date and time as request attributes
                                session.setAttribute("formattedPickupDateTime", formattedPickupDateTime);
                                session.setAttribute("formattedReturnDateTime", formattedReturnDateTime);
                                
                                //Redirect to order summary page
                                request.getRequestDispatcher("orderSummary.jsp").forward(request, response);
                            } else {
                                response.getWriter().write("Error inserting rental data into the database.");
                            }
                        } else {
                            // Payment failed
                            request.setAttribute("billStatus", "Failed");

                            // Delete records from Rental and Payment tables
                            Payment e = new Payment();
                            e.setPaymentId(billcode);

                            PaymentDao.deleteRentalByPaymentId(e);
                            PaymentDao.deletePaymentByPaymentId(e);

                            // Forward to failure page
                            request.getRequestDispatcher("payment-failed.jsp").forward(request, response);
                        }
                    } else {
                        // No transaction found
                        request.setAttribute("error", "No transaction found.");
                        request.getRequestDispatcher("payment-failed.jsp").forward(request, response);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Log the exception and forward to the error page
                request.setAttribute("error", "An error occurred while processing the payment: " + e.getMessage());
                request.getRequestDispatcher("payment-failed.jsp").forward(request, response);
            }
        } else {
            // Billcode is missing or empty
            request.setAttribute("error", "Billcode is missing or invalid.");
            request.getRequestDispatcher("payment-failed.jsp").forward(request, response);
        }
    }
}
