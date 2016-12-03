DELIMITER $$

DROP TRIGGER IF EXISTS InsertRental;
CREATE TRIGGER InsertRental
AFTER INSERT ON Rental
FOR EACH ROW
BEGIN
	IF NEW.car in (SELECT cID from car) and NEW.customer in (SELECT uID from customer)
	THEN UPDATE `car` set
	`CarStatus` = 'rented' WHERE car.cID = NEW.car;
	UPDATE `customer` set
	`CustomerStatus` = 'rented' WHERE customer.uID = NEW.customer;
	END IF;
END $$


DROP TRIGGER IF EXISTS DeleteRental;
CREATE TRIGGER DeleteRental
AFTER DELETE ON Rental
FOR EACH ROW
BEGIN
	IF OLD.car in (SELECT cID from car) and OLD.customer in (SELECT uID from customer)
	THEN UPDATE `car` set
	`CarStatus` = 'on hand' WHERE car.cID = OLD.car;
	UPDATE `customer` set
	`CustomerStatus` = 'returned' WHERE customer.uID = OLD.customer;
	END IF;
END $$

DELIMITER ;