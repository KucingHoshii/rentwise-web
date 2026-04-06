<%-- 
    Document   : cancelBooking
    Created on : 24 Jun 2024, 5:59:19 pm
    Author     : afiqa
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="images/RentWiseFavIcon.svg">
    <title>RentWise | Cancel Booking</title>
    <link rel="stylesheet" href="css/basicStyle.css">
    <style>
        .message-container {
            text-align: center;
            margin-top: 150px;
        }
        .message {
            font-size: 1.5em;
            color: green;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <!-- Include Header -->
    <jsp:include page="header.jsp"/>
    
    <%
        //Get userId to pass back to booking.jsp
        String userId = request.getParameter("userId");
    %>

    <!-- Main Content Section -->
    <div class="message-container">
        <p class="message">Booking Was Successfully Cancelled!</p>
        <a class="back-link" href="booking.jsp?userId=<%= userId %>">Find Another Car</a>
        <p>User Id <%= userId %></p>
    </div>

    <!-- Include Footer -->
    <jsp:include page="footer.jsp"/>
</body>
</html>

