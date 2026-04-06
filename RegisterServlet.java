import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Retrieve data from the from before
        String student_id = request.getParameter("student_id");
        String student_name = request.getParameter("student_name");
        String student_password = request.getParameter("student_password");
        String student_email = request.getParameter("student_email");
        String student_contact = request.getParameter("student_contact");

        User e = new User();
        e.setStudent_id(student_id);
        e.setStudent_name(student_name);
        e.setStudent_password(student_password); 
        e.setStudent_email(student_email);
        e.setStudent_contact(Integer.parseInt(student_contact));

        int status = UserDao.registerUser(e);
        if(status>0){
            response.sendRedirect("signInUser.html");
        } else{
            response.sendRedirect("confirmTest.jsp");
        }
        
        out.close();
    }
}
