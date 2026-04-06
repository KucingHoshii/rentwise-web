<%-- 
    Document   : modifyDate
    Created on : 26 Jun 2024, 2:35:28 pm
    Author     : afiqa
--%>

<%@page import="model.Rental"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="images/epicationLogo.svg">
    <title>RentWise | Change Date</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/basicStyle.css">
    <link rel="stylesheet" href="css/trip.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap');

        .topHeader{
            font-size: 15px;
            text-align: center;
        }
        .form-container {
            display: flex;
            margin-top: 30px;
            justify-content: center;
        }

        .form-container form {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            width: 50%;
            gap: 1.5rem;
            background: #c3c4cc;
            padding: 28px;
            box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 2px 6px 2px;
            border-radius: 0.5rem;
        }

        .input-box {
            flex: 1 1 7rem;
            display: flex;
            flex-direction: column;
        }

        .input-box span {
            font-weight: 500;
        }

        .input-box input {
            padding: 7px;
            outline: none;
            border: none;
            background: #eeeff1;
            border-radius: 0.5rem;
            font-size: 1rem;
        }

        .form-container form .btn {
            flex: 1 2 5rem;
            padding: 10px 35px;
            margin-top: 21px;
            border: none;
            border-radius: 0.5rem;
            background: #474fa0;
            color: #fff;
            font-size: 1rem;
            font-weight: 500;
            cursor: pointer;
        }

        .form-container form .btn:hover {
            background: purple;
        }
    </style>
</head>
<body>

    <!-- Include Header -->
    <jsp:include page="header.jsp"/>

    <%
        // Get data from session from previous page
        Rental selectedRental = (Rental) session.getAttribute("rental");
    %>

    <!-- Top Header -->
    <h1 class="topHeader">Update Date</h1>
    <div class="form-container">
        <form action="ModifyDateServlet" method="post">
            <input type="hidden" name="bookingId" value="<%= selectedRental.getRentalId() %>">
            <input type="hidden" name="car_Id" value="<%= selectedRental.getCarId() %>">

            <div class="input-box">
                <span>New Pickup Date</span>
                <input type="date" name="newPickupDate" required>
            </div>
            <div class="input-box">
                <span>Time</span>
                <input type="time" name="newPickupTime" required>
            </div>
            <div class="input-box">
                <span>New Return Date</span>
                <input type="date" name="newReturnDate" required>
            </div>
            <div class="input-box">
                <span>Time</span>
                <input type="time" name="newReturnTime" required>
            </div>
            <input type="submit" class="btn" value="Submit">
        </form>
    </div>

    <!-- Include Footer -->
    <jsp:include page="footer.jsp"/>

</body>
</html>
