<%-- 
    Document   : editCarDetails
    Created on : 1 Jul 2024, 5:13:12 PM
    Author     : user
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentWise | Edit Car Details</title>
    <link rel="stylesheet" href="css/editCarDetails.css">
</head>
<body>
    <jsp:include page="headerStaff.jsp" />
    
    <h1>Edit Car Details</h1>
    <div class="container">
        <form class="form-container" action="ReturnCarServlet?action=edit" method="POST">
            <input type="hidden" name="id" value="${car.id}">
            <!-- Left Column -->
            <div class="form-group">
                <label for="staffID">Staff ID :</label>
                <input type="text" id="staffID" name="staffID" value="${car.staffID}">
            </div>
            <div class="form-group">
                <label for="car_id">Car ID :</label>
                <input type="text" id="car_id" name="car_id" value="${car.car_id}">
            </div>
            <div class="form-group">
                <label for="student_id">Student ID :</label>
                <input type="text" id="student_id" name="student_id" value="${car.student_id}" required>
            </div>
            <div class="form-group">
                <label for="returnDate">Return Date :</label>
                <input type="date" id="returnDate" name="returnDate" value="${car.returnDate}" required>
            </div>
            <div class="form-group">
                <label for="returnTime">Return Time :</label>
                <input type="time" id="returnTime" name="returnTime" value="${car.returnTime}" required>
            </div>
            <!-- Right Column -->
            <div class="form-group inline-group">
                <label>Damage :</label>
                <div class="radio-group">
                    <label><input type="radio" name="damage" value="1" ${car.damage == '1' ? 'checked' : ''}> Yes</label>
                    <label><input type="radio" name="damage" value="0" ${car.damage == '0' ? 'checked' : ''}> No</label>
                </div>
            </div>
            <div class="form-group">
                <label for="carCondition">Condition :</label>
                <textarea id="carCondition" name="carCondition" rows="4">${car.carCondition}</textarea>
            </div>
            <div class="form-group">
                <label for="addCharge">Additional Charge :</label>
                <input type="number" id="addCharge" name="addCharge" inputmode="decimal" min="0" step="0.01" value="${car.addCharge}">
            </div>
            <div class="form-buttons">
                <input type="submit" value="Update" class="button">
                <a href="ReturnCarServlet?action=list" class="button">Cancel</a>
            </div>
        </form>

    <jsp:include page="footerStaff.jsp" />
</body>
</html>
