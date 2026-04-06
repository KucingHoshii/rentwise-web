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

@WebServlet("/UpdateCarServlet")
@MultipartConfig
public class UpdateCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost/rentwise";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = request.getParameter("carId");
        String carType = request.getParameter("carType");
        String carModel = request.getParameter("carModel");
        String carPriceStr = request.getParameter("carPrice");
        double carPrice = 0.0;
        if (carPriceStr != null && !carPriceStr.trim().isEmpty()) {
            carPrice = Double.parseDouble(carPriceStr);
        }
        Part filePart = request.getPart("carPic");

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql;
            if (filePart != null && filePart.getSize() > 0) {
                // Update with new image
                sql = "UPDATE car SET car_type = ?, car_model = ?, car_price = ?, car_pic = ? WHERE car_id = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, carType);
                statement.setString(2, carModel);
                statement.setDouble(3, carPrice);
                InputStream inputStream = filePart.getInputStream();
                statement.setBlob(4, inputStream);
                statement.setString(5, carId);
            } else {
                // Update without new image
                sql = "UPDATE car SET car_type = ?, car_model = ?, car_price = ? WHERE car_id = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, carType);
                statement.setString(2, carModel);
                statement.setDouble(3, carPrice);
                statement.setString(4, carId);
            }

            // Execute the query
            int row = statement.executeUpdate();

            if (row > 0) {
                // Successfully updated
                response.sendRedirect("success.jsp");
            } else {
                // Failed to update
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
