DELIMITER $$

CREATE TRIGGER InsertRental
AFTER INSERT ON Rental
FOR EACH ROW
BEGIN
	IF NEW.car in (SELECT cID from car) and NEW.customer in (SELECT uID from customer)
	THEN UPDATE `car` set
	`status` = 'rented';
	UPDATE `customer` set
	`status` = 'rented';
	END IF;
END $$



CREATE TRIGGER DeleteRental
AFTER DELETE ON Rental
FOR EACH ROW
BEGIN
	IF OLD.car in (SELECT cID from car) 
	THEN UPDATE `car` set
	`status` = 'on hand';
	UPDATE `customer` set
	`status` = 'returned';
	END IF;
END $$

DELIMITER ;