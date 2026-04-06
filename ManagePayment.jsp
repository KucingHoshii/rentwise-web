<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Payment</title>
    <link rel="stylesheet" type="text/css" href="stylecar.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #EEF7FF;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .container {
            max-width: 1000px;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
            flex: 1;
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

        /* Footer */
        footer {
            width: 100%;
            background-color: #FF5F00;
            text-align: center;
            color: white;
            padding: 1em;
            margin-top: auto;
        }
    </style>
</head>
<body>
    <!-- Nav Bar -->
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
        <h1>Manage Payment</h1>
        <table>
            <tr>
                <th>Payment ID</th>
                <th>Rental ID</th>
                <th>Payment Amount</th>
                <th>Payment Method</th>
                <th>Payment Status</th>
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
                    String sql = "SELECT * FROM payment";
                    rs = stmt.executeQuery(sql);

                    while (rs.next()) {
                        String paymentId = rs.getString("payment_id");
                        String rentalId = rs.getString("rental_id");
                        double paymentAmount = rs.getDouble("payment_amount");
                        String paymentMethod = rs.getString("payment_method");
                        String paymentStatus = rs.getString("payment_status");
            %>
            <tr>
                <td><%= paymentId %></td>
                <td><%= rentalId %></td>
                <td><%= paymentAmount %></td>
                <td><%= paymentMethod %></td>
                <td><%= paymentStatus %></td>
                <td>
                    <a href="UpdatePaymentStatus.jsp?paymentId=<%= paymentId %>" class="button button-update">Update Status</a>
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
