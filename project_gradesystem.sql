-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2020 at 09:09 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_gradesystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Ad_Code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `Ad_NameTitle` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Ad_Name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Ad_Surname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Ad_ID` char(13) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Ad_Code`, `Ad_NameTitle`, `Ad_Name`, `Ad_Surname`, `Ad_ID`) VALUES
('goif1234', 'นาย', 'ปรมินทร์', 'รินทร', '1339900572691'),
('Joyjee5758', 'นางสาว', 'รัตติยากร', 'หล้ารุ่งเรืองกิจ', '1409901758798'),
('khunpop', 'นางสาว', 'นิศารัตน์', 'รำเพยพล', '1409901701966'),
('pukim007', 'นาย', 'อาชาญนนท์', 'แซ่ชื้อ', '1100702785714');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Dep_ID` char(5) COLLATE utf8_unicode_ci NOT NULL,
  `Dep_Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Dep_Bachelor` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Fac_ID` char(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Dep_ID`, `Dep_Name`, `Dep_Bachelor`, `Fac_ID`) VALUES
('D01', 'วิทยาการคอมพิวเตอร์', 'ปริญญาตรี', 'F01'),
('D02', 'เทคโนโลยีสารสนเทศ', 'ปริญญาตรี', 'F01'),
('D03', 'ภูมิสารสนเทศและเทคโนโลยี', 'ปริญญาตรี', 'F01'),
('D04', 'สารสนเทศสถิติ', 'ปริญญาตรี', 'F01'),
('D05', 'เทคโนโลยีด้านอาหาร', 'ปริญญาตรี', 'F02'),
('D06', 'เทคโนโลยีด้านคอมพิวเตอร์ทั่วไป', 'ปริญญาตรี', 'F02');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Fac_ID` char(5) COLLATE utf8_unicode_ci NOT NULL,
  `Fac_Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`Fac_ID`, `Fac_Name`) VALUES
('F01', 'คณะวิทยาศาสตร์'),
('F02', 'คณะเทคโนโลยี'),
('F03', 'คณะบริหารธุรกิจและการบัญชี'),
('F04', 'คณะเศรษศาสตร์'),
('F05', 'คณะเกษตรศาสตร์'),
('F06', 'คณะมนุษย์ศาสตร์'),
('F07', 'คณะวิศวะกรรมศาสตร์');

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `Std_Code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `Sub_ID` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `Semester_ID` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `Year_ID` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `Gd_Grade` double(3,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`Std_Code`, `Sub_ID`, `Semester_ID`, `Year_ID`, `Gd_Grade`) VALUES
('6030207608', '000101', '1', '2560', 3.00),
('6030207608', '000174', '1', '2560', 3.00),
('6030207608', '000175', '1', '2560', 3.50),
('6030207608', 'SC0001002', '1', '2560', 3.50),
('6030207608', 'SC311001', '1', '2560', 3.00),
('6030207608', 'SC311002', '1', '2560', 2.00),
('6030207608', 'SC401201', '1', '2560', 1.00),
('6030203036', '000101', '1', '2560', 1.50),
('6030203036', '000174', '1', '2560', 3.00),
('6030203036', '000175', '1', '2560', 3.00),
('6030203036', 'SC0001002', '1', '2560', 3.50),
('6030203036', 'SC311001', '1', '2560', 2.00),
('6030203036', 'SC311002', '1', '2560', 1.50),
('6030203036', 'SC401201', '1', '2560', 0.00),
('6030210148', '000101', '1', '2560', 2.50),
('6030210148', '000174', '1', '2560', 3.50),
('6030210148', '000175', '1', '2560', 3.50),
('6030210148', 'SC0001002', '1', '2560', 2.50),
('6030210148', 'SC311001', '1', '2560', 2.00),
('6030210148', 'SC311002', '1', '2560', 1.50),
('6030210148', 'SC401201', '1', '2560', 1.00),
('6030210334', '000101', '1', '2560', 1.50),
('6030210334', '000174', '1', '2560', 3.00),
('6030210334', '000175', '1', '2560', 3.00),
('6030210334', 'SC0001002', '1', '2560', 3.00),
('6030210334', 'SC311001', '1', '2560', 1.50),
('6030210334', 'SC311002', '1', '2560', 1.00),
('6030210334', 'SC401201', '1', '2560', 0.00),
('6030207608', '000102', '2', '2560', 2.00),
('6030207608', '000145', '2', '2560', 3.00),
('6030207608', 'SC002104', '2', '2560', 1.50),
('6030207608', 'SC311003', '2', '2560', 2.50),
('6030207608', 'SC311004', '2', '2560', 3.00),
('6030207608', 'SC311501', '2', '2560', 1.50),
('6030207608', 'SC401202', '2', '2560', 1.50),
('6030203036', '000102', '2', '2560', 1.00),
('6030203036', '000145', '2', '2560', 3.00),
('6030203036', 'SC002104', '2', '2560', 1.00),
('6030203036', 'SC311003', '2', '2560', 1.50),
('6030203036', 'SC311004', '2', '2560', 2.50),
('6030203036', 'SC401202', '2', '2560', 1.00),
('6030203036', 'SC311301', '2', '2560', 2.50),
('6030210148', '000102', '2', '2560', 1.00),
('6030210148', '000145', '2', '2560', 3.50),
('6030210148', 'SC002104', '2', '2560', 1.00),
('6030210148', 'SC311003', '2', '2560', 2.50),
('6030210148', 'SC311004', '2', '2560', 3.00),
('6030210148', 'SC311501', '2', '2560', 2.00),
('6030210148', 'SC401202', '2', '2560', 1.00),
('6030210334', '000102', '2', '2560', 2.50),
('6030210334', '000145', '2', '2560', 3.00),
('6030210334', 'SC002104', '2', '2560', 1.00),
('6030210334', 'SC311003', '2', '2560', 0.00),
('6030210334', 'SC311004', '2', '2560', 2.50),
('6030210334', 'SC401201', '2', '2560', 1.50),
('6030210334', 'SC311301', '2', '2560', 2.50),
('6030207608', '861102', '3', '2560', 4.00),
('6030207608', '870154', '3', '2560', 4.00),
('6030207608', 'ED060021', '3', '2560', 4.00),
('6030203036', 'SC401201', '3', '2560', 2.50),
('6030203036', 'FA301201', '3', '2560', 4.00),
('6030203036', 'FA461301', '3', '2560', 4.00),
('6030210148', '861102', '3', '2560', 4.00),
('6030210148', '870154', '3', '2560', 4.00),
('6030210148', 'ED060021', '3', '2560', 4.00),
('6030210334', 'SC401202', '3', '2560', 1.00),
('6030210334', 'FA461301', '3', '2560', 4.00),
('6030210334', '300305', '3', '2560', 4.00),
('6030207608', '000103', '1', '2561', 2.00),
('6030207608', '000159', '1', '2561', 3.50),
('6030207608', 'SC312001', '1', '2561', 3.00),
('6030207608', 'SC312002', '1', '2561', 3.00),
('6030207608', 'SC312201', '1', '2561', 3.00),
('6030207608', 'SC402101', '1', '2561', 1.00),
('6030207608', 'SC602005', '1', '2561', 2.00),
('6030203036', '000103', '1', '2561', 1.00),
('6030203036', '000159', '1', '2561', 3.00),
('6030203036', 'SC312001', '1', '2561', 2.00),
('6030203036', 'SC312002', '1', '2561', 3.50),
('6030203036', 'SC312201', '1', '2561', 2.00),
('6030203036', 'SC402101', '1', '2561', 0.00),
('6030203036', 'SC602005', '1', '2561', 2.00),
('6030210148', '000103', '1', '2561', 2.00),
('6030210148', '000159', '1', '2561', 3.00),
('6030210148', 'SC312001', '1', '2561', 3.00),
('6030210148', 'SC312002', '1', '2561', 3.00),
('6030210148', 'SC312201', '1', '2561', 2.50),
('6030210148', 'SC402101', '1', '2561', 1.50),
('6030210148', 'SC602005', '1', '2561', 2.00),
('6030210334', '000103', '1', '2561', 3.00),
('6030210334', '000159', '1', '2561', 3.00),
('6030210334', 'SC312001', '1', '2561', 3.50),
('6030210334', 'SC312002', '1', '2561', 3.50),
('6030210334', 'SC312201', '1', '2561', 2.00),
('6030210334', 'SC402101', '1', '2561', 1.00),
('6030210334', 'SC602005', '1', '2561', 2.00),
('6030207608', '000104', '2', '2561', 1.50),
('6030207608', 'SC312003', '2', '2561', 2.50),
('6030207608', 'SC312004', '2', '2561', 3.50),
('6030207608', 'SC312005', '2', '2561', 3.50),
('6030207608', 'SC312006', '2', '2561', 2.50),
('6030207608', 'SC312104', '2', '2561', 3.50),
('6030207608', 'SC402401', '2', '2561', 2.00),
('6030203036', '000104', '2', '2561', 1.50),
('6030203036', 'SC312003', '2', '2561', 2.00),
('6030203036', 'SC312004', '2', '2561', 2.00),
('6030203036', 'SC312005', '2', '2561', 3.50),
('6030203036', 'SC312006', '2', '2561', 2.00),
('6030203036', 'SC312104', '2', '2561', 1.50),
('6030203036', 'SC402401', '2', '2561', 1.50),
('6030210148', '000104', '2', '2561', 1.50),
('6030210148', 'SC312003', '2', '2561', 2.50),
('6030210148', 'SC312004', '2', '2561', 3.50),
('6030210148', 'SC312005', '2', '2561', 3.50),
('6030210148', 'SC312006', '2', '2561', 2.00),
('6030210148', 'SC312104', '2', '2561', 3.00),
('6030210148', 'SC402401', '2', '2561', 1.50),
('6030210334', '000104', '2', '2561', 2.50),
('6030210334', 'SC312003', '2', '2561', 2.00),
('6030210334', 'SC312004', '2', '2561', 4.00),
('6030210334', 'SC312005', '2', '2561', 2.50),
('6030210334', 'SC312006', '2', '2561', 2.00),
('6030210334', 'SC312104', '2', '2561', 2.00),
('6030210334', 'SC402401', '2', '2561', 2.50),
('6030210334', 'SC311003', '2', '2561', 2.50),
('6030203036', '861102', '3', '2561', 4.00),
('6030203036', 'SC402101', '3', '2561', 3.00),
('6030210334', '300304', '3', '2561', 3.00),
('6030210334', '853161', '3', '2561', 4.00),
('6030210334', '870151', '3', '2561', 4.00),
('6030207608', 'LI203010', '1', '2562', 2.50),
('6030207608', 'SC313001', '1', '2562', 1.50),
('6030207608', 'SC313002', '1', '2562', 3.00),
('6030207608', 'SC313003', '1', '2562', 3.50),
('6030207608', 'SC313102', '1', '2562', 3.00),
('6030207608', 'SC313504', '1', '2562', 2.50),
('6030207608', 'SC313761', '1', '2562', 4.00),
('6030207608', 'SC403602', '1', '2562', 1.00),
('6030203036', 'LI203010', '1', '2562', 1.00),
('6030203036', 'SC313001', '1', '2562', 1.00),
('6030203036', 'SC313002', '1', '2562', 2.00),
('6030203036', 'SC313003', '1', '2562', 3.00),
('6030203036', 'SC313504', '1', '2562', 2.50),
('6030203036', 'SC313761', '1', '2562', 2.50),
('6030203036', 'SC403602', '1', '2562', 1.00),
('6030203036', '777100', '1', '2562', 1.00),
('6030210148', 'LI203010', '1', '2562', 1.50),
('6030210148', 'SC313001', '1', '2562', 2.00),
('6030210148', 'SC313002', '1', '2562', 3.00),
('6030210148', 'SC313003', '1', '2562', 3.00),
('6030210148', 'SC313102', '1', '2562', 3.50),
('6030210148', 'SC313504', '1', '2562', 2.50),
('6030210148', 'SC313761', '1', '2562', 3.50),
('6030210148', 'SC403602', '1', '2562', 1.00),
('6030210334', 'LI203010', '1', '2562', 3.00),
('6030210334', 'SC313001', '1', '2562', 1.50),
('6030210334', 'SC313002', '1', '2562', 2.00),
('6030210334', 'SC313003', '1', '2562', 3.00),
('6030210334', 'SC313504', '1', '2562', 2.50),
('6030210334', 'SC313761', '1', '2562', 3.50),
('6030210334', 'SC403602', '1', '2562', 1.00),
('6030210334', 'SC313403', '1', '2562', 2.00),
('6030207608', '1234', '1', '2562', 3.00),
('6030207608', '000101', '2', '2560', 3.00);

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `Pr_ID` char(13) COLLATE utf8_unicode_ci NOT NULL,
  `Pr_Pass` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `Pr_NameTitle` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Pr_Name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Pr_Surname` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`Pr_ID`, `Pr_Pass`, `Pr_NameTitle`, `Pr_Name`, `Pr_Surname`) VALUES
('3100702785714', '123456789', 'นาย', 'เกียเซี้ย', 'แซ่ชื้อ'),
('3110032785714', '123456', 'นาย', 'สมชาย', 'พ่อใครสักคน'),
('3400101457082', 'Miffy5758', 'นาง', 'รัตนา', 'หล้ารุ่งเรืองกิจ'),
('5440100002771', '90698', 'นาง', 'รมณี', 'รำเพยพล'),
('580010084501', '23092541', 'นางสาว', 'ปฏิมา', 'ศรีรมย์');

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `Semester_ID` char(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`Semester_ID`) VALUES
('1'),
('2'),
('3');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Std_Code` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `Std_TNameTitle` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_TName` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_TSurname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_ENameTitle` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_EName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_ESurname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_BDate` date DEFAULT NULL,
  `Std_DateOfAttended` date DEFAULT NULL,
  `Std_DateOfRetire` date DEFAULT NULL,
  `Std_ID` char(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_Status` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Std_Degrees` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pr_ID` char(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fac_ID` char(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Dep_ID` char(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Type_Program` char(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Std_Code`, `Std_TNameTitle`, `Std_TName`, `Std_TSurname`, `Std_ENameTitle`, `Std_EName`, `Std_ESurname`, `Std_BDate`, `Std_DateOfAttended`, `Std_DateOfRetire`, `Std_ID`, `Std_Status`, `Std_Degrees`, `Pr_ID`, `Fac_ID`, `Dep_ID`, `Type_Program`) VALUES
('6030203036', 'นาย', 'ปรมินทร์', 'รินทร', 'MR', 'Poramin', 'Rinthorn', '1998-09-23', '2017-08-05', '0000-00-00', '1339900572691', 'นักศึกษาปกติ', 'ปริญญาตรี', '580010084501', 'F01', 'D01', 'ภาคปกติ'),
('6030207608', 'นางสาว', 'รัตติยากร', 'หล้ารุ่งเรืองกิจ', 'Ms', 'Rattiyakorn', 'Larungruangkit', '1998-10-30', '2017-08-05', '0000-00-00', '1409901758798', 'นักศึกษาปกติ', 'ปริญญาตรี', '3400101457082', 'F01', 'D01', 'ภาคปกติ'),
('6030210148', 'นางสาว', 'นิศารัตน์', 'รำเพยพล', 'Ms', 'Nisarat', 'Rumphoeiphon', '1998-06-09', '2017-08-05', '0000-00-00', '1409901701966', 'นักศึกษาปกติ', 'ปริญญาตรี', '5440100002771', 'F01', 'D01', 'ภาคปกติ'),
('6030210334', 'นาย', 'อาชาญนนท์', 'แซ่ชื้อ', 'MR', 'Archanon', 'Saesue', '1998-10-27', '2017-08-05', '0000-00-00', '1100702785714', 'นักศึกษาปกติ', 'ปริญญาตรี', '3100702785714', 'F01', 'D01', 'ภาคปกติ');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Sub_ID` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `Sub_Name` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Sub_Credit` double(3,2) NOT NULL,
  `Sub_Description` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`Sub_ID`, `Sub_Name`, `Sub_Credit`, `Sub_Description`) VALUES
('000101', 'ภาษาอังกฤษ 1', 3.00, 'Eng'),
('000102', 'ภาษาอังกฤษ2', 3.00, ''),
('000103', 'ภาษาอังกฤษ 3', 3.00, ''),
('000104', 'ภาษาอังกฤษ 4', 3.00, ''),
('000145', 'ภาวะผู้และการจัดการ', 3.00, ''),
('000159', 'ความเป็นพลเมืองในสังคมประชาธิปไตย', 3.00, ''),
('000174', 'ทักษะการเรียนรู้', 3.00, ''),
('000175', 'การคิดเชิงสร้างสรรค์', 3.00, ''),
('1234', 'วิชา', 3.00, ''),
('2468', 'สันทนาการ', 3.00, 'ไปเต้นกัน '),
('300304', 'หลักมูลการระบุรูปพรรณส่วนบุคคล', 3.00, ''),
('300305', 'สารพิษชีวภาพทางนิติวิทยาศาสตร์', 3.00, ''),
('777100', 'ความรู้เบื้องต้นเกี่ยวกับกฎหมายทั่วไป', 3.00, ''),
('853161', 'ศิลปหัตถกรรมเครื่องเคลือบดินเผาเพื่อการพาณิชย์', 3.00, ''),
('861102', 'การปฎิบัติและวิเคราะห์ดนตรีไทย', 2.00, ''),
('870151', 'การออกแบบการ์ตูน', 3.00, ''),
('870154', 'การออกแบบโฆษณา', 3.00, ''),
('as', '', 3.00, ''),
('ED060021', 'นันทนาการเบื้องต้น', 2.00, ''),
('FA301201', 'การขับร้องประสานเสียงขั้นพื้นฐาน', 2.00, ''),
('FA461301', 'พื้นฐานการแสดงละครเวที', 3.00, ''),
('LI203010', 'ภาษาอังกฤษเทคนิคสำหรับวิทยาศาสตร์และเทคโนโลยี', 3.00, ''),
('SC0001002', 'วิทยาศาสตร์ เทคโนโลยีและนวัตกรรมเพื่อการพัฒนาที่ยั่งยืน', 3.00, ''),
('SC002104', 'วิทยาศาสตร์กายภาพ', 3.00, ''),
('SC311001', 'วิทยาการคอมพิวเตอร์หลักมูล', 3.00, ''),
('SC311002', 'การเขียนโปรแกรมเชิงโครงสร้างสำหรับวิทยาการคอมพิวเตอร์', 3.00, ''),
('SC311003', 'การเขียนโปรแกรมเชิงวัตถุ', 3.00, ''),
('SC311004', 'สถาปัตยกรรมระบบคอมพิวเตอร์', 3.00, ''),
('SC311301', 'การพัฒนาโปรแกรมประยุกต์บนเว็บ', 3.00, ''),
('SC311501', 'กาเขียนโปรแกรมภาษาจาวา', 3.00, ''),
('SC312001', 'โครงสร้างข้อมูล', 3.00, ''),
('SC312002', 'การโต้ตอบระหว่างมนุษย์และคอมพิวเตอร์', 3.00, ''),
('SC312003', 'ระบบจัดการฐานข้อมูลและการออกแบบฐานข้อมูล', 3.00, ''),
('SC312004', 'ปฏิบัติการระบบฐานข้อมูลและการออกแบบ', 1.00, ''),
('SC312005', 'เครือข่ายคอมพิวเตอร์', 3.00, ''),
('SC312006', 'การวิเคราะห์ขั้นตอนวิธี', 3.00, ''),
('SC312104', 'วิทยาการข้อมูลขั้นแนะนำ', 3.00, ''),
('SC312201', 'พื้นฐานการเขียนโปรแกรมเกม', 3.00, ''),
('SC313001', 'ระบบปฏิบัติการและการเขียนโปรแกรมซีสเต็มคอล', 3.00, ''),
('SC313002', 'หลักการออกแบบพัฒนาซอฟต์แวร์', 3.00, ''),
('SC313003', 'การวิเคราะห์และออกแบบระบบ', 3.00, ''),
('SC313102', 'โครงข่ายประสาทเทียม', 3.00, ''),
('SC313403', 'ความมั่นคงสารสนเทศและไซเบอร์', 3.00, ''),
('SC313504', 'การประกันคุณภาพซอต์แวร์', 3.00, ''),
('SC313761', 'สัมมนาทางวิทยาการคอมพิวเตอร์', 1.00, ''),
('SC401201', 'แคลคูลัสสำหรับวิทยาศาสตร์กายภาพ1', 3.00, ''),
('SC401202', 'แคลคูลัสสำหรับวิทยาศาสตร์กายภาพ2', 3.00, ''),
('SC402101', 'พีชคณิตเชิงเส้น1', 3.00, ''),
('SC402401', 'วิยุตคณิตและการประยุกต์', 3.00, ''),
('SC403602', 'วิธีเชิงตัวเลขสำหรับวิทยาการคอมพิวเตอร์', 3.00, ''),
('SC602005', 'ความน่าจะเป็นและสถิติ', 3.00, '');

-- --------------------------------------------------------

--
-- Table structure for table `typeprogram`
--

CREATE TABLE `typeprogram` (
  `Type_Program` char(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `typeprogram`
--

INSERT INTO `typeprogram` (`Type_Program`) VALUES
('ภาคปกติ'),
('ภาคพิเศษ');

-- --------------------------------------------------------

--
-- Table structure for table `year`
--

CREATE TABLE `year` (
  `Year_ID` char(4) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `year`
--

INSERT INTO `year` (`Year_ID`) VALUES
('2560'),
('2561'),
('2562'),
('2563'),
('2564');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Ad_Code`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Dep_ID`),
  ADD KEY `FK_Dep_Fac` (`Fac_ID`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`Fac_ID`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD KEY `FK_Grade_Std` (`Std_Code`),
  ADD KEY `FK_Grade_Sub` (`Sub_ID`),
  ADD KEY `FK_Grade_Year` (`Year_ID`),
  ADD KEY `FK_Grade_Semesterss` (`Semester_ID`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`Pr_ID`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`Semester_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Std_Code`),
  ADD KEY `FK_Std_Fac` (`Fac_ID`),
  ADD KEY `FK_Std_Dep` (`Dep_ID`),
  ADD KEY `FK_Std_Pr` (`Pr_ID`),
  ADD KEY `FK_Std_Typeprogram` (`Type_Program`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Sub_ID`);

--
-- Indexes for table `typeprogram`
--
ALTER TABLE `typeprogram`
  ADD PRIMARY KEY (`Type_Program`);

--
-- Indexes for table `year`
--
ALTER TABLE `year`
  ADD PRIMARY KEY (`Year_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `FK_Dep_Fac` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty` (`Fac_ID`);

--
-- Constraints for table `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `FK_Grade_Semesterss` FOREIGN KEY (`Semester_ID`) REFERENCES `semester` (`Semester_ID`),
  ADD CONSTRAINT `FK_Grade_Std` FOREIGN KEY (`Std_Code`) REFERENCES `student` (`Std_Code`),
  ADD CONSTRAINT `FK_Grade_Sub` FOREIGN KEY (`Sub_ID`) REFERENCES `subject` (`Sub_ID`),
  ADD CONSTRAINT `FK_Grade_Year` FOREIGN KEY (`Year_ID`) REFERENCES `year` (`Year_ID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FK_Std_Dep` FOREIGN KEY (`Dep_ID`) REFERENCES `department` (`Dep_ID`),
  ADD CONSTRAINT `FK_Std_Fac` FOREIGN KEY (`Fac_ID`) REFERENCES `faculty` (`Fac_ID`),
  ADD CONSTRAINT `FK_Std_Pr` FOREIGN KEY (`Pr_ID`) REFERENCES `parent` (`Pr_ID`),
  ADD CONSTRAINT `FK_Std_Typeprogram` FOREIGN KEY (`Type_Program`) REFERENCES `typeprogram` (`Type_Program`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
