/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/AddCarServlet")
@MultipartConfig
public class AddCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost/rentwise";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = request.getParameter("carId");
        String carOwnerID = request.getParameter("carOwnerID");    
        String carModel = request.getParameter("carModel");
        double carPrice = Double.parseDouble(request.getParameter("carPrice"));
        String carType = request.getParameter("carType");
        Part filePart = request.getPart("carPic");

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert new car
            String sql = "INSERT INTO car (car_id, carOwner_id,car_model, car_price, car_type, car_pic) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
          
            statement.setString(1, carId);
            statement.setInt(2, Integer.parseInt(carOwnerID));
            statement.setString(3, carModel);
            statement.setDouble(4, carPrice);
            statement.setString(5, carType);

            if (filePart != null && filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                statement.setBlob(6, inputStream);
            } else {
                statement.setNull(6, java.sql.Types.BLOB);
            }

            // Execute the query
            int row = statement.executeUpdate();

            if (row > 0) {
                // Successfully inserted
                response.sendRedirect("success.jsp");
            } else {
                // Failed to insert
                response.sendRedirect("error.jsp");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
