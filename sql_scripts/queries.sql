/* groups by last name the customers and all the rentals theyve had*/
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

/* shows the prices of each car
 SELECT make, model, year, price 
 FROM car;
*/
  
/* selects all customers and their rental
 SELECT customer.lname, customer.fname, rental.ContractNumber
FROM customer 
FUll OUTER JOIN rental
ON customer.uid=rental.Customer
ORDER BY customer.lname;
*/
  
/* pairs each rented car with the customer and the age of the oldest renter of that car*/
select distinct car.make, car.model, car.year, lname, fname, age
from customer, car, rental
where car.cid=rental.car and customer.uid = rental.customer
and age >= all
(select age
from customer, rental
where customer.uid = rental.customer and car.cid =rental.car and
age is not null);

/* selects list of cars that has not yet been rented*/
SELECT * FROM car
WHERE NOT EXISTS
(SELECT * FROM rental WHERE rental.car = car.cid);

/* selects list of cars that has been rented*/
SELECT * FROM car 
WHERE EXISTS (SELECT * FROM rental
WHERE rental.car=car.cid);


