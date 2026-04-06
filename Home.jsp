<%-- 
    Document   : Home
    Created on : 25 May 2024, 6:28:53 am
    Author     : nurs2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RentWise | Rent Car</title>
    <style>
        :root {
            --primary-color: #ff6a00;
            --background-color: #EEF7FF;
        }

        html {
            background-color: var(--background-color);
            font-family: 'Poppins', sans-serif;
            font-weight: 500;
            scroll-behavior: smooth;
            overflow-x: hidden;
        }

        /*Top Navigation*/
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 5px 20px;
        }

        .nav-logo {
            width: 70px;
            height: 70px;
            cursor: pointer;
        }

        .nav-bar {
            display: flex;
            list-style: none;
            gap: 2.3em;
            margin: 0;
            padding: 0;
            z-index: 10;
        }

        .nav-bar li a {
            text-decoration: none;
            font-size: 19px;
            color: black;
        }

        .nav-bar li a:hover {
            color: var(--primary-color);
            transition: all ease 0.3s;
        }

        .nav-button {
            z-index: 10;
        }

        .nav-button a.button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: grey;
            opacity: 70%;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            font-weight: 500;
        }

        .nav-button a.button1 {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: transparent;
            color: black;
            text-decoration: none;
            text-align: center;
            font-weight: 500;
        }

        .nav-button a.button:hover {
            background-color: var(--primary-color);
            color: white;
            opacity: 100%;
            transition: all ease 0.3s;
        }

        .nav-button a.button1:hover {
            color: white;
            background-color: var(--primary-color);
            border-radius: 5px;
            transition: all ease 0.3s;
        }

        /* Content */
        .container {
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            margin-top: -100px;
            padding-left: 5em;
            gap: 7em;
        }

        span {
            color: var(--primary-color);
        }

        .content {
            margin-right: 7em;
            width: 40%;
        }

        .heading {
            font-size: 3em;
        }

        .sub-heading {
            margin-top: -40px;
        }

        .content-button a.button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: black;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            font-weight: 500;
        }

        .content-button a.button:hover {
            background-color: var(--primary-color);
            color: black;
            transition: all ease-in-out 0.1s;
        }

        .car-image img {
            margin-top: 55px;
            width: 600px;
            height: 600px;
            z-index: 0;
        }

        /*How it Works Section */
        .how-it-works {
            text-align: center;
            padding: 50px 25px;
            background-color: var(--background-color);
        }

        .how-it-works h2 {
            font-size: 36px;
            margin-bottom: 40px;
            color: #2c3e50;
        }

        .steps {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 30px;
        }

        .step {
            background-color: #ecf0f1;
            padding: 20px;
            border-radius: 8px;
            width: 250px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: all ease-in-out 0.3s;
        }

        .step:hover {
            transform: scale(1.025);
        }

        .step img {
            width: 75px;
            height: 75px;
            display: block;
            margin: 0 auto 20px;
        }

        .step h3 {
            font-size: 24px;
            margin-bottom: 10px;
            color: #2c3e50;
            text-align: center;
        }

        .step p {
            font-size: 16px;
            color: #7f8c8d;
            line-height: 1.6;
        }

        /* Why Us Section */
        .whyUs {
            padding: 50px 25px;
            background-color: var(--background-color);
        }

        .whyUs h2 {
            display: flex;
            justify-content: center;
            font-size: 36px;
            margin-bottom: 40px;
        }

        .content-wrapper {
            display: flex;
            justify-content: space-between;
        }

        .accordion-container {
            flex: 1;
            margin-right: 20px;
        }

        .accordion {
            background-color: var(--background-color);
            color: black;
            cursor: pointer;
            padding: 18px;
            width: 100%;
            border: none;
            text-align: left;
            outline: none;
            font-size: 15px;
            transition: background-color 0.4s, color 0.4s;
            position: relative;
            border-bottom: 1px solid black;
        }

        .accordion .downArrow {
            position: absolute;
            right: 18px;
            top: 50%;
            transform: translateY(-50%);
            transition: transform 0.4s ease;
        }

        .accordion.active .downArrow {
            transform: translateY(-50%) rotate(180deg);
        }

        .panel {
            padding: 0 18px;
            max-height: 0;
            overflow: hidden;
            transition: max-height 0.6s ease;
        }

        .rent-img {
            flex: 1;
            display: flex;
            justify-content: flex-end;
            align-items: flex-start;
            box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
        }

        .rent-img img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
            object-fit: contain;
        }

        @media (min-width: 1024px) {
            .rent-img img {
                height: 100%;
            }
        }

        /*Footer*/
        footer {
            position: absolute;
            width: 100%;
            background-color: #FF5F00;
            text-align: center;
            left: 0;
        }
    </style>
</head>
<body>
    <!-- Nav Bar -->
    <nav>
        <img class="nav-logo" src="asset\sedan.png" alt="">
        <ul class="nav-bar">
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="displaycar.jsp">Car</a></li>
            <li><a href="">Staff</a></li>
            <li><a href="">About</a></li>
        </ul>
        <div class="nav-button">
            <a href="signup.html" class="button1">Sign Up</a>
            <a href="signin.html" class="button">Sign In</a>
        </div>        
    </nav>

    <!-- Content -->
    <div class="container">
        <div class="content">
            <p class="heading"><b><span>Looking</span> for Cheaper <span>Price</span> to Rent a Car</b></p>
            <p class="sub-heading">RentWise is your solution!</p>
            <div class="content-button">
                <a href="" class="button">Find Car Now</a>
            </div>        
        </div>
        <div class="car-image">
            <img src="asset/homepageCar.webp" alt="">
        </div>
    </div>
    <!-- How it Works Section -->
    <div class="how-it-works">
        <h2>How It Works</h2>
        <div class="steps">
            <div class="step">
                <img src="asset/search.png" alt="Search">
                <h3>Search Cars</h3>
                <p>Enter your locations and dates to see available cars.</p>
            </div>
            <div class="step">
                <img src="asset/select.png" alt="Select">
                <h3>Select Car</h3>
                <p>Choose the car that suits your needs.</p>
            </div>
            <div class="step">
                <img src="asset/booking.png" alt="Book">
                <h3>Book Your Car</h3>
                <p>Provide your details and confirm the booking.</p>
            </div>
            <div class="step">
                <img src="asset/drive.png" alt="Drive">
                <h3>Pick Up and Drive</h3>
                <p>Pick up the car and enjoy your ride.</p>
            </div>
        </div>
    </div>
    <!-- Why Us Section -->
    <div class="whyUs">
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
                <img src="asset/rentCarPic.jpg" alt="Rent Car Picture">
            </div>
        </div>
    </div>

    <footer>
        <p>Copyright &copy; 2024 RentWise</p>
    </footer>
    <script>
        var acc = document.getElementsByClassName("accordion");
        var i;
        
        for (i = 0; i < acc.length; i++) {
          acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
              panel.style.maxHeight = null;
            } else {
              panel.style.maxHeight = panel.scrollHeight + "px";
            } 
          });
        }
    </script>
</body>
</html>

