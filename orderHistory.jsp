<%-- 
    Document   : orderHistory
    Created on : 25 Jun 2024, 10:32:18 pm
    Author     : afiqa
--%>

<%@page import="java.util.List"%>
<%@page import="model.Car"%>
<%@page import="model.Rental"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="images/RentWiseFavIcon.svg">
        <title>RentWise | Order History</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="css/orderHistory.css"/>
    </head>
    <body>
        <!-- Nav Bar -->
        <jsp:include page="header.jsp"/>

        <!-- Content Section -->
        <main>
            <div class="container">
                <div class="header">
                    <h1 class="topHeader">Your Rental History</h1>
                </div>
                <div class="car-list">
                    <c:if test="${not empty errorMessage}">
                        <p class="error">${errorMessage}</p>
                    </c:if>
                    <c:forEach var="rental" items="${userRentalHistory}">
                        <c:set var="car" value="${rental.car}" />
                        <div class="car-item">
                            <img src="data:image/jpeg;base64,${car.carPicBase64}" alt="Car Image" class="car-image">
                            <div class="car-details">
                                <h2 class="car-title">${car.carModel}</h2>
                            </div>
                            <div class="car-info-right">
                                <p class="car-price">RM ${rental.rentalFees}</p>
                                <p class="payment-status">Payment Status: ${rental.rentalStatus}</p>
                                <p class="payment-date">Start Date: ${rental.startDate}</p>
                                <p class="payment-date">Return Date: ${rental.returnDate}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>
        
        <!-- Footer Section -->
        <jsp:include page="footer.jsp"/>
    </body>
</html>
