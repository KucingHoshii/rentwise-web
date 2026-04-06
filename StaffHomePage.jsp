<%-- 
    Document   : StaffHomePage
    Created on : 31 May 2024, 4:53:37 pm
    Author     : nurs2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentWise | Staff Home</title>
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

        .staff-actions {
            display: flex;
            justify-content: center;
            gap: 1em;
            flex-wrap: wrap;
        }

        .staff-action {
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

        .staff-action:hover {
            transform: translateY(-5px);
        }

        .staff-action img {
            width: 100px;
            height: 100px;
            margin-bottom: 10px;
        }

        .staff-action h3 {
            font-size: 1.2em;
            margin-bottom: 5px;
        }

        .staff-action a {
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
        <div class="content">
            <p class="heading"><b>Welcome to Staff Portal</b></p>
            <div class="staff-actions">
                <a href="ManagePayment.jsp" class="staff-action">
                    <img src="asset/card.png" alt="Manage Payment">
                    <h3>Manage Payment</h3>
                </a>
                <a href="displaycar.jsp" class="staff-action">
                    <img src="car.png" alt="Manage Car">
                    <h3>Manage Car</h3>
                </a>
                <a href="ReturnCarList.jsp" class="staff-action">
                    <img src="return.png" alt="Manage Return Car">
                    <h3>Manage Return Car</h3>
                </a>
                <a href="report.jsp" class="staff-action">
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
