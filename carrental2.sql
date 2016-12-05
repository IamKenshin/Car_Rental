-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2016 at 05:42 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `carrental2`
--

-- --------------------------------------------------------

--
-- Table structure for table `agency`
--

CREATE TABLE IF NOT EXISTS `agency` (
  `aID` int(11) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Zip` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agency`
--

INSERT INTO `agency` (`aID`, `Address`, `City`, `Zip`) VALUES
(1, '123 Main St', 'San Jose', 95192);

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `cID` int(11) NOT NULL,
  `Make` varchar(255) NOT NULL,
  `Model` varchar(255) NOT NULL,
  `Year` int(11) NOT NULL,
  `Mileage` int(11) NOT NULL,
  `vehicleCondition` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Price` int(10) NOT NULL,
  `CarStatus` varchar(255) NOT NULL DEFAULT 'onHand'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`cID`, `Make`, `Model`, `Year`, `Mileage`, `vehicleCondition`, `Type`, `Price`, `CarStatus`) VALUES
(1, 'Toyota', 'Corolla', 2016, 1, 'New', 'A', 40, 'rented'),
(2, 'Ford', 'Fusion', 2016, 1, 'New', 'E', 60, 'rented'),
(3, 'Ford ', 'Focus', 2017, 1, 'New', 'C', 50, 'rented'),
(4, 'Cadillac', 'Escalade', 2017, 100, 'new', 'E', 499, 'rented'),
(5, 'Cadillac', 'Escalade', 2017, 100, 'new', 'E', 499, 'rented'),
(6, 'Cadillac', 'Escalade', 2017, 100, 'new', 'E', 499, 'rented'),
(7, 'Cadillac', 'Escalade', 2017, 100, 'new', 'E', 499, 'rented'),
(8, 'Cadillac', 'Escalade', 2017, 100, 'new', 'E', 499, 'rented'),
(9, 'toyota', 'corolla', 2016, 20000, 'new', 'type', 50, 'rented');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `uid` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `age` int(10) NOT NULL,
  `LicenceNumber` varchar(10) NOT NULL,
  `ccNumber` varchar(16) NOT NULL,
  `CustomerStatus` varchar(255) NOT NULL DEFAULT 'reservation'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`uid`, `fname`, `lname`, `age`, `LicenceNumber`, `ccNumber`, `CustomerStatus`) VALUES
(1, 'Steph', 'Curry', 32, 'A883293', '4444', 'rented'),
(2, 'LeBron', 'James', 30, 'E323343', '5555', 'rented'),
(3, 'fname', 'lname', 30, 'abc123', '1234123412341234', 'rented'),
(4, 'fname', 'lname', 30, 'abc123', '1234123412341234', 'rented'),
(5, 'aayush', 'lname', 30, 'abc123', '1234123412341234', 'rented'),
(6, 'firstname', 'lastname', 25, 'eeee', '4444', 'rented'),
(7, 'customer', 'man', 35, 'alksdfj', '1234', 'rented'),
(8, 'next', 'one', 15, '12312', '99999', 'rented');

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE IF NOT EXISTS `rental` (
  `ContractNumber` int(11) NOT NULL,
  `Customer` int(11) NOT NULL,
  `Car` int(11) NOT NULL,
  `MilesOut` int(11) NOT NULL,
  `MilesIn` int(11) NOT NULL,
  `Agency` int(11) NOT NULL,
  `Insurance` varchar(10) NOT NULL,
  `InsurancePrice` int(10) NOT NULL DEFAULT '15',
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `TotalDays` int(11) NOT NULL,
  `TotalPrice` int(11) NOT NULL,
  `RentalStatus` varchar(10) NOT NULL DEFAULT 'onRent'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rental`
--

INSERT INTO `rental` (`ContractNumber`, `Customer`, `Car`, `MilesOut`, `MilesIn`, `Agency`, `Insurance`, `InsurancePrice`, `StartDate`, `EndDate`, `TotalDays`, `TotalPrice`, `RentalStatus`) VALUES
(1, 1, 3, 0, 100, 1, 'Yes', 15, '2016-11-30', '2016-12-02', 2, 130, 'returned'),
(2, 5, 4, 5, 150, 1, 'Yes', 15, '2016-12-07', '2016-12-17', 10, 650, 'Returned'),
(8, 5, 4, 5, 0, 1, 'No', 0, '2016-10-07', '2016-11-17', 41, 2050, 'onRent');

--
-- Triggers `rental`
--
DELIMITER $$
CREATE TRIGGER `DeleteRental` AFTER DELETE ON `rental`
 FOR EACH ROW BEGIN
	IF OLD.car in (SELECT cID from car) 
	THEN UPDATE `car` set
	`CarStatus` = 'on hand';
	UPDATE `customer` set
	`CustomerStatus` = 'returned';
	END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `InsertRental` AFTER INSERT ON `rental`
 FOR EACH ROW BEGIN
	IF NEW.car in (SELECT cID from car) and NEW.customer in (SELECT uID from customer)
	THEN UPDATE `car` set
	`CarStatus` = 'rented';
	UPDATE `customer` set
	`CustomerStatus` = 'rented';
	END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `ReservationNumber` int(11) NOT NULL,
  `Customer` int(11) NOT NULL,
  `Agency` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `TotalDays` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`ReservationNumber`, `Customer`, `Agency`, `StartDate`, `EndDate`, `TotalDays`) VALUES
(1, 1, 1, '2016-11-30', '2016-12-02', 2),
(2, 2, 1, '2016-12-01', '2016-12-08', 7),
(3, 1, 1, '2016-11-30', '2016-12-03', 3),
(4, 6, 1, '2016-12-07', '2016-12-17', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agency`
--
ALTER TABLE `agency`
  ADD PRIMARY KEY (`aID`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`cID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`ContractNumber`), ADD KEY `Customer` (`Customer`), ADD KEY `Car` (`Car`), ADD KEY `Agency` (`Agency`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`ReservationNumber`), ADD KEY `Customer` (`Customer`), ADD KEY `Agency` (`Agency`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agency`
--
ALTER TABLE `agency`
  MODIFY `aID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `cID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `rental`
--
ALTER TABLE `rental`
  MODIFY `ContractNumber` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `ReservationNumber` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
ADD CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`Customer`) REFERENCES `customer` (`uid`),
ADD CONSTRAINT `rental_ibfk_2` FOREIGN KEY (`Car`) REFERENCES `car` (`cID`),
ADD CONSTRAINT `rental_ibfk_3` FOREIGN KEY (`Agency`) REFERENCES `agency` (`aID`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`Customer`) REFERENCES `customer` (`uid`),
ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`Agency`) REFERENCES `agency` (`aID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
