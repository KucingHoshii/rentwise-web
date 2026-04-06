<%-- 
    Document   : header
    Created on : 31 May 2024, 9:20:45 am
    Author     : afiqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="images/RentWiseFavIcon.svg">
        <title>RentWise | Header</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="css/basicStyle.css">
        <link rel="stylesheet" href="css/booking.css">
    </head>
    <script>
        function submitOrderHistoryForm(event) {
            event.preventDefault();
            document.getElementById('orderHistoryForm').submit();
        }
    </script>
    <body>
        <!-- Nav Bar -->
        <nav>
            <img class="nav-logo" src="images/RentWiseLogo.svg" alt="">
            <ul class="nav-bar">
                <li><a href="homepage.html">Home</a></li>
                <li><a href="booking.jsp">Rent Car</a></li>
                <li><a href="#How">How</a></li>
                <li><a href="#whyUs">About</a></li>
            </ul>
            <div class="nav-button">
                <div class="dropdown">
                    <button class="dropbtn"><i class="fas fa-user"></i></button>
                    <div class="dropdown-content">
                        <a href="profile.html">Profile</a>
                        <form id="orderHistoryForm" action="OrderHistoryServlet" method="post" style="display: none;"></form>
                        <a href="#" onclick="submitOrderHistoryForm(event)">Order History</a>
                        <a href="index.html">Log Out</a>
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>

