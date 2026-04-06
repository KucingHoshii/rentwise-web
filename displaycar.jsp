<%-- 
    Document   : displaycar
    Created on : 31 May 2024, 3:46:15 pm
    Author     : nurs2
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Cars</title>
    <link rel="stylesheet" type="text/css" href="css/stylecar.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #EEF7FF;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1000px;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }

        .button:hover {
            background-color: #45a049;
        }

        .button-update {
            background-color: #FFA500;
        }

        .button-update:hover {
            background-color: #FF8C00;
        }

        .button-delete {
            background-color: #FF0000;
        }

        .button-delete:hover {
            background-color: #CC0000;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <nav>
        <img class="nav-logo" src="images/sedan.png" alt="">
        <ul class="nav-bar">
            <li><a href="StaffHomePage.jsp">Home</a></li>
            <li><a href="ManagePayment.jsp">Manage Payment</a></li>
            <li><a href="displaycar.jsp">Manage Car</a></li>
            <li><a href="ReturnCarList.jsp">Return Car</a></li>
            <li><a href="report.jsp">Report</a></li>
        </ul>
        <div class="nav-button">
            <a href="profile.html" class="button1">Profile</a>
            <a href="logout.html" class="button">Logout</a>
        </div>
    </nav>

    <div class="container">
        <h1>Car Inventory</h1>
        <table>
            <tr>
                <th>Car ID</th>
                <th>Car Owner ID</th>
                <th>Car Model</th>
                <th>Car Price</th>
                <th>Car Type</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
            <%
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentwise", "root", "");
                    stmt = conn.createStatement();
                    String sql = "SELECT * FROM car";
                    rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                        String carId = rs.getString("car_id");
                        int carOwnerID = rs.getInt("carOwner_id");
                        String carModel = rs.getString("car_model");
                        double carPrice = rs.getDouble("car_price");
                        String carType = rs.getString("car_type");
                        Blob imageBlob = rs.getBlob("car_pic");

                        // Convert the image blob to base64 string for display
                        String base64Image = null;
                        if (imageBlob != null) {
                            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                            base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
                        }
            %>
            <tr>
                <td><%= carId %></td>
                <td><%= carOwnerID %></td>
                <td><%= carModel %></td>
                <td><%= carPrice %></td>
                <td><%= carType %></td>
                <td>
                    <% if (base64Image != null) { %>
                        <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Car Image" width="100">
                    <% } else { %>
                        No Image
                    <% } %>
                </td>
                <td>
                    <a href="UpdateCar.jsp?carID=<%= carId %>" class="button button-update">Update</a>
                    <a href="DeleteCarServlet?carID=<%= carId %>" class="button button-delete" onclick="return confirm('Are you sure you want to delete this car?');">Delete</a>
                </td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            %>
        </table>
        
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 RentWise</p>
    </footer>
</body>
</html>
