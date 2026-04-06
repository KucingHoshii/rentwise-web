/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;
import model.ReturnCar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnCarDAO {
    private static final String DB_URL = "jdbc:mysql://localhost/rentwise";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    public ReturnCarDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<ReturnCar> getAllReturnedCars() {
        List<ReturnCar> returnedCars = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM returncar");
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ReturnCar car = new ReturnCar(
                        rs.getInt("id"),
                        rs.getString("staffID"),
                        rs.getString("car_id"),
                        rs.getString("student_id"),
                        rs.getString("returnDate"),
                        rs.getString("returnTime"),
                        rs.getString("damage"),
                        rs.getString("carcondition"),
                        rs.getString("addcharge")
                );
                returnedCars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnedCars;
    }

    public ReturnCar getCarDetailsById(int id) {
        ReturnCar car = null;
        String sql = "SELECT * FROM returncar WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    car = new ReturnCar(
                            rs.getInt("id"),
                            rs.getString("staffID"),
                            rs.getString("car_id"),
                            rs.getString("student_id"),
                            rs.getString("returnDate"),
                            rs.getString("returnTime"),
                            rs.getString("damage"),
                            rs.getString("carcondition"),
                            rs.getString("addcharge")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public boolean saveCarDetails(String staffID, String car_id, String studentID,
                                  String returnDate, String returnTime, String damage, String carCondition, String addCharge) {
        String sql = "INSERT INTO returncar (staffID, car_id, student_id, returnDate, returnTime, damage, carcondition, addcharge) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffID);
            pstmt.setString(2, car_id);
            pstmt.setString(3, studentID);
            pstmt.setString(4, returnDate);
            pstmt.setString(5, returnTime);
            pstmt.setString(6, damage);
            if ("1".equals(damage)) {
                pstmt.setString(7, carCondition != null ? carCondition : "");
                pstmt.setString(8, addCharge != null ? addCharge : "0.00");
            } else {
                pstmt.setString(7, "");
                pstmt.setString(8, "0.00");
            }

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
             
    public boolean editCarDetails(String staffID, String car_id, String student_id, String returnDate, String returnTime, String damage, String carCondition, String addCharge,int id) {
        String sql = "UPDATE returncar SET staffID = ?, car_id = ?, student_id = ?, returnDate = ?, returnTime = ?, damage = ?, carcondition = ?, addcharge = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffID);
            pstmt.setString(2, car_id);
            pstmt.setString(3, student_id);
            pstmt.setString(4, returnDate);
            pstmt.setString(5, returnTime);
            pstmt.setString(6, damage);
            if ("1".equals(damage)) {
                pstmt.setString(7, carCondition != null ? carCondition : "");
                pstmt.setString(8, addCharge != null ? addCharge : "0.00");
            } else {
                pstmt.setString(7, "");
                pstmt.setString(8, "0.00");
            }
            pstmt.setInt(9, id);
            System.out.println("Executing update with ID: " + id);  // Debugging statement
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCarDetails(int id) {
        System.out.println("Deleting car details with ID: " + id);
        String sql = "DELETE FROM returncar WHERE id =?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            System.out.println("Executing delete query: " + pstmt);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

    
