import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author afiqa
 */
@WebServlet("/cancelBookingServlet")
public class cancelBookingServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Get userData that passed in hidden section
        String userId = request.getParameter("userId");
        
        // Retrieve user information that booked a car
        User user = UserDao.getUserById(userId);  
        
        //Initialized Session
        HttpSession session = request.getSession();
        
        //Store in seesion
        session.setAttribute("user", user);
        
        // Get the booking ID from the request
        String rentalIdStr = request.getParameter("rentalId");
        if (rentalIdStr == null || rentalIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Booking ID is required");
            return;
        }

        try {
            int id = Integer.parseInt(rentalIdStr);
            // Call DAO method to delete booking by ID
            int status = RentalDao.deleteRental(id);

            if (status > 0) {
                //Save back user id to the session
                
                // If booking deletion was successful, forward to confirmation page
                request.getRequestDispatcher("cancelBooking.jsp").forward(request, response);
            } else {
                // Handle error if booking deletion failed
                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Error</title></head><body>");
                out.println("<h3>Failed to cancel booking with ID: " + id + "</h3>");
                out.println("<p>Status: " + status + "</p>");
                out.println("<p>Debug information:</p>");
                out.println("<ul>");
                out.println("<li>Booking ID: " + id + "</li>");
                // You can add more debug information here as needed
                out.println("</ul>");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid booking ID format");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
        }
    }
}
