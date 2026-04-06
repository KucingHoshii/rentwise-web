<%-- 
    Document   : AddCar
    Created on : 25 May 2024, 6:45:19 am
    Author     : nurs2
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.annotation.MultipartConfig" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Car</title>
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
        <h1>Add Car</h1>
        <form action="AddCarServlet" method="post" enctype="multipart/form-data">
            
             <label for="carId">Car Plate:</label>
            <input type="text" id="carId" name="carId" required>
            
            <label for="carOwnerID">Car Owner ID:</label>
            <input type="text" id="carOwnerID" name="carOwnerID" required>
         
            <label for="carModel">Car Model:</label>
            <input type="text" id="carModel" name="carModel" required>

            <label for="carPrice">Car Price:</label>
            <input type="number" step="0.01" id="carPrice" name="carPrice" required>

            <label for="carType">Car Type:</label>
            <input type="text" id="carType" name="carType" required>

            <label for="carPic">Car Image:</label>
            <input type="file" id="carPic" name="carPic" accept="image/*">

            <input type="submit" value="Submit">
        </form>
    </div>
    <footer>
        <p>Copyright &copy; 2024 RentWise</p>
    </footer>
</body>
</html>
