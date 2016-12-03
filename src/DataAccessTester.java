

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
//import DataAccess;

public class DataAccessTester {
	public static void main(String[] args) throws Exception {
		
		int customerId = 5;
		String fname = "rentalname";
		String lname = "rentallastname";
		int age = 21;
		String licenceNumber = "6666";
		String ccNumber = "33";
		
		int carId = 4;
		String make = "nissan";
		String model = "sentra";
		int year = 2016;
		int mileage = 5;
		String condition = "new";
		String type = "type";
		int price = 50;
//		String status = "onHand";
		int insurancePrice;
		String insurance = "Yes";
		insurancePrice = (insurance == "Yes")?15:0; 	//if insurance=yes, insurance price is 15. else 0
		
		int agencyId = 1;
		LocalDate startDate = LocalDate.of(2016, 12, 07);
		LocalDate endDate = LocalDate.of(2016, 12, 17);
		
		int contractNumber = 1; //no purpose other than creating object
		
		//calculate totalDays by changing LocalDate to epoch times and subtracting them
		int totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
		String status = "onRent";
				
		Customer customer = new Customer(customerId, fname, lname, age, licenceNumber, ccNumber);
		Car car = new Car(carId, make, model, year, mileage, condition, type, price, status);
		
		Dates dates = new Dates(startDate, endDate, totalDays);
		Reservation reservation = new Reservation(1, customerId, agencyId, dates);
		
		int totalPrice = (car.getPrice() * totalDays) + (insurancePrice * totalDays);
		Rental rental = new Rental(contractNumber, customerId, car, agencyId, insurance, insurancePrice, dates, totalPrice, status);
		DataAccess dao = new DataAccess();
//		dao.getAllReservations();		
//		dao.addCustomer(customer));	//works
//		dao.addCar(car);			//works
//		dao.addReservation(customerId, agencyId, dates);	//works
		
//		dao.addRentalCheckOut(rental, car, dates);
		dao.updateRentalCheckIn(2, 150);
	}

}
