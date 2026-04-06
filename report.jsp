<%-- 
    Document   : report
    Created on : 31 May 2024, 10:05:34 pm
    Author     : nurs2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentWise | Reports</title>
    <style>
        :root {
            --primary-color: #ff6a00;
            --background-color: #EEF7FF;
        }

        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            font-weight: 500;
            background-color: var(--background-color);
        }

        body {
            display: flex;
            flex-direction: column;
        }

        /*Top Navigation*/
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 5px 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .nav-logo {
            width: 70px;
            height: 70px;
            cursor: pointer;
        }

        .nav-bar {
            display: flex;
            list-style: none;
            gap: 2.3em;
            margin: 0;
            padding: 0;
            z-index: 10;
        }

        .nav-bar li a {
            text-decoration: none;
            font-size: 19px;
            color: black;
        }

        .nav-bar li a:hover {
            color: var(--primary-color);
            transition: all ease 0.3s;
        }
        
        .nav-button {
            z-index: 10;
        }

        .nav-button a.button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: grey;
            opacity: 70%;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            font-weight: 500;
        }

        .nav-button a.button1 {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: transparent;
            color: black;
            text-decoration: none;
            text-align: center;
            font-weight: 500;
        }

        .nav-button a.button:hover {
            background-color: var(--primary-color);
            color: white;
            opacity: 100%;
            transition: all ease 0.3s;
        }

        .nav-button a.button1:hover {
            color: white;
            background-color: var(--primary-color);
            border-radius: 5px;
            transition: all ease 0.3s;
        }

        /* Content */
        .container {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 2em;
            gap: 2em;
        }

        .heading {
            font-size: 2.5em;
            text-align: center;
        }
        

        .report-section {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 80%;
            margin-bottom: 20px;
        }

        .report-section h3 {
            text-align: center;
            margin-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: var(--primary-color);
            color: white;
        }

        /*Footer*/
        footer {
            width: 100%;
            background-color: #FF5F00;
            text-align: center;
            color: white;
            padding: 1em;
            margin-top: auto;
        }
        
        @media print {
            .nav-bar, .nav-button, .print-button, footer {
                display: none;
            }
            .report-section {
                box-shadow: none;
                width: 100%;
            }
        }
    </style>
    <script>
        function filterByMonth() {
            const selectedMonth = document.getElementById("monthFilter").value;
            window.location.href = "report.jsp?month=" + selectedMonth;
        }
        
        function printReport() {
            window.print();
        }
      
    </script>
</head>
<body>
    <!-- Nav Bar -->
    <nav>
        <img class="nav-logo" src="asset/sedan.png" alt="Logo">
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

    <!-- Content -->
    <div class="container">
        <p class="heading"><b>Car Rent Reports</b></p>
        
        <!-- Booking Report Section -->
        <div class="report-section">
            <label for="monthFilter">Filter by Month:</label>
            <select id="monthFilter" onchange="filterByMonth()">
                <option value="all" <%= request.getParameter("month") == null || "all".equals(request.getParameter("month")) ? "selected" : "" %>>All</option>
                <%
                    // Generate month options
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat monthDate = new SimpleDateFormat("MMMM");
                    String monthFilter = request.getParameter("month");
                    for (int i = 0; i < 12; i++) {
                        cal.set(Calendar.MONTH, i);
                        String monthName = monthDate.format(cal.getTime());
                        out.println("<option value=\"" + (i + 1) + "\" " + (monthFilter != null && monthFilter.equals(String.valueOf(i + 1)) ? "selected" : "") + ">" + monthName + "</option>");
                    }
                %>
            </select>
            <table>
                <thead>
                    <tr>
                        <th>Rental ID</th>
                        <th>Car ID</th>
                        <th>Student ID</th>
                        <th>Rental Duration</th>
                        <th>Rental Start Date</th>
                        <th>Rental Start Time</th>
                        <th>Rental Return Date</th>
                        <th>Rental Return Time</th>
                        <th>Rental Fees</th>
                        <th>Rental Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Database connection and query execution
                        Connection conn = null;
                        Statement stmt = null;
                        ResultSet rs = null;

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentwise", "root", "");
                            stmt = conn.createStatement();
                            String sql;

                            if (monthFilter != null && !monthFilter.equals("all")) {
                                sql = "SELECT * FROM rental WHERE MONTH(rental_startDate) = " + monthFilter;
                            } else {
                                sql = "SELECT * FROM rental";
                            }
                            rs = stmt.executeQuery(sql);

                            // Iterate through the result set and display data
                            while (rs.next()) {
                                int rental_id = rs.getInt("rental_id");
                                int car_id = rs.getInt("car_id");
                                String student_id = rs.getString("student_id");
                                int rental_duration = rs.getInt("rental_duration");
                                java.sql.Date rental_startDate = rs.getDate("rental_startDate");
                                java.sql.Time rental_startTime = rs.getTime("rental_StartTime");
                                java.sql.Date rental_returnDate = rs.getDate("rental_returnDate");
                                java.sql.Time rental_returnTime = rs.getTime("rental_ReturnTime");
                                double rental_fees = rs.getDouble("rental_fees");
                                String rental_status = rs.getString("rental_status");
                    %>
                    <tr>
                        <td><%= rental_id %></td>
                        <td><%= car_id %></td>
                        <td><%= student_id %></td>
                        <td><%= rental_duration %></td>
                        <td><%= rental_startDate %></td>
                        <td><%= rental_startTime %></td>
                        <td><%= rental_returnDate %></td>
                        <td><%= rental_returnTime %></td>
                        <td><%= rental_fees %></td>
                        <td><%= rental_status %></td>
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
                </tbody>
            </table>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 RentWise. All rights reserved.</p>
    </footer>
</body>
</html>
