-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2026 at 08:40 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_haven_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `category` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `title`, `author`, `category`, `price`, `quantity`) VALUES
(1, 'Harry Potter', 'J.K. Rowling', 'Fiction', 2500, 10),
(2, 'Java Programming', 'Herbert Schildt', 'Academic', 4500, 5),
(3, 'Sherlock Holmes', 'Chandana Mendis', 'Fiction', 10000, 20),
(4, 'Bihisunu Nimnaya', 'Chandana Mendis', 'Fiction', 500, 3),
(5, 'Bihisunu Nimnaya', 'Nimal Perera', 'Fiction', 1000, 5),
(6, 'test Book', 'tset author', 'Fiction', 1000, 40),
(7, 'testbook2', 'tsetauthor2', 'Fiction', 1000, 50),
(8, 'testbook3', 'testauthor3', 'Fiction', 10000, 10),
(9, 'testbookfinal', 'authorfinal', 'Fiction', 1000, 50),
(10, 'finaltest', 'finalauthor', 'Fiction', 5000, 5),
(17, 'banana', 'banana', 'Magazines', 500, 20),
(18, 'Pinaple', 'pinaple', 'Non-fiction', 500, 20),
(21, '2026book', '2026', 'Non-fiction', 1000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `role`) VALUES
(1, 'manager', '1234', 'Manager'),
(2, 'cashier', '1234', 'Cashier'),
(3, 'Amal', '1234', 'Manager'),
(4, 'Sunil', '1234', 'Cashier'),
(5, 'Kasun', '1234', 'Cashier'),
(6, 'testcashier', '1234', 'Cashier'),
(7, 'finalcashier', '1234', 'Cashier'),
(8, 'cashier01', '1234', 'Cashier'),
(9, 'cashier02', '1234', 'Cashier'),
(10, 'manager01', '1234', 'Manager'),
(11, 'cashier05', '1234', 'Cashier'),
(12, 'manager05', '1234', 'Manager'),
(13, 'supun', '1234', 'Cashier'),
(14, '2026cashier', '1234', 'Cashier'),
(15, '2026manager', '1234', 'Manager'),
(16, 'manager2026', '1234', 'Manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
