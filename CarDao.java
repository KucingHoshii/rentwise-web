import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Car;
import model.Payment;
import model.Rental;

public class CarDao {
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
    
    // Method to get car details by ID
    public static Car getCarById(int carId) {
        Car car = null;
        String query = "SELECT * FROM car WHERE car_id = ?";
        
        try (Connection connection = CarDao.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setInt(1, carId);
            ResultSet rs = ps.executeQuery();;
            
            if (rs.next()) {
                car = new Car();
                car.setCarId(rs.getString(1));
                car.setCarModel(rs.getString(3));
                car.setCarPrice(rs.getDouble(4));
                car.setCarType(rs.getString(5));
                car.setCarPic(rs.getBytes(6));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    // Method to update car availability
    public static void updateCarAvailability(String carId, String availability) {
        String query = "UPDATE car SET car_availability = ? WHERE car_id = ?";
        
        try (Connection connection = CarDao.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setString(1, availability);
            ps.setString(2, carId);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public static List<Car> getCarsByLoc(String location) {
//        List<Car> list = new ArrayList<Car>();
//
//        try {
//            Connection con = CarDao.getConnection();
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM car WHERE car_location LIKE ?");
//            ps.setString(1, "%" + location + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Car car = new Car();
//                car.setCarId(rs.getInt(1));
//                car.setCarModel(rs.getString(3));
//                car.setCarPrice(rs.getDouble(4));
//                car.setCarAvailability(rs.getString(5));
//                car.setCarLocation(rs.getString(6));
//                car.setCarType(rs.getString(7));
//                car.setCarPic(rs.getBytes(8));
//                list.add(car);
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }

//    public List<Car> getCarsByLocation(String location) {
//        List<Car> cars = new ArrayList<>();
//        String sql = "SELECT * FROM car WHERE car_location = ?";
//        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
//            statement.setString(1, location);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Car car = new Car();
//                car.setCarId(rs.getInt(1));
//                car.setCarModel(rs.getString(2));
//                car.setCarPrice(rs.getDouble(3));
//                car.setCarAvailability(rs.getString(4));
//                car.setCarLocation(rs.getString(6));
//                car.setCarType(rs.getString(7));
//                car.setCarPic(rs.getBytes(8));
//                cars.add(car);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return cars;
//    }
    
        public static List<Car> getAllCars() {
        List<Car> list = new ArrayList<Car>();

        try {
            Connection con = CarDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from car");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarId(rs.getString(1));
                car.setCarModel(rs.getString(3));
                car.setCarPrice(rs.getDouble(4));
                car.setCarType(rs.getString(5));
                car.setCarPic(rs.getBytes(6));
                list.add(car);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
        
//        public static List<Car> getAvailableCars(String location, String pickupDate, String returnDate) {
//            List<Car> cars = new ArrayList<>();
//            String sql = "SELECT c.* FROM Car c WHERE c.car_location like ? AND c.car_availability = 'Yes' "
//                   + "AND c.car_id NOT IN (SELECT r.car_id FROM Rental r WHERE (r.rental_startDate <= ? AND r.rental_returnDate >= ?))";
//            try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
//                statement.setString(1, "%"+location+"%");
//                statement.setString(2, returnDate);
//                statement.setString(3, pickupDate);
//                ResultSet rs = statement.executeQuery();
//                while (rs.next()) {
//                    Car car = new Car();
//                    car.setCarId(rs.getInt(1));
//                    car.setCarModel(rs.getString(3));
//                    car.setCarPrice(rs.getDouble(4));
//                    car.setCarAvailability(rs.getString(5));
//                    car.setCarLocation(rs.getString(6));
//                    car.setCarType(rs.getString(7));
//                    car.setCarPic(rs.getBytes(8));
//                    cars.add(car);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return cars;
//        }
       
        public static List<Car> getAvailableCars(String pickupDate, String returnDate) {
            List<Car> cars = new ArrayList<>();
            String sql = "SELECT c.* FROM Car c WHERE "
                   + "c.car_id NOT IN (SELECT r.car_id FROM Rental r WHERE (r.rental_startDate <= ? AND r.rental_returnDate >= ?))";
            try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
//                statement.setString(1, "%"+location+"%");
                statement.setString(1, returnDate);
                statement.setString(2, pickupDate);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    Car car = new Car();
                    car.setCarId(rs.getString(1));
                    car.setCarModel(rs.getString(3));
                    car.setCarPrice(rs.getDouble(4));
                    car.setCarType(rs.getString(5));
                    car.setCarPic(rs.getBytes(6));
                    cars.add(car);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cars;
        }
       
}

    
