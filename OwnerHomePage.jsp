<%-- 
    Document   : OwnerHomePage
    Created on : 1 Jun 2024, 10:55:04 am
    Author     : nurs2
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentWise | Owner Home</title>
    <style>
        :root {
            --primary-color: #ff6a00;
            --background-color: #EEF7FF;
        }

        html {
            background-color: var(--background-color);
            font-family: 'Poppins', sans-serif;
            font-weight: 500;
            scroll-behavior: smooth;
            overflow-x: hidden;
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

        .content {
            text-align: center;
        }

        .owner-actions {
            display: flex;
            justify-content: center;
            gap: 1em;
            flex-wrap: wrap;
        }

        .owner-action {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease;
            width: 250px;
            text-decoration: none;
            color: inherit;
        }

        .owner-action:hover {
            transform: translateY(-5px);
        }

        .owner-action img {
            width: 100px;
            height: 100px;
            margin-bottom: 10px;
        }

        .owner-action h3 {
            font-size: 1.2em;
            margin-bottom: 5px;
        }

        .owner-action a {
            text-decoration: none;
            color: inherit;
        }

        /*Footer*/
        footer {
            width: 100%;
            background-color: #FF5F00;
            text-align: center;
            color: white;
            padding: 1em;
            position: fixed;
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body>
    <!-- Nav Bar -->
    <nav>
        <img class="nav-logo" src="asset/sedan.png" alt="Logo">
        <ul class="nav-bar">
            <li><a href="OwnerHomePage.jsp">Home</a></li>
            <li><a href="managebooking.jsp">Manage Booking</a></li>
            <li><a href="StaffRegistration.jsp">Staff Registration</a></li>
            <li><a href="ownerReport.jsp">Report</a></li>
        </ul>
        <div class="nav-button">
            <a href="profile.html" class="button1">Profile</a>
            <a href="logout.html" class="button">Logout</a>
        </div>        
    </nav>

    <!-- Content -->
    <div class="container">
        <div class="content">
            <p class="heading"><b>Welcome to Owner Portal</b></p>
            <div class="owner-actions">
                <a href="managebooking.jsp" class="owner-action">
                    <img src="booking.png" alt="Manage Booking">
                    <h3>Manage Booking</h3>
                </a>
                <a href="StaffRegistration.jsp" class="owner-action">
                    <img src="asset/staff.png" alt="Staff Registration">
                    <h3>Staff Registration</h3>
                </a>
                <a href="ownerReport.jsp" class="owner-action">
                    <img src="asset/gnrt.png" alt="Generate Reports">
                    <h3>Generate Reports</h3>
                </a>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 RentWise. All rights reserved.</p>
    </footer>
</body>
</html>
