<%-- 
    Document   : booking
    Created on : 31 May 2024, 9:01:09 am
    Author     : afiqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="images/RentWiseFavIcon.svg">
        <title>RentWise | Booking</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="css/basicStyle.css">
        <link rel="stylesheet" href="css/booking.css">

    </head>
    <body>
        <!-- Nav Bar -->
        <jsp:include page="header.jsp"/>     
        
        <%
            // Retrieve userId from URL parameter
            String userId = request.getParameter("userId");

            // Validate userId if necessary
            if (userId != null && !userId.isEmpty()) {
                // Store userId in session
                session.setAttribute("userId", userId);
            }
        %>
        
        <!-- Top Section -->
        <h1 class="topHeader">Find Your Car Here</h1>
        <section>
            <div class="form-container">
                <form action="viewAvailableCars" method="post">
                    <div class="input-box">
                        <span class="form">Pick-Up Date</span>
                        <input type="date" name="pickup_date" required>
                    </div>
                    <div class="input-box">
                        <span class="form">Time</span>
                        <input type="time" name="pickup_time" required>
                    </div>
                    <div class="input-box">
                        <span class="form">Return Date</span>
                        <input type="date" name="return_date" required>
                    </div>
                    <div class="input-box">
                        <span class="form">Time</span>
                        <input type="time" name="return_time" required>
                    </div>
                    <input type="submit" class="btn" value="Find Car">
                </form>
            </div>
        </section>
        
        <!-- How it Works Section -->
        <div class="how-it-works">
            <h2 id="How">How It Works</h2>
            <div class="steps">
                <div class="step">
                    <img src="images/search.png" alt="Search">
                    <h3>Search Cars</h3>
                    <p>Enter your locations and dates to see available cars.</p>
                </div>
                <div class="step">
                    <img src="images/select.png" alt="Select">
                    <h3>Select Car</h3>
                    <p>Choose the car that suits your needs.</p>
                </div>
                <div class="step">
                    <img src="images/booking.png" alt="Book">
                    <h3>Book Your Car</h3>
                    <p>Provide your details and confirm the booking.</p>
                </div>
                <div class="step">
                    <img src="images/drive.png" alt="Drive">
                    <h3>Pick Up and Drive</h3>
                    <p>Pick up the car and enjoy your ride.</p>
                </div>
            </div>
        </div>
        <!-- Why Us Section -->
        <div class="whyUs" id="whyUs">
            <h2>Why Choose &nbsp;<span>RentWise</span></h2>
            <div class="content-wrapper">
                <div class="accordion-container">
                    <button class="accordion">
                        Section 1
                        <div class="downArrow">
                            <i class="fa fa-angle-up" aria-hidden="true"></i>
                        </div>
                    </button>
                    <div class="panel" style="max-height: none;">
                        <p>Some text for section 1..</p>
                    </div>
                    <button class="accordion">
                        Section 2
                        <div class="downArrow">
                            <i class="fa fa-angle-up" aria-hidden="true"></i>
                        </div>
                    </button>
                    <div class="panel" style="max-height: none;">
                        <p>Some text for section 2..</p>
                    </div>
                </div>
                <div class="rent-img">
                    <img src="images/rentCarPic.jpg" alt="Rent Car Picture">
                </div>
            </div>
        </div>

        <!-- Content Section -->
        <jsp:include page="footer.jsp"/>   
    </body>
</html>

