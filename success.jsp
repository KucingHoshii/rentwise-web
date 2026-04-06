<%-- 
    Document   : success
    Created on : 30 May 2024, 3:53:43 pm
    Author     : nurs2
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Car Success | RentWise</title>
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

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .success-container {
            background-color: #fff;
            padding: 2em;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        h2 {
            color: var(--primary-color);
        }

        p {
            font-size: 1.2em;
            margin: 1em 0;
        }

        .home-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: var(--primary-color);
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1em;
            transition: background-color 0.3s ease;
        }

        .home-button:hover {
            background-color: #ff8c42;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h2>Add Car Successful!</h2>
        <p>Car details saved  successfully.</p>
        <a href="displaycar.jsp" class="home-button">Back to Car Inventory</a>
    </div>
</body>
</html>



