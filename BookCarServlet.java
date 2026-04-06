import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Rental;

@WebServlet("/bookCar")
public class BookCarServlet extends HttpServlet {
    
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
        
        //Initialized Session
        HttpSession session = request.getSession();
        
        //Retrieve data from previous page
        int carId = Integer.parseInt(request.getParameter("car_id"));
        String pickupDateStr = request.getParameter("pickup_date");
        String pickupTimeStr = request.getParameter("pickup_time");
        String returnDateStr = request.getParameter("return_date");
        String returnTimeStr = request.getParameter("return_time");

        // Get car details based on carId
        Car car = CarDao.getCarById(carId);

        // Parse the dates
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickupDate = LocalDate.parse(pickupDateStr, dateFormatter);
        LocalDate returnDate = LocalDate.parse(returnDateStr, dateFormatter);

        // Parse the times
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime pickupTime = LocalTime.parse(pickupTimeStr, timeFormatter);
        LocalTime returnTime = LocalTime.parse(returnTimeStr, timeFormatter);

        // Format the date and time for display
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd, h:mm a");
        String formattedPickupDateTime = LocalDateTime.of(pickupDate, pickupTime).format(dateTimeFormatter);
        String formattedReturnDateTime = LocalDateTime.of(returnDate, returnTime).format(dateTimeFormatter);

        // Calculate the number of days between the dates
        int daysBetween = (int) ChronoUnit.DAYS.between(pickupDate, returnDate);
        daysBetween = daysBetween == 0 ? 1 : daysBetween; // Minimum one day charge

        // Calculate the total price
        double carPrice = car.getCarPrice();
        double totalPrice = carPrice * daysBetween;

        // Generate Rental ID and Insert rental with status 'Pending'
        Random random = new Random();
        int rentalId = 10000 + random.nextInt(90000);
        
        // Convert String dates to java.sql.Date
        java.sql.Date sqlPickupDate = java.sql.Date.valueOf(pickupDate);
        java.sql.Date sqlReturnDate = java.sql.Date.valueOf(returnDate);
        
        java.sql.Time sqlPickupTime = java.sql.Time.valueOf(pickupTime);
        java.sql.Time sqlReturnTime = java.sql.Time.valueOf(returnTime);
        
        //Get user id from user table in db
        
        //Take from session
        String userId = (String) session.getAttribute("userId") ;

        // Insert rental into the database
        Rental rental = new Rental();
        rental.setRentalId(rentalId);
        rental.setCarId(carId);
        rental.setStudentId(userId); 
        rental.setRentalDuration(daysBetween);
        rental.setStartDate(sqlPickupDate);
        rental.setStarTime(sqlPickupTime);
        rental.setReturnDate(sqlReturnDate);
        rental.setReturnTime(sqlReturnTime);
        rental.setRentalFees(totalPrice);
        rental.setRentalStatus("Pending"); // Initial Value
        
        // Save car and pickup/return details in session
        session.setAttribute("selectedCar", car);
        
        // Save rental information in session
        session.setAttribute("rental",rental);
        
        // Save original dates in the session
        session.setAttribute("originalPickupDate", pickupDateStr);
        session.setAttribute("originalReturnDate", returnDateStr);
        
        // Save original times in the session
        session.setAttribute("pickupTimeStr", pickupTimeStr);
        session.setAttribute("returnTimeStr", returnTimeStr);
        
        // Save formatted dates in the session for display
        session.setAttribute("pickupDate", formattedPickupDateTime);
        session.setAttribute("returnDate", formattedReturnDateTime);
        
        session.setAttribute("daysBetween", daysBetween);
        session.setAttribute("totalPrice", totalPrice);
        
        int rentalStatus = RentalDao.insertRental(rental);
        
        if (rentalStatus > 0) {
            session.setAttribute("rentalId", rentalId);
            response.sendRedirect("confirmOrder.jsp");
        } else {
            response.getWriter().write("Error inserting rental data into the database.");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
