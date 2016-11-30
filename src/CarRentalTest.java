
public class CarRentalTest {

	public static void main(String[] args) {
		
		int agencyId = 1;
		String address = "123 main st";
		String city = "San Jose";
		int zip = 94012;
		
		int carId = 1;
		String make = "toyota";
		String model = "corolla";
		int year = 2016;
		int mileage = 20000;
		String condition = "new";
		String type = "type";
		int price = 50;
		
		int customerId = 1;
		String fname = "fname";
		String lname = "lname";
		int age = 30;
		String licenceNumber = "abc123";
		String ccNumber = "1234123412341234";
		String status = "rented";
		
		int contractNumber = 1;
		String insurance = "aaa";
		int insurancePrice = 15;
		int totalPrice = 200;
		
		int reservationNumber = 1;
		
		Agency agency = new Agency(agencyId, address, city, zip);
		Car car = new Car(carId, make, model, year, mileage, condition, type, price);
		Customer customer = new Customer(customerId, fname, lname, age, licenceNumber, ccNumber, car, status);
		Rental rental = new Rental(contractNumber, customer.getCustomerId(), car.getCarId(), agencyId, insurance, insurancePrice, totalPrice);
		Reservation reservation = new Reservation(reservationNumber, customer.getCustomerId(), agency.getAgencyID());
		
		

	}

}
