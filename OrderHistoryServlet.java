import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Rental;

@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Initialize session
        HttpSession session = request.getSession();
        
        // Get user id from session
        String userId = (String) session.getAttribute("userId");
        
        // Get rental history by userId
        List<Rental> userRentalHistory = RentalDao.getUserRentalHistory(userId);
        
        // Check if userRentalHistory is null or empty
        if (userRentalHistory == null || userRentalHistory.isEmpty()) {
            // Handle the case where there is no rental history
            request.setAttribute("errorMessage", "No rental history found.");
        } else {
            // Fetch car details for each rental and store in the rental object
            for (Rental rental : userRentalHistory) {
                Car car = CarDao.getCarById(rental.getCarId());
                rental.setCar(car); // Assume Rental class has a setCar method
            }
            
            // Pass data to JSP
            request.setAttribute("userRentalHistory", userRentalHistory);
        }
        
        // Forward to orderHistory.jsp
        request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
