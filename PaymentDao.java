
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Payment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author afiqa
 */
public class PaymentDao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rentwise", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static Payment getPaymentById(String paymentId) {
        Payment payment = null;
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM payment WHERE payment_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, paymentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                payment = new Payment();
                payment.setPaymentId(rs.getString(1));
                payment.setRentalId(rs.getInt(2));
                payment.setPaymentAmount(rs.getDouble(3));
                payment.setPaymentMethod(rs.getString(4));
                payment.setPaymentStatus(rs.getString(5));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }
    
    public static int insertPayment(Payment e) {
        int status = 0;
        String sql = "INSERT INTO payment (payment_id, rental_id , payment_amount, payment_method, payment_status) VALUES (?,?, ?, ?, ?)";
        try (Connection con = CarDao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getPaymentId());
            ps.setInt(2, e.getRentalId());
            ps.setDouble(3, e.getPaymentAmount());
            ps.setString(4, e.getPaymentMethod());
            ps.setString(5, e.getPaymentStatus());

            status = ps.executeUpdate();
            
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static int updatePaymentRentalId(Payment e){
        int status = 0;
        String sql = "update payment set rental_id = ? where payment_id = ?";
        try (Connection con = CarDao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getRentalId());
            ps.setString(2, e.getPaymentId());
            

            status = ps.executeUpdate();
            
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }


        public static int updatePaymentStatus(Payment e) {
            int status = 0;
            String sql = "UPDATE payment SET payment_method = ? , payment_status = ? WHERE payment_id = ?";

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, e.getPaymentMethod());                          
                ps.setString(2, e.getPaymentStatus());
                ps.setString(3, e.getPaymentId());

                status = ps.executeUpdate();
                
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return status;
        }

        public static int deleteRentalByPaymentId(Payment e) {
            int status = 0;
            String sql = "DELETE FROM rental WHERE payment_id = ?";

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, e.getPaymentId());

                ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return status;
        }

        public static int deletePaymentByPaymentId(Payment e) {
            int status = 0;
            String sql = "DELETE FROM payment WHERE payment_id = ?";

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, e.getPaymentId());

                ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return status;
        }
}

