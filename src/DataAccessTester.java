import java.time.LocalDate;

public class DataAccessTester {
	
	public static void main(String[] args) throws Exception {
		
		int customerId = 2;
		String fname = "testingRental";
		String lname = "rentallastname";
		int age = 25;
		String licenceNumber = "6666";
		String ccNumber = "33";
		
		int carId = 4;
		String make = "nissan";
		String model = "sentra";
		int year = 2016;
		int mileage = 5;
		String condition = "new";
		String type = "A";
		int price = 50;
//		String status = "onHand";
		int insurancePrice;
		String insurance = "No";
		insurancePrice = (insurance == "Yes")?15:0; 	//if insurance=yes, insurance price is 15. else 0
		
		int agencyId = 1;
		LocalDate startDate = LocalDate.of(2016, 12, 25);
		LocalDate endDate = LocalDate.of(2016, 12, 26);
		
		int contractNumber = 1; //no purpose other than creating object
		
		//calculate totalDays by changing LocalDate to epoch times and subtracting them
		int totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
		String status = "onRent";
		
		int	underageFee = 30;	
		Customer customer = new Customer(fname, lname, age, licenceNumber, ccNumber, status);
		Car car = new Car(carId, make, model, year, mileage, condition, type, price, status);
		
		Dates dates = new Dates(startDate, endDate, totalDays);
		Reservation reservation = new Reservation(1, 2, agencyId, dates);
		
		int totalPrice = (car.getPrice() * totalDays) + (insurancePrice * totalDays);
		DataAccess dao = new DataAccess();
		Customer c = dao.searchCustomer(2);
		Car car2 = dao.searchCar(1);
		if (dao.under25(c.getCustomerId()))
		{
			totalPrice = totalPrice + underageFee;
		}
		//Rental rental = new Rental(contractNumber, c.getCustomerId(), car2, agencyId, insurance, insurancePrice, dates, totalPrice, status);
//		dao.getAllReservations();		
		//dao.addCustomer(customer);	//works
		//dao.addCar(car);			//works
		//System.out.println(customer.getCustomerId());
		//System.out.println(c.getCustomerId());
		//dao.addReservation(c.getCustomerId(), agencyId, dates);	//works
		//System.out.println(c.getStatus());
//		dao.rentalCheckOut(rental, car2, dates); //works
		//dao.updateAgency(1, "456 Faek Street", "San Jose", 95192); //works
		//dao.rentalCheckIn(1, 150);
		//dao.cancelReservation(2); //works
//		List res = dao.getAllReservations();
//		for (int i = 0; i < res.size(); i++){
//			System.out.println(res.get(i).toString());
//		}
//		
//		dao.cancelReservation(5);
//		
//		List res2 = dao.getAllReservations();
//		for (int i = 0; i < res2.size(); i++){
//			System.out.println(res2.get(i).toString());
//		}
		
		//dao.cancelReservation(reservationNumber);
		
//		test searchCar
//		Car c = dao.searchCar(2);
//		System.out.println(c.toString());
		
		//test update systems
//		System.out.println(dao.searchReservation(3));
//		dao.updateReservation(3, reservation);
//		System.out.println(dao.searchReservation(3));
		
//		System.out.println(dao.searchRental(8));
//		System.out.println(dao.searchCustomer(2));
		//dao.updateCustomer(5, new Customer("Jake", "Snake", 90, "567890", "4567890", "Test"));
		System.out.println(dao.getOldestCarYear());
		System.out.println(dao.getNewestCarYear());
		System.out.println(dao.getAverageCarYear());
	}

}
