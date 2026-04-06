<%-- 
    Document   : listReturnedCars
    Created on : 1 Jul 2024, 1:35:04 PM
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>RentWise | Returned Cars</title>
        <link rel="stylesheet" href="css/listReturnedCar.css">
    </head>
    <body>
        <jsp:include page="headerStaff.jsp" />
        <h1>Returned Cars List</h1>
        <button onclick="location.href='ReturnCarServlet?action=addNew'" class="button add">Add New Return Car</button>
        <table>
            <tr>
                <th>ID</th>
                <th>Staff ID</th>
                <th>Car ID</th>
                <th>Student ID</th>
                <th>Return Date</th>
                <th>Return Time</th>
                <th>Damage</th>
                <th>Car Condition</th>
                <th>Add Charge</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${returnedCars}" var="car">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.staffID}</td>
                    <td>${car.car_id}</td>
                    <td>${car.student_id}</td>
                    <td>${car.returnDate}</td>
                    <td>${car.returnTime}</td>
                    <td>${car.damage}</td>
                    <td>${car.carCondition}</td>
                    <td>${car.addCharge}</td>
                    <td>
                        <a href="ReturnCarServlet?action=edit&id=${car.id}" class="button edit">Edit</a>
                        <a href="ReturnCarServlet?action=delete&id=${car.id}" class="button delete" onclick="return confirm('Are you sure you want to delete this car?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <jsp:include page="footerStaff.jsp" />
    </body>
</html>