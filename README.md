# RentWise

RentWise is a web-based car rental management system developed for Universiti Malaysia Terengganu (UMT) students. The system is designed to support car browsing, booking, rental tracking, return management, payment processing, and inventory management. :contentReference[oaicite:0]{index=0} :contentReference[oaicite:1]{index=1}

## Important Note

This repository contains the project source code, but the system may not function fully when opened directly from GitHub.

## Why the system cannot fully run on GitHub

This project was developed using:
- HTML, CSS, and JavaScript for the frontend
- JSP and Java for the backend
- MySQL as the database
- Apache Tomcat as the application server :contentReference[oaicite:2]{index=2}

GitHub Pages is a **static site hosting service** and only supports publishing HTML, CSS, and JavaScript files. It does **not support server-side languages**. Because of that, features in this project that depend on JSP, Java servlets, Tomcat, database connectivity, and payment integration cannot run fully on GitHub Pages. :contentReference[oaicite:3]{index=3}

## Features that may not work on GitHub
- User login and registration
- Booking and reservation processing
- Payment processing
- Database storage and retrieval
- Rental and return management
- Admin/staff/owner modules
- Dynamic JSP pages and servlet logic :contentReference[oaicite:4]{index=4} :contentReference[oaicite:5]{index=5}

## Requirements to run the full system
To run this project properly, the following environment is needed:
- Apache Tomcat
- MySQL Server
- Java / JSP support
- Project database import (`carrental.sql`)
- Proper local server configuration :contentReference[oaicite:6]{index=6}

## Recommendation
For full functionality, this project should be run in a local or hosted server environment that supports Java web applications, such as Apache Tomcat with MySQL, instead of GitHub Pages. :contentReference[oaicite:7]{index=7}
