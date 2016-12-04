/* groups by last name customers and all the rentals theyve had*/
SELECT customer.lname, COUNT(rental.ContractNumber) AS NumberOfRentals FROM (rental
INNER JOIN customer
ON rental.customer=customer.uid)
GROUP BY lname
HAVING COUNT(rental.ContractNumber);

/* counts the number of cars with mileages less than 5000 */
SELECT COUNT(*)
 FROM car
 WHERE Mileage < 5000;

/* selects the oldest car*/
 SELECT MIN(Year) 
 FROM car;

/* selects the newest car*/
 SELECT MAX(Year) 
 FROM car;

/* selects the average car year available */
 SELECT AVG(Year)
  FROM car;

/* selects all customers and their rental*/
 SELECT customer.lname, customer.fname, rental.ContractNumber
FROM customer 
FUll OUTER JOIN rental
ON customer.uid=rental.Customer
ORDER BY customer.lname;
