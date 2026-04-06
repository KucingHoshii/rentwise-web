-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 29, 2024 at 05:50 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrental`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `carID` varchar(15) NOT NULL,
  `carType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`carID`, `carType`) VALUES
('JAG7762', 'Perodua Axia'),
('KEH3035', 'Honda CR-V'),
('NDS2425', 'Proton Bezza');

-- --------------------------------------------------------

--
-- Table structure for table `returncar`
--

CREATE TABLE `returncar` (
  `staffID` varchar(15) NOT NULL,
  `carID` varchar(15) NOT NULL,
  `bookingDate` date NOT NULL,
  `bookingTime` time NOT NULL,
  `returnDate` date NOT NULL,
  `returnTime` time NOT NULL,
  `damage` tinyint(1) NOT NULL,
  `carcondition` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returncar`
--

INSERT INTO `returncar` (`staffID`, `carID`, `bookingDate`, `bookingTime`, `returnDate`, `returnTime`, `damage`, `carcondition`) VALUES
('S011', 'KEH3035', '2024-05-20', '11:10:00', '2024-05-21', '11:15:00', 1, 'dented boot'),
('S012', 'NDS2425', '2024-05-16', '10:36:00', '2024-05-16', '22:40:00', 1, 'scratch on the back of the car'),
('S012', 'JAG7762', '2024-05-18', '15:41:00', '2024-05-20', '15:45:00', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` varchar(15) NOT NULL,
  `staffName` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phoneNum` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `staffName`, `password`, `phoneNum`, `email`) VALUES
('S011', 'Fahmi Mubarak', 'fahmi23', '0126039245', 'fahmimubarak@gmail.com'),
('S012', 'Aira Ali', 'airaaa123', '01123735525', 'airali902@gmail.com'),
('S013', 'Gambit Muhammad', 'gambz', '0192679467', 'gambitmuhd@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`carID`);

--
-- Indexes for table `returncar`
--
ALTER TABLE `returncar`
  ADD KEY `carID` (`carID`),
  ADD KEY `staffID` (`staffID`) USING BTREE;

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `returncar`
--
ALTER TABLE `returncar`
  ADD CONSTRAINT `returncar_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `returncar_ibfk_2` FOREIGN KEY (`carID`) REFERENCES `car` (`carID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
