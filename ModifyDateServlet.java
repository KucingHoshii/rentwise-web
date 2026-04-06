import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Rental;

@WebServlet("/ModifyDateServlet")
public class ModifyDateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String newPickupDateStr = request.getParameter("newPickupDate");
        String newPickupTimeStr = request.getParameter("newPickupTime");
        String newReturnDateStr = request.getParameter("newReturnDate");
        String newReturnTimeStr = request.getParameter("newReturnTime");
        int rentalId = Integer.parseInt(request.getParameter("bookingId"));
        int carId = Integer.parseInt(request.getParameter("car_Id"));

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");

        Date newPickupDate = null;
        Time newPickupTime = null;
        Date newReturnDate = null;
        Time newReturnTime = null;

        try {
            newPickupDate = new Date(dateFormatter.parse(newPickupDateStr).getTime());
            newPickupTime = new Time(timeFormatter.parse(newPickupTimeStr).getTime());
            newReturnDate = new Date(dateFormatter.parse(newReturnDateStr).getTime());
            newReturnTime = new Time(timeFormatter.parse(newReturnTimeStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date/time format");
            return;
        }
        
        // Convert to LocalDate for date calculations
        LocalDate pickupLocalDate = newPickupDate.toLocalDate();
        LocalDate returnLocalDate = newReturnDate.toLocalDate();
        
        // Calculate the number of days between the dates
        int daysBetween = (int) ChronoUnit.DAYS.between(pickupLocalDate, returnLocalDate);
        daysBetween = daysBetween == 0 ? 1 : daysBetween; // Minimum one day charge

        // Update the date in the database
        RentalDao rentalDao = new RentalDao();
        boolean success = RentalDao.updateRentalDateTime(rentalId, daysBetween, newPickupDate, newPickupTime, newReturnDate, newReturnTime);

        if (success) {
            // Initialize session
            HttpSession session = request.getSession();
            
            //Get User id
            String userId = (String) session.getAttribute("userId");

            // Get car details based on carId
            Car car = CarDao.getCarById(carId);

            // Calculate the total price
            double carPrice = car.getCarPrice();
            double totalPrice = carPrice * daysBetween;

            // Format the date and time for display
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd, h:mm a");
            String formattedPickupDateTime = LocalDateTime.of(pickupLocalDate, newPickupTime.toLocalTime()).format(dateTimeFormatter);
            String formattedReturnDateTime = LocalDateTime.of(returnLocalDate, newReturnTime.toLocalTime()).format(dateTimeFormatter);
            
            // Insert rental into the database
            Rental rental = new Rental();
            rental.setRentalId(rentalId);
            rental.setCarId(carId);
            rental.setStudentId(userId); 
            rental.setRentalDuration(daysBetween);
            rental.setStartDate(newPickupDate);
            rental.setStarTime(newPickupTime);
            rental.setReturnDate(newReturnDate);
            rental.setReturnTime(newReturnTime);
            rental.setRentalFees(totalPrice);
            rental.setRentalStatus("Pending"); // Initial Value

            // Save data in session
            // Save rental information in session
            session.setAttribute("rental",rental);
            session.setAttribute("selectedCar", car);
            session.setAttribute("rentalId", rentalId);
            session.setAttribute("pickupDate", formattedPickupDateTime);
            session.setAttribute("returnDate", formattedReturnDateTime);
            session.setAttribute("daysBetween", daysBetween);
            session.setAttribute("totalPrice", totalPrice);

            // Redirect to booking to display order confirmation with new date
            response.sendRedirect("confirmOrder.jsp");
        } else {
            // Handle error scenario
            request.setAttribute("error", "Failed to update departure date.");
            request.getRequestDispatcher("payment-failed.jsp").forward(request, response);
        }
    }
}
