import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Rental;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author afiqa
 */
public class RentalDao {
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
    
    public static int insertRental(Rental r) {
        int status = 0;
         String sql = "INSERT INTO rental (rental_id, car_id, student_id, rental_duration, rental_startDate, rental_StartTime, rental_returnDate, "
                 + " rental_ReturnTime , rental_fees, rental_status) VALUES (?, ?, ?, ?, ?, ?, ?, ? , ? , ?)";
         try (Connection con = CarDao.getConnection();
              PreparedStatement ps = con.prepareStatement(sql)) {

             ps.setInt(1, r.getRentalId());
             ps.setInt(2, r.getCarId());
             ps.setString(3, r.getStudentId());
             ps.setInt(4, r.getRentalDuration());
             ps.setDate(5, r.getStartDate());
             ps.setTime(6, r.getStartTime());
             ps.setDate(7, r.getReturnDate());
             ps.setTime(8, r.getReturnTime());
             ps.setDouble(9, r.getRentalFees());
             ps.setString(10, r.getRentalStatus());

             status = ps.executeUpdate();

             con.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return status;
    }
    
    public static Rental getSelectedRentalByRentalId(int rentalId) {
         Rental rental = new Rental();
         try {
             Connection con = CarDao.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from rental where rental_id = ?");
             ps.setInt(1, rentalId);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 rental.setRentalId(rs.getInt(1));
                 rental.setCarId(rs.getInt(2));
                 rental.setStudentId(rs.getString(3));
                 rental.setRentalDuration(rs.getInt(4));
                 rental.setStartDate(rs.getDate(5));
                 rental.setStarTime(rs.getTime(6));
                 rental.setReturnDate(rs.getDate(7));
                 rental.setReturnTime(rs.getTime(8));
                 rental.setRentalFees(rs.getDouble(9));
                 rental.setRentalStatus(rs.getString(10));
             } 
             con.close();
         } catch (Exception exp) {
             exp.printStackTrace();
         }
         return rental;
    }
    
        public static Rental getSelectedRentalByUserId(String userId) {
         Rental rental = new Rental();
         try {
             Connection con = CarDao.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from rental where student_id = ?");
             ps.setString(1, userId);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 rental.setRentalId(rs.getInt(1));
                 rental.setCarId(rs.getInt(2));
                 rental.setStudentId(rs.getString(3));
                 rental.setRentalDuration(rs.getInt(4));
                 rental.setStartDate(rs.getDate(5));
                 rental.setStarTime(rs.getTime(6));
                 rental.setReturnDate(rs.getDate(7));
                 rental.setReturnTime(rs.getTime(8));
                 rental.setRentalFees(rs.getDouble(9));
                 rental.setRentalStatus(rs.getString(10));
             }
             con.close();
         } catch (Exception exp) {
             exp.printStackTrace();
         }
         return rental;
    }
     
    public static List<Rental> getUserRentalHistory(String userId) {
        List<Rental> rental = new ArrayList<>();
        String sql = "select * from rental where student_id = ?";
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                 Rental rent = new Rental();
                 rent.setRentalId(rs.getInt(1));
                 rent.setCarId(rs.getInt(2));
                 rent.setStudentId(rs.getString(3));
                 rent.setRentalDuration(rs.getInt(4));
                 rent.setStartDate(rs.getDate(5));
                 rent.setStarTime(rs.getTime(6));
                 rent.setReturnDate(rs.getDate(7));
                 rent.setReturnTime(rs.getTime(8));
                 rent.setRentalFees(rs.getDouble(9));
                 rent.setRentalStatus(rs.getString(10));
                 rental.add(rent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rental;
    }
    
    public static int updateRentalStatus(String rentalStatus , int rentalId){
        int status = 0;
        String sql = "update rental set rental_status = ? where rental_id = ?";
        try (Connection con = CarDao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rentalStatus);
            ps.setInt(2, rentalId);
            

            status = ps.executeUpdate();
            
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public static boolean updateRentalDateTime(int rentalId, int rentalDuration , Date newPickupDate, Time newPickupTime, Date newReturnDate, Time newReturnTime) {
        boolean success = false;
        try {
            Connection con = RentalDao.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE rental SET rental_duration=? , rental_startDate = ? , rental_StartTime = ? ,"
                    + " rental_returnDate = ? , rental_ReturnTime = ? WHERE rental_id = ?");
            ps.setInt(1, rentalDuration );
            ps.setDate(2, (java.sql.Date) newPickupDate);
            ps.setTime(3, newPickupTime);
            ps.setDate(4, (java.sql.Date) newReturnDate);
            ps.setTime(5, newReturnTime);
            ps.setInt(6,rentalId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public static int deleteRental(int rentalId) {
        int status = 0;
        try {
            Connection con = RentalDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from rental where rental_id=?");
            ps.setInt(1, rentalId);

            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
