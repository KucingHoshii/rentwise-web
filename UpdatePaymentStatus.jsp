<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Payment Status</title>
    <link rel="stylesheet" type="text/css" href="stylecar.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #EEF7FF;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
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
        input[type="submit"],
        select {
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Update Payment Status</h1>
        <%
            String paymentId = request.getParameter("paymentId");
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String paymentStatus = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentwise", "root", "");
                String sql = "SELECT payment_status FROM payment WHERE payment_id=?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, paymentId);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    paymentStatus = rs.getString("payment_status");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
        <form action="UpdatePaymentStatusServlet" method="post">
            <input type="hidden" name="paymentId" value="<%= paymentId %>">

            <label for="paymentStatus">Payment Status:</label>
            <select id="paymentStatus" name="paymentStatus" required>
                <option value="Paid" <%= paymentStatus.equals("Paid") ? "selected" : "" %>>Paid</option>
                <option value="Unpaid" <%= paymentStatus.equals("Unpaid") ? "selected" : "" %>>Unpaid</option>
            </select>

            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
