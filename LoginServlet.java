import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student_id = request.getParameter("student_id");
        String student_password = request.getParameter("student_password");

        UserDao userDao = new UserDao();
        User user = userDao.validateUser(student_id, student_password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("studentId", user.getStudent_id());
            session.setAttribute("userName", user.getStudent_name());
            session.setAttribute("userEmail", user.getStudent_email());
            session.setAttribute("userContact", user.getStudent_contact());
            session.setAttribute("userAddress", user.getAddress()); // Ensure user address is set
            
            System.out.println("User: " + user);
            System.out.println("Session Attributes: " + session.getAttribute("studentId") + ", " + session.getAttribute("userName") + ", " + session.getAttribute("userEmail") + ", " + session.getAttribute("userContact") + ", " + session.getAttribute("userAddress"));

            response.sendRedirect("profile.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid student ID or password");
            request.getRequestDispatcher("signInUser.jsp").forward(request, response);
        }
    }
}
