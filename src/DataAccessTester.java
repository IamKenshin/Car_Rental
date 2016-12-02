

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
//import DataAccess;

public class DataAccessTester {
	public static void main(String[] args) throws Exception {
		
		int customerId = 1;
		String fname = "next";
		String lname = "one";
		int age = 15;
		String licenceNumber = "12312";
		String ccNumber = "99999";
		
		int carId = 1;
		String make = "toyota";
		String model = "corolla";
		int year = 2016;
		int mileage = 20000;
		String condition = "new";
		String type = "type";
		int price = 50;
		String status = "onHand";
		
		int agencyId = 1;
		LocalDate startDate = LocalDate.of(2016, 12, 07);
		LocalDate endDate = LocalDate.of(2016, 12, 17);
		
		//calculate totalDays by changing LocalDate to epoch times and subtracting them
		int totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
				
		Customer customer = new Customer(customerId, fname, lname, age, licenceNumber, ccNumber);
		Car car = new Car(carId, make, model, year, mileage, condition, type, price, status);
		
		Dates dates = new Dates(startDate, endDate, totalDays);
		Reservation reservation = new Reservation(1, customerId, agencyId, dates);
		
		DataAccess dao = new DataAccess();
//		dao.getAllReservations();	
		System.out.println(dao.addCustomer(customer));	//works
//		dao.addCar(car);			//works
//		dao.addReservation(customerId, agencyId, dates);
	}

}
