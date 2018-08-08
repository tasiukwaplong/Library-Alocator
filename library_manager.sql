-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 08, 2018 at 12:24 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library_manager`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'pass'),
(2, 'user', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `lended`
--

CREATE TABLE IF NOT EXISTS `lended` (
  `matric_or_id` varchar(200) NOT NULL,
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(700) NOT NULL,
  `date_collected` varchar(200) NOT NULL,
  `return_date` varchar(30) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `lended`
--

INSERT INTO `lended` (`matric_or_id`, `id`, `book_title`, `date_collected`, `return_date`, `status`) VALUES
('2031720001', 39, 'Programming', '2018-08-10', '2018-08-17', 1),
('2031720001', 40, 'Introduction to Computer', '2018-08-01', '2018-08-10', 0);

-- --------------------------------------------------------

--
-- Table structure for table `resources`
--

CREATE TABLE IF NOT EXISTS `resources` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `type` varchar(200) NOT NULL,
  `resource_id` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `copies` int(10) NOT NULL,
  `availability` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `resources`
--

INSERT INTO `resources` (`id`, `type`, `resource_id`, `title`, `copies`, `availability`) VALUES
(10, 'Book', '101', 'Introduction to Computer', 9, 1),
(14, 'Book', '201', 'Programming', 6, 1),
(16, 'Book', 'id', 'title', 90, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  `department` varchar(30) NOT NULL,
  `matric_or_id` varchar(30) NOT NULL,
  `name` varchar(200) NOT NULL,
  `phone` varchar(40) NOT NULL,
  `email` varchar(200) NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matric_or_id` (`matric_or_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `category`, `department`, `matric_or_id`, `name`, `phone`, `email`, `address`) VALUES
(20, 'Student', 'Computer Science', '2031720001', 'Tasiu Kwaplong S', '09031514346', 'tasiukwaplong@gmail.com', 'Tudun kauri Lafia');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
