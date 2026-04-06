<%-- 
    Document   : returnCar
    Created on : 30 Jun 2024, 2:03:18 AM
    Author     : user
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/x-icon" href="images/RentWiseFavIcon.svg">
        <title>RentWise | Rent Car</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
        <link rel="stylesheet" href="css/basicStyle.css">
        <link rel="stylesheet" href="css/returnCar.css">
    </head>

    <body>
        <jsp:include page="headerStaff.jsp" />
        <!-- Content Section -->
        <h1>Return Car Form</h1>
        <div class="container">
            <form class="form-container" action="ReturnCarServlet?action=save" method="POST">
<!--                <form class="form-container" action="ReturnCarsServlet" method="POST">-->
                <!-- Left Column -->
                <div class="form-group">
                    <label for="staffID">Staff ID :</label>
                    <input type="text" id="staffID" name="staffID" placeholder="Enter staff ID" required>
                </div>
                <div class="form-group">
                    <label for="car_id">Car ID :</label>
                    <input type="text" id="car_id" name="car_id" placeholder="Enter car ID" required>
                </div>
                <div class="form-group">
                    <label for="student_id">Student ID :</label>
                    <input type="text" id="student_id" name="student_id" placeholder="Enter student ID" required>
                </div>
                <div class="form-group">
                    <label for="returnDate">Return Date :</label>
                    <input type="date" id="returnDate" name="returnDate" required>
                </div>
                <div class="form-group">
                    <label for="returnTime">Return Time :</label>
                    <input type="time" id="returnTime" name="returnTime" required>
                </div>
                <!-- Right Column -->
                <div class="form-group inline-group">
                    <label>Damage :</label>
                    <div class="radio-group">
                        <label><input type="radio" name="damage" value="1" required> Yes</label>
                        <label><input type="radio" name="damage" value="0" checked> No</label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="carcondition">Condition :</label>
                    <textarea id="carcondition" name="carcondition" rows="4" placeholder="Enter condition if needed"></textarea>
                </div>
                <div class="form-group">
                    <label for="addcharge">Additional Charge :</label>
                    <input type="number" id="addcharge" name="addcharge" inputmode="decimal" min="0" step="0.01" placeholder="Enter amount if needed">
                </div>
                <div class="form-buttons">
                    <input type="submit" value="Save">
                    <input type="reset" value="Reset">
                </div>
            </form>
        </div>
        <jsp:include page="footerStaff.jsp" />
    </body>
</html>