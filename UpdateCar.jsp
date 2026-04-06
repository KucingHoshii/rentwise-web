<%-- 
    Document   : UpdateCar
    Created on : 31 May 2024, 3:08:27 pm
    Author     : nurs2
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.annotation.MultipartConfig" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Car</title>
    <link rel="stylesheet" type="text/css" href="stylecar.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #EEF7FF;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin: 10px 0 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"],
        input[type="submit"] {
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .form-check {
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <!-- Nav Bar -->
    <nav>
        <img class="nav-logo" src="asset/sedan.png" alt="">
        <ul class="nav-bar">
            <li><a href="StaffHomePage.jsp">Home</a></li>
            <li><a href="">Manage Payment</a></li>
            <li><a href="displaycar.jsp">Manage Car</a></li>
            <li><a href="">Return Car</a></li>
            <li><a href="report.jsp">Report</a></li>
        </ul>
        <div class="nav-button">
        <a href="profile.html" class="button1">Profile</a>
        <a href="logout.html" class="button">Logout</a>
      </div>
    </nav>
    <div class="container">
        <h1>Update Car</h1>
        <%
            String carId = request.getParameter("carID");
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String carType = "", carModel = "", base64Image = "";
            double carPrice = 0;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/rentwise", "root", "");
                String sql = "SELECT * FROM car WHERE car_id=?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, carId);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    carType = rs.getString("car_type");
                    carModel = rs.getString("car_model");
                    carPrice = rs.getDouble("car_price");

                    Blob imageBlob = rs.getBlob("car_pic");
                    if (imageBlob != null) {
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
                    }
                }
              %>
        <form action="UpdateCarServlet" method="post" enctype="multipart/form-data">
            <label for="carId">Car Plate:</label>
            <input type="text" id="carId" name="carId" value="<%= carId %>" readonly>

            <label for="carType">Car Type:</label>
            <input type="text" id="carType" name="carType" value="<%= carType %>" required>

            <label for="model">Car Model:</label>
            <input type="text" id="carModel" name="carModel" value="<%= carModel %>" required>

            <label for="carPrice">Rate:</label>
            <input type="number" step="0.01" id="carPrice" name="carPrice" value="<%= carPrice %>" required>

            <label for="carPic">Car Image:</label>
            <% if (!base64Image.isEmpty()) { %>
                <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Car Image" width="100"><br>
            <% } %>
            <input type="file" id="carPic" name="carPic" accept="image/*">

            <input type="submit" value="Submit">
        </form>
            
          <%              } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </div>
    <footer>
        <p>&copy; 2024 RentWise</p>
    </footer>
</body>
</html>
