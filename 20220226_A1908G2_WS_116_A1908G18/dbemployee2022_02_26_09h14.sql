-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2022 at 03:14 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbemployee`
--
CREATE DATABASE IF NOT EXISTS `dbemployee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbemployee`;

-- --------------------------------------------------------

--
-- Table structure for table `tblemployee`
--

DROP TABLE IF EXISTS `tblemployee`;
CREATE TABLE IF NOT EXISTS `tblemployee` (
  `EmployeeNo` varchar(20) NOT NULL,
  `EmployeeName` varchar(30) NOT NULL,
  `PlaceOfWork` varchar(30) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  PRIMARY KEY (`EmployeeNo`),
  UNIQUE KEY `EmployeeNo` (`EmployeeNo`,`EmployeeName`,`PlaceOfWork`,`PhoneNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblemployee`
--

INSERT INTO `tblemployee` (`EmployeeNo`, `EmployeeName`, `PlaceOfWork`, `PhoneNo`) VALUES
('E0101', 'Nguyen Van Hai', 'Hai Duong', '098745321'),
('E0102', 'Nguyen Van Ha', 'Ha Nam', '09874532'),
('E0103', 'Tráº§n Háº£i Phong', 'Ha Noi', '012286263');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
