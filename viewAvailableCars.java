/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;

/**
 *
 * @author afiqa
 */
public class viewAvailableCars extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        String location = request.getParameter("car_location");
        String pickupDate = request.getParameter("pickup_date");
        String pickupTime = request.getParameter("pickup_time");
        String returnDate = request.getParameter("return_date");
        String returnTime = request.getParameter("return_time");
        
        // Save search parameters to session
        HttpSession session = request.getSession();
//        session.setAttribute("carLocation", location);
        session.setAttribute("pickupDate", pickupDate);
        session.setAttribute("pickupTime", pickupTime);
        session.setAttribute("returnDate", returnDate);
        session.setAttribute("returnTime", returnTime);

        List<Car> availableCars = CarDao.getAvailableCars(pickupDate, returnDate);
        request.setAttribute("availableCars", availableCars);
        request.getRequestDispatcher("viewAvailableCars.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.Car;
//
//
//@WebServlet("/viewAvailableCars")
//public class viewAvailableCars extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        String location = request.getParameter("car_location");
//        String pickupDate = request.getParameter("pickup_date");
//        String returnDate = request.getParameter("return_date");
//
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Available Cars</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Available Cars</h1>");
//
//            if (location == null || pickupDate == null || returnDate == null) {
//                out.println("<p>Please provide location, pickup date, and return date.</p>");
//            } else {
//                List<Car> availableCars = CarDao.getAvailableCars(location,pickupDate,returnDate);
//                if (availableCars != null && !availableCars.isEmpty()) {
//                    out.println("<table border='1'>");
//                    out.println("<tr>");
//                    out.println("<th>ID</th>");
//                    out.println("<th>Model</th>");
//                    out.println("<th>Price</th>");
//                    out.println("<th>Availability</th>");
//                    out.println("<th>Location</th>");
//                    out.println("<th>Type</th>");
//                    out.println("<th>Picture</th>");
//                    out.println("</tr>");
//                    for (Car car : availableCars) {
//                        out.println("<tr>");
//                        out.println("<td>" + car.getCarId() + "</td>");
//                        out.println("<td>" + car.getCarModel() + "</td>");
//                        out.println("<td>" + car.getCarPrice() + "</td>");
//                        out.println("<td>" + car.getCarAvailability() + "</td>");
//                        out.println("<td>" + car.getCarLocation() + "</td>");
//                        out.println("<td>" + car.getCarType() + "</td>");
//                        out.println("<td><img src='data:image/jpeg;base64," + new String(java.util.Base64.getEncoder().encode(car.getCarPic())) + "' alt='Car Image' width='100' height='100'/></td>");
//                        out.println("</tr>");
//                    }
//                    out.println("</table>");
//                    out.println("<p>"+ pickupDate +"</p>");
//                    out.println("<p>"+ returnDate +"</p>");
//                } else {
//                    out.println("<p>No available cars found for the specified location and dates.</p>");
//                }
//            }
//
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}
