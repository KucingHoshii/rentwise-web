<%-- 
    Document   : UserRegister
    Created on : 1 Jun 2024, 11:39:37 am
    Author     : nurs2
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration | RentWise</title>
    <style>
        :root {
            --primary-color: #ff6a00;
            --background-color: #EEF7FF;
        }

        html {
            background-color: var(--background-color);
            font-family: 'Poppins', sans-serif;
            font-weight: 500;
            overflow-x: hidden;
        }

        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 5px 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
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

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            padding-top: 100px; /* Adjusted to ensure the nav bar is accounted for */
        }

        .registration-container {
            background-color: #fff;
            padding: 2em;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        h2 {
            text-align: center;
            color: var(--primary-color);
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 1em;
        }

        label {
            font-weight: 600;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
            width: 100%;
        }

        input[type="submit"] {
            background-color: var(--primary-color);
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
        }

        input[type="submit"]:hover {
            background-color: #ff8c42;
        }

        .back-link {
            text-align: center;
            margin-top: 1em;
        }

        .back-link a {
            color: var(--primary-color);
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }

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
    <nav>
        <img class="nav-logo" src="asset/sedan.png" alt="Logo">
        <ul class="nav-bar">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About Us</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
        <div class="nav-button">
            <a href="login.jsp" class="button1">Login</a>
            <a href="register.jsp" class="button">Register</a>
        </div>        
    </nav>
    
    <div class="registration-container">
        <h2>Customer Registration</h2>
        <form action="RegisterCustomerServlet" method="post">
            <label for="customerID">Customer ID:</label>
            <input type="text" id="customerID" name="customerID" required>

            <label for="customerName">Name:</label>
            <input type="text" id="customerName" name="customerName" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="phoneNum">Phone Number:</label>
            <input type="text" id="phoneNum" name="phoneNum" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <input type="submit" value="Register">
        </form>
        <div class="back-link">
            <a href="index.jsp">Back to Home</a>
        </div>
    </div>
    <!-- Footer -->
    <footer>
        <p>&copy; 2024 RentWise. All rights reserved.</p>
    </footer>
</body>
</html>

