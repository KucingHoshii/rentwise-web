/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

//import com.DAO.ReturnCarDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@WebServlet("/ReturnCarServlet")
//public class ReturnCarServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private ReturnCarDAO carDAO;
//
//    @Override
//    public void init() throws ServletException {
//        carDAO = new ReturnCarDAO();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String staffID = request.getParameter("staffID");
//        String carID = request.getParameter("carID");
//        String studentID = request.getParameter("studentID");
//        String returnDate = request.getParameter("returnDate");
//        String returnTime = request.getParameter("returnTime");
//        String damage = request.getParameter("damage");
//        String carCondition = request.getParameter("carcondition");
//        String addCharge = request.getParameter("addcharge");
//
//        // Check for null or empty required fields
//        if (staffID == null || staffID.isEmpty() || carID == null || carID.isEmpty() || studentID == null || studentID.isEmpty() ||
//            returnDate == null || returnDate.isEmpty() || returnTime == null || returnTime.isEmpty()) {
//            out.println("All required fields must be filled out.");
//            return;
//        }
//
//        // Convert time to 24-hour format if needed
//        String returnTime24Hour = (returnTime != null && !returnTime.isEmpty()) ? convertTo24HourFormat(returnTime) : "";
//
//        try {
//            // Insert car return information into the database
//            boolean success = carDAO.returnCar(staffID, carID, studentID, returnDate, returnTime24Hour, damage, carCondition, addCharge);
//
//            // Send response
//            if (success) {
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<style>");
//                out.println("body {font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center;}");
//                out.println(".confirmation {background: #c3c4cc; padding: 20px; max-width: 600px; margin: 30px auto; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center;}");
//                out.println(".confirmation h1 {color: #333;}");
//                out.println(".confirmation p {color: #000; display: inline-block; }");
//                out.println("</style>");
//                out.println("<script type=\"text/javascript\">");
//                out.println("alert('Data successfully entered!');");
//                out.println("</script>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<div class='confirmation'>");
//                out.println("<title>Return Car Details</title>");
//                out.println("<h1>Return Car Details</h1>");
//                out.println("<p>Staff ID : " + staffID + "</p><br>");
//                out.println("<p>Car ID : " + carID + "</p><br>");
//                out.println("<p>Student ID : " + studentID + "</p><br>");
//                out.println("<p>Return Date : " + returnDate + "</p><br>");
//                out.println("<p>Return Time : " + returnTime24Hour + "</p><br>");
//                out.println("<p>Damage : " + (damage.equals("1") ? "Yes" : "No") + "</p><br>");
//                if ("1".equals(damage)) {
//                    out.println("<p>Condition : " + carCondition + "</p><br>");
//                    out.println("<p>Additional Charge : " + addCharge + "</p>");
//                }
//                out.println("</div>");
//                out.println("</body>");
//                out.println("</html>");
//            } else {
//                out.println("Error inserting the return car details.");
//            }
//        } catch (Exception e) {
//            out.println("Exception occurred: " + e.getMessage());
//            e.printStackTrace(out);
//        }
//    }
//
//
//    // Helper method to convert time to 24-hour format
//    private String convertTo24HourFormat(String time) {
//        try {
//            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
//            SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm");
//            Date date = parseFormat.parse(time);
//            return displayFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return time;
//        }
//    }
//}
// ni before buat SaveReturnedCar.jsp & listReturnedCar.jsp

import DAO.ReturnCarDAO;

import model.ReturnCar;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReturnCarServlet")
public class ReturnCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReturnCarDAO carDAO;

    public ReturnCarServlet() {
        super();
        carDAO = new ReturnCarDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listCarDetails(request, response);
        } else {
            switch (action) {
                case "save":
                    saveCarDetails(request, response);
                    break;
                case "list":
                    listCarDetails(request, response);
                    break;
                case "edit":
                    editCarDetails(request, response);
                    break;
                case "delete":
                    deleteCarDetails(request, response);
                    break;
                case "addNew":
                    addNewReturnCarForm(request, response);
                    break;
                default:
                    response.getWriter().println("Invalid action.");
            }
        }
    }

    private void saveCarDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffID = request.getParameter("staffID");
        String car_id = request.getParameter("car_id");
        String student_id = request.getParameter("student_id");
        String returnDate = request.getParameter("returnDate");
        String returnTime = request.getParameter("returnTime");
        String damage = request.getParameter("damage");
        String carCondition = request.getParameter("carcondition");
        String addCharge = request.getParameter("addcharge");

        // Validate required fields
        if (staffID == null || staffID.isEmpty() || car_id == null || car_id.isEmpty() ||
            student_id == null || student_id.isEmpty() || returnDate == null || returnDate.isEmpty() ||
            returnTime == null || returnTime.isEmpty()) {
            response.getWriter().println("All required fields must be filled out.");
            return;
        }

        // Convert time to 24-hour format if needed
        String returnTime24Hour = convertTo24HourFormat(returnTime);

        // Save to database
        boolean success = carDAO.saveCarDetails(staffID, car_id, student_id, returnDate, returnTime24Hour, damage, carCondition, addCharge);

        if (success) {
            // Redirect to list action
            response.sendRedirect("ReturnCarServlet?action=list");
            response.getWriter().println("Returned car details successfully entered!");
        } else {
            response.getWriter().println("Error saving the car details.");
        }
    }

    private void listCarDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReturnCar> returnedCars = carDAO.getAllReturnedCars();

        request.setAttribute("returnedCars", returnedCars);
        request.getRequestDispatcher("/ReturnCarList.jsp").forward(request, response);
    }

    private void editCarDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.getWriter().println("No ID provided.");
            return;
        }

        String action = request.getParameter("action");

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            try {
                int id = Integer.parseInt(idParam);
                ReturnCar car = carDAO.getCarDetailsById(id);
                if (car != null) {
                    request.setAttribute("car", car);
                    request.getRequestDispatcher("/ReturnCarEdit.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Car not found with ID: " + id);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.getWriter().println("Invalid car ID.");
            }
        } else if ("POST".equalsIgnoreCase(request.getMethod()) && "edit".equals(action)) {
            String staffID = request.getParameter("staffID");
            String car_id = request.getParameter("car_id");
            String student_id = request.getParameter("student_id");
            String returnDate = request.getParameter("returnDate");
            String returnTime = request.getParameter("returnTime");
            String damage = request.getParameter("damage");
            String carCondition = request.getParameter("carCondition");
            String addCharge = request.getParameter("addCharge");

            try {
                int id = Integer.parseInt(idParam);
                boolean success = carDAO.editCarDetails(staffID, car_id, student_id, returnDate, returnTime, damage, carCondition, addCharge, id);
                if (success) {
                    response.sendRedirect("ReturnCarServlet?action=list");
                } else {
                    response.getWriter().println("Error updating car details.");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.getWriter().println("Invalid car ID.");
            }
        }
    }

    private void deleteCarDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            response.getWriter().println("No ID provided.");
            return;
        }

        try {
            int id = Integer.parseInt(idParam);
            boolean success = carDAO.deleteCarDetails(id);
            if (success) {
                response.sendRedirect("ReturnCarServlet?action=list");
            } else {
                response.getWriter().println("Error deleting the car details with ID: " + id);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid car ID or SQL error.");
        }
    }

    private void addNewReturnCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ReturnCar.jsp").forward(request, response);
    }

    private String convertTo24HourFormat(String time) {
        try {
            SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
            Date date = parseFormat.parse(time);
            return displayFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return time; // Return original time if parsing fails
        }
    }
}