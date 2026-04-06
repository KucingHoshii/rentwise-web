<%-- 
    Document   : signInUser
    Created on : 3 Jun 2024, 11:55:49 pm
    Author     : afiqa
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" type="image/x-icon" href="images/RentWiseFavIcon.svg">
    <title>RentWise | Sign Up</title>
    <link rel="stylesheet" href="css/signInUser.css"/>
    <script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>
    <script>
      function validateForm(event) {
        var studentName = document.forms["signInForm"]["student_id"].value;
        var studentPassword = document.forms["signInForm"]["student_password"].value;

        if (studentName == "" || studentPassword == "") {
          alert("All fields must be filled out");
          return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup">
          <form name="signInForm" action="LoginServlet" method="post" class="sign-in-form" onsubmit="return validateForm(event)">
            <h2 class="title">Sign In</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" name="student_id" placeholder="Username" />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" name="student_password" placeholder="Password" />
            </div>
            <!-- Placeholder for error message -->
            <p style="color:red;" id="error-message"><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %></p>
            <input type="submit" value="Login" class="btn solid" />
            <p>Or</p>
            <div class="hori-line"></div>
            <p class="admin-link" style="opacity: 80%;">Admin? <a href="">Click Here</a></p> 
          </form>
        </div>
      </div>
      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>New here?</h3>
            <p>Sign Up now to get cheaper prices on renting a car in Universiti Malaysia Terengganu</p>
            <a href="signUpUser.html">
              <button class="btn transparent" id="sign-up-btn">Sign Up</button>
            </a>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>

