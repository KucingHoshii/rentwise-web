<%-- 
    Document   : orderSummary
    Created on : 24 Jun 2024, 12:37:58 pm
    Author     : afiqa
--%>

<%@page import="model.User"%>
<%@page import="model.Car"%>
<%@page import="model.Rental"%>
<%@page import="model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="asset/RentWiseFavIcon.svg">
    <title>RentWise | Order Summary</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap">
    <link rel="stylesheet" href="css/basicStyle.css">
    <link rel="stylesheet" href="css/orderSummary.css">

</head>
    <body>
        <!-- Nav Bar -->
        <jsp:include page="header.jsp"/>

        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p>Error: <%= error %></p>
        <%
            } else {
                String billTo = (String) request.getAttribute("billTo");
                String billStatus = (String) request.getAttribute("billStatus");
                String billPaymentChannel = (String) request.getAttribute("billpaymentChannel");
                String billPaymentDate = (String) request.getAttribute("billPaymentDate");
                String billPaymentAmount = (String) request.getAttribute("billpaymentAmount");
                String billPaymentInvoiceNo = (String) request.getAttribute("billpaymentInvoiceNo");

                //Also get data from session from previous page
                Rental selectedRental = (Rental) session.getAttribute("rental");
                Car choosenCar = (Car) session.getAttribute("choosenCar");
                User userInfo = (User) session.getAttribute("user");
                String formattedPickupDateTime = (String) session.getAttribute("formattedPickupDateTime");
                String formattedReturnDateTime = (String) session.getAttribute("formattedReturnDateTime");

        %>

        <!-- Thank You Message -->
        <h1 class="main-title">Order Summary</h1>
        <div class="thank-you-container">
            <div class="checkmark">
                <img src="images/check-mark.png" alt="check-mark">
            </div>
            <div class="thank-you-text">
                <p>Order #<%=selectedRental.getRentalId()%></p>
                <h1>Thank you <%=billTo%>!</h1>
            </div>
        </div>

        <div class="thank-you-message">
            <p>Your reservation has been successfully placed. Below are the details of your reservation.</p>
        </div>

        <main class="main-content">
            <div class="reservation-summary">
                <div class="reservation-header">
                    <div class="reservation-dates">
                        <div>
                            <label class="pickup-date" style="color:#333;">Pickup Date</label>
                            <p id="departure-date"><%=formattedPickupDateTime%></p>
                        </div>
                        <div class="vertLine"></div>
                        <div>
                            <label class="return-date" style="color:#333;">Return Date</label>
                            <p id="departure-date"><%=formattedReturnDateTime%></p>
                        </div>
                    </div>
                    <div class="post-order-actions">
                        <button class="action-button" onclick="window.location.href='homepage.html'"><i class="fas fa-home"></i> Home</button>
                        <button id="cancel-booking" class="action-button"><i class="fas fa-times-circle"></i> Cancel Reservation</button>
                    </div>
                </div>
                <div class="reservation-details">
                    <div class="car-info">
                        <h2>Your Car</h2>
                        <img src="data:image/jpeg;base64,<%=choosenCar.getCarPicBase64()%>" alt="Car Image">
                    </div>
                    <div class="pricing-info">
                        <h2>Order Summary</h2>
                        <div class="pricing-item">
                            <span>Order ID</span>
                            <span>#<%=selectedRental.getRentalId()%></span>
                        </div>
                        <div class="pricing-item">
                            <span>Payment Status</span>
                            <span><%=billStatus%></span>
                        </div>
                        <div class="pricing-item">
                            <span>Payment Channel</span>
                            <span><%=billPaymentChannel%></span>
                        </div>
                        <div class="pricing-item">
                            <span>Payment Amount</span>
                            <span>RM <%=billPaymentAmount%></span>
                        </div>
                        <div class="pricing-item">
                            <span>Invoice Number</span>
                            <span><%=billPaymentInvoiceNo%></span>
                        </div>
                        <div class="pricing-item">
                            <span>Payment Date</span>
                            <span><%=billPaymentDate%></span>
                        </div>
                        <div class="pricing-item total">
                            <span>Total</span>
                            <span>RM <%=billPaymentAmount%></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="customer-info">
                <h2>Customer Information</h2>
                <p>Name: <%=userInfo.getStudent_name()%></p>
                <p>Email: <%=userInfo.getStudent_email()%></p>
                <p>Phone No. : <%=userInfo.getStudent_contact()%></p>
            </div>
            <div class="btn-submit">
                <button class="Btn" onclick="window.print()"><i class="fas fa-print"></i> Print Receipt</button>
            </div>

        </main>

        <!-- Footer Section -->
        <jsp:include page="footer.jsp"/>

        <!-- Custom Alert Modal -->
        <div id="custom-alert" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <img class="alert-gif" src="images/x-gify.gif" alt="">
                <p>Are you sure you want to cancel the reservation ?</p>
                <p>This is not <span style="color:red;">refundable!</span> Please read <a href="termsCondition.jsp" target="_blank" style="text-decoration: none">Terms & Conditions</a> clearly before proceeding this !</p>
                <button id="confirm-cancel" class="alert-button">Yes</button>
                <button id="cancel" class="alert-button">No</button>
            </div>
        </div>
        
        <!-- Embed bookid in a hidden element -->
        <input type="hidden" id="rentalId" value="<%= selectedRental != null ? selectedRental.getRentalId() : "" %>">
        <input type="hidden" id="userId" value="<%= userInfo.getStudent_id()%>">
        
        <script src="script.js"></script>
        <% }%>
    </body>
</html>

