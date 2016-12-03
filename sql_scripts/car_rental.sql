CREATE DATABASE IF NOT EXISTS `carrental`;
USE `carrental`;

DROP TABLE IF EXISTS `agency`;
CREATE TABLE IF NOT EXISTS `agency` (
  `aID` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Address` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Zip` int(11) NOT NULL
);

INSERT INTO `agency` (`Address`, `City`, `Zip`) VALUES
('123 Main St', 'San Jose', 95192);


DROP TABLE IF EXISTS `car`;
CREATE TABLE IF NOT EXISTS `car` (
  `cID` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Make` varchar(255) NOT NULL,
  `Model` varchar(255) NOT NULL,
  `Year` int(11) NOT NULL,
  `Mileage` int(11) NOT NULL,
  `vehicleCondition` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Price` int(10) NOT NULL,
  `CarStatus` varchar(255) NOT NULL
);

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `uid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `age` int(10) NOT NULL,
  `LicenceNumber` varchar(10) NOT NULL,
  `ccNumber` varchar(16) NOT NULL,
  `CustomerStatus` varchar(255) NOT NULL
);

DROP TABLE IF EXISTS `rental`;
CREATE TABLE IF NOT EXISTS `rental` (
  `ContractNumber` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Customer` int(11) NOT NULL, FOREIGN KEY (Customer) REFERENCES customer(uid),
  `Car` int(11) NOT NULL, FOREIGN KEY (Car) REFERENCES car(cid),
  'MilesOut' int(11) NOT NULL,
  'MilesIn' int(11) NOT NULL,
  `Agency` int(11) NOT NULL, FOREIGN KEY(Agency) REFERENCES agency(aid),
  `Insurance` varchar(10) NOT NULL,
  `InsurancePrice` int(10) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `TotalDays` int(11) NOT NULL,
  `TotalPrice` int(11) NOT NULL,
  'RentalStatus' varchar(10) default 'onRent'
);

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `ReservationNumber` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `Customer` int(11) NOT NULL, FOREIGN KEY (Customer) REFERENCES customer(uID),
  `Agency` int(11) NOT NULL, FOREIGN KEY (Agency) REFERENCES agency(aID),
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `TotalDays` int(11) NOT NULL
);
