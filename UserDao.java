import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserDao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rentwise", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    public static int registerUser(User e) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO student (student_id, student_name, student_password,student_email,student_contact) VALUES (?, ?, ?, ? , ?)"); 
            
            ps.setString(1, e.getStudent_id());
            ps.setString(2, e.getStudent_name());
            ps.setString(3, e.getStudent_password());
            ps.setString(4, e.getStudent_email());
            ps.setInt(5, e.getStudent_contact());
            
            status = ps.executeUpdate();
            
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        
        return status;
    }

    public User validateUser(String student_id, String student_password) {
        User user = null;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE student_id = ? and student_password = ?");
            ps.setString(1, student_id);
            ps.setString(2, student_password); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setStudent_id(rs.getString("student_id"));
                user.setStudent_name(rs.getString("student_name"));
                user.setStudent_password(rs.getString("student_password"));
                user.setStudent_email(rs.getString("student_email"));
                user.setStudent_contact(rs.getInt("student_contact"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user; // Return user object if found, otherwise return null
    }
    
    public static User getUserById(String studentId) {
        User user = null;
        try {
            Connection con = getConnection();
            String query = "SELECT * FROM student WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setStudent_id(rs.getString("student_id"));
                user.setStudent_name(rs.getString("student_name"));
                user.setStudent_password(rs.getString("student_password"));
                user.setStudent_email(rs.getString("student_email"));
                user.setStudent_contact(rs.getInt("student_contact"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}


//    public static User getUserById(int id) {
//        User e = new User();
//
//        try {
//            Connection con = UserDao.getConnection();
//            PreparedStatement ps = con.prepareStatement("select * from users where id=?");
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                e.setId(rs.getInt("id"));
//                e.setUsername(rs.getString("username"));
//                e.setPassword(rs.getString("password"));
//                e.setRole(rs.getString("role"));
//            }
//            con.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return e;
//    }

