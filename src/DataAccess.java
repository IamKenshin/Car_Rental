import java.util.*;
import java.time.LocalDate;
import java.sql.*;
import java.io.*;


/**
 * This class consists of the methods that are used to talk to the database 
 * and exchange data between the controller and the database.
 * 
 * @author Aayush Neupane
 */
public class DataAccess {

	private Connection myConn;			//database connection		

	/**
	 * Default constructor that gets database connection
	 * @throws Exception
	 */
	public DataAccess() {

		// get db properties
		Properties props = new Properties();
		try {
			props.load((new FileInputStream("demo.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//get username, password, dburl from demo.properties
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		
		// connect to database
		try {
			myConn = DriverManager.getConnection(dburl, user, password);
			if (myConn != null)
				System.out.println("DB connection successful to: " + dburl);
			else
				System.out.println("DB Connection failed!");
		} catch (SQLException e) {
			e.printStackTrace();
				String sqlMessage = e.getMessage();
		      String sqlState = e.getSQLState();
		      int vendorCode = e.getErrorCode();
		      System.err.println("Exception occurred:");
		      System.err.println("Message: " + sqlMessage);
		      System.err.println("SQL state: " + sqlState);
		      System.err.println("Vendor code: " + vendorCode + "\n----------------");
		}

		
	}
	
	/**
	 * Close the database connection
	 * @param myConn
	 * @param stmt
	 * @param myRs
	 * @throws SQLException
	 */
	private static void close(Connection myConn, Statement stmt, ResultSet myRs)
	{
		if (myRs != null) {
			try {
				myRs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stmt != null) {	//nothing
		}

		if (myConn != null) {
			try {
				myConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Close the database connection using given params
	 * @param stmt
	 * @param myRs
	 * @throws SQLException
	 */
	private void close(Statement stmt, ResultSet myRs)
	{
		close(null, stmt, myRs);		
	}
	
	/**
	 * Displays all the Reservations.
	 * Gets the reservationNumber, agency, customer, start/end dates, totaldays from db
	 * create a date object. 
	 * create a reservation object with all the info. 
	 * add that to a list, return list.
	 * 
	 * This creates
	 * resId | fName | lName | startDate | endDate | totalDays
	 * 
	 * @return an arraylist of the Reservation
	 * @throws Exception
	 */
	public List<Reservation> getAllReservations()
	{
		List<Reservation> list = new ArrayList<>();

		Statement stmt = null;
		ResultSet myRs = null;

		try {
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("select reservation.*, fname, lname "
					+ "from customer, reservation "
					+ "where reservation.Customer = customer.uid");
			
			while (myRs.next()){
				int reservationNumber = myRs.getInt("ReservationNumber");
				String fName = myRs.getString("fname");
				String lName = myRs.getString("lname");
				int agencyId = myRs.getInt("Agency");
				int customerId = myRs.getInt("Customer");
				
				LocalDate startDate = myRs.getDate("StartDate").toLocalDate();
				LocalDate endDate = myRs.getDate("endDate").toLocalDate();
				int totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
				
				Dates dates = new Dates(startDate, endDate, totalDays);
				Reservation reservation = new Reservation(reservationNumber, 
											customerId, fName, lName, agencyId, dates);
				list.add(reservation);
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	
	/**
	 * Creates a list of Cars object populated by the data
	 * @return List<Car>
	 */
	public List<Car> getAllCars(){
		List<Car> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("select * from car");
			
			while (myRs.next()){
				int carId = myRs.getInt("cID");
				String make = myRs.getString("Make");
				String model = myRs.getString("Model");
				int year = myRs.getInt("Year");
				int mileage = myRs.getInt("Mileage");
				String condition = myRs.getString("vehicleCondition");
				String type = myRs.getString("Type");
				int price = myRs.getInt("price");
				String status = myRs.getString("CarStatus");
				
				Car car = new Car(carId, make, model, year, mileage, condition, type, price, status);
				list.add(car);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}

	/**
	 * create a list of all the customers available on the database
	 * @return list of customer object.
	 */
	public List<Customer> getAllCustomers(){
		List<Customer> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("select * from customer");
			
			while (myRs.next()){
				int customerId = myRs.getInt("uid");
				String fname = myRs.getString("fname");
				String lname = myRs.getString("lname");
				int age = myRs.getInt("age");
				String licenceNumber = myRs.getString("LicenceNumber");
				String ccNumber = myRs.getString("ccNumber");
				String status = myRs.getString("CustomerStatus");
				
				Customer customer = new Customer(fname, lname, age, licenceNumber, ccNumber, status);
				customer.setUserID(customerId);
				list.add(customer);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	
	/**
	 * Creates a list of Rentals regardless of status (onrent and returned, both included)
	 * that has information about customer, car, dates
	 * @return list<Rental>
	 */
	public List<Rental> getAllRentals(){
		List<Rental> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT fname, lname, year, make, model, rental.* "
					+ "from customer, car, rental "
					+ "where rental.Customer = customer.uid and rental.Car=car.cID");
			
			while (myRs.next()){
				int contractNumber = myRs.getInt("ContractNumber");
				String fName = myRs.getString("fname");
				String lName = myRs.getString("lname");
				int year = myRs.getInt("year");
				String make = myRs.getString("make");
				String model = myRs.getString("model");
				int milesOut = myRs.getInt("MilesOut");
				int milesIn = myRs.getInt("MilesIn");
				int agencyId = myRs.getInt("Agency");
				LocalDate startDate = myRs.getDate("StartDate").toLocalDate();
				LocalDate endDate = myRs.getDate("EndDate").toLocalDate();
				int totalDays = myRs.getInt("TotalDays");
				int totalPrice = myRs.getInt("TotalPrice");
				String status = myRs.getString("rentalStatus");
				int uid = myRs.getInt("uid");
				int cID = myRs.getInt("cID");
				int insPrice = myRs.getInt("InsurancePrice");
				String insurance = myRs.getString("insurance");
				
				Rental rental = new Rental(contractNumber, uid, cID, insurance, insPrice, year, milesOut, milesIn, agencyId, totalDays, totalPrice, fName, lName, status, make, model, startDate, endDate);
				list.add(rental);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	
	/**
	 * This creates a list of rentals that have 'onrent' status. 
	 * @return
	 */
	public List<Rental> getAllActiveRentals(){
		List<Rental> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT fname, lname, year, make, model, rental.* "
					+ "from customer, car, rental "
					+ "where rental.Customer = customer.uid and rental.Car=car.cID and rental.RentalStatus='onRent'");
			
			while (myRs.next()){
				int contractNumber = myRs.getInt("ContractNumber");
				String fName = myRs.getString("fname");
				String lName = myRs.getString("lname");
				int year = myRs.getInt("year");
				String make = myRs.getString("make");
				String model = myRs.getString("model");
				int milesOut = myRs.getInt("MilesOut");
				int milesIn = myRs.getInt("MilesIn");
				int agencyId = myRs.getInt("Agency");
				LocalDate startDate = myRs.getDate("StartDate").toLocalDate();
				LocalDate endDate = myRs.getDate("EndDate").toLocalDate();
				int totalDays = myRs.getInt("TotalDays");
				int totalPrice = myRs.getInt("TotalPrice");
				String status = myRs.getString("rentalStatus");
				int uid = myRs.getInt("uid");
				int cID = myRs.getInt("cID");
				int insPrice = myRs.getInt("InsurancePrice");
				String insurance = myRs.getString("insurance");
				
				Rental rental = new Rental(contractNumber, uid, cID, insurance, insPrice, year, milesOut, milesIn, agencyId, totalDays, totalPrice, fName, lName, status, make, model, startDate, endDate);
				list.add(rental);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	
	
	/**
	 * This shows the oldest car year available. 
	 * @return year of oldest car(s).
	 */
	public int getOldestCarYear(){
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT MIN(Year)"
					+ " FROM car");
			
			while (myRs.next()){
				return myRs.getInt("MIN(year)");
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return -1;
	}
	
	/**
	 * This shows the newest car year available. 
	 * @return year of newest car(s).
	 */
	public int getNewestCarYear(){
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT Max(Year)"
					+ " FROM car");
			
			while (myRs.next()){
				return myRs.getInt("Max(year)");
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return -1;
	}
	
	/**
	 * This shows the average car year available. 
	 * @return
	 */
	public double getAverageCarYear(){
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT AVG(Year)"
					+ " FROM car");
			
			while (myRs.next()){
				return myRs.getDouble("AVG(year)");

			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return -1;
	} 
	
	/**
	 * This groups by lastname, the customers and their number of rentals. 
	 * @return
	 */
	public List<Rental> getNumberOfRental(){
		List<Rental> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT customer.lname, COUNT(rental.ContractNumber)"
					+ "AS NumberOfRentals FROM (rental INNER JOIN customer ON rental.customer=customer.uid) "
					+ "GROUP BY lname"
					+ " HAVING COUNT(rental.ContractNumber)");
			
			while (myRs.next()){
				String lName = myRs.getString("lname");
				int numberofrentals = myRs.getInt("COUNT(rental.ContractNumber)");
				
				Rental rental = new Rental(lName, numberofrentals);
				list.add(rental);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	
	/**
	 * create a list of each rented car with its customer and the age of the oldest renter of that car
	 * @return 
	 */
	public List<Customer> getAllRentedCarAndOldestRenter(){
		List<Customer> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("select distinct car.make, car.model, car.year, lname, fname, age"
					+ "from customer, car, rental "
					+ "where car.cid=rental.car and customer.uid = rental.customer"
					+ " and age >= all (select age from customer, rental where customer.uid = rental.customer and car.cid =rental.car and age is not null)");
			
			while (myRs.next()){
				String make = myRs.getString("make");
				String model = myRs.getString("model");
				int year = myRs.getInt("year");
				String fName = myRs.getString("fname");
				String lName = myRs.getString("lname");
				int age = myRs.getInt("age");
				
				Customer customer = new Customer(make, model, year, fName, lName, age);
				list.add(customer);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	
	/**
	 * Creates a list of Cars that has never been rented
	 * @return List<Car>
	 */
	public List<Car> getUnusedCars(){
		List<Car> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT * FROM car"
					+ " WHERE NOT EXISTS (SELECT * FROM rental WHERE rental.car = car.cid)");
			
			while (myRs.next()){
				int carId = myRs.getInt("cID");
				String make = myRs.getString("Make");
				String model = myRs.getString("Model");
				int year = myRs.getInt("Year");
				int mileage = myRs.getInt("Mileage");
				String condition = myRs.getString("vehicleCondition");
				String type = myRs.getString("Type");
				int price = myRs.getInt("price");
				String status = myRs.getString("CarStatus");
				
				Car car = new Car(carId, make, model, year, mileage, condition, type, price, status);
				list.add(car);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}

	
	/**
	 * Creates a list of Cused cars
	 * @return List<Car>
	 */
	public List<Car> getUsedCars(){
		List<Car> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet myRs = null;
		
		try{
			stmt = myConn.createStatement();
			myRs = stmt.executeQuery("SELECT * FROM car"
					+ " WHERE EXISTS (SELECT * FROM rental WHERE rental.car=car.cid);");
			
			while (myRs.next()){
				int carId = myRs.getInt("cID");
				String make = myRs.getString("Make");
				String model = myRs.getString("Model");
				int year = myRs.getInt("Year");
				int mileage = myRs.getInt("Mileage");
				String condition = myRs.getString("vehicleCondition");
				String type = myRs.getString("Type");
				int price = myRs.getInt("price");
				String status = myRs.getString("CarStatus");
				
				Car car = new Car(carId, make, model, year, mileage, condition, type, price, status);
				list.add(car);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(stmt, myRs);
		}
		return list;
	}
	/**
	 * add items from customer object into the database.
	 * @param customer object containing all the information that are added. 
	 * @return primary key of the inserted row. (last customerId)
	 */
	public int addCustomer(Customer customer){
		int insertedCustomerId = 0;					//primary key that is inserted
		String fname = customer.getFname();
		String lname = customer.getLname();
		int age = customer.getAge();
		String licenceNumber = customer.getLicenceNumber();
		String ccNumber = customer.getCcNumber();
		
		try{
			String sql = "INSERT INTO customer" + 
						 "(fname, lname, age, LICENCENUMBER, ccNumber) VALUES" +
						 "(?, ?, ?, ?, ?)";
			PreparedStatement prepStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, fname);
			prepStmt.setString(2, lname);
			prepStmt.setInt(3, age);
			prepStmt.setString(4, licenceNumber);
			prepStmt.setString(5, ccNumber);
		
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("added new person");
			ResultSet rs = prepStmt.getGeneratedKeys();
			if (rs.next())
				insertedCustomerId = rs.getInt(1);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		//return this to caller so addreservation or addrental can customerId
		return insertedCustomerId;				
	}
	
	/**
	 * Adds a items from Car object to the database using prepared statements
	 * @param car
	 */
	public int addCar(Car car){
		String make = car.getMake();
		String model = car.getModel();
		int year = car.getYear();
		int mileage = car.getMileage();
		String condition = car.getCondition();
		String type = car.getType();
		int price = car.getPrice();
		String status = car.getStatus();
		
		try{
			String sql = "INSERT INTO car" + 
						 "(make, model, year, mileage, vehicleCondition, type, price, CarStatus) VALUES " +
						 "(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prepStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setString(1, make);
			prepStmt.setString(2, model);
			prepStmt.setInt(3, year);
			prepStmt.setInt(4, mileage);
			prepStmt.setString(5, condition);
			prepStmt.setString(6, type);
			prepStmt.setInt(7, price);
			prepStmt.setString(8, status);
		
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("added new car");
			ResultSet rs = prepStmt.getGeneratedKeys();
			if (rs.next())
				return rs.getInt(1);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Add information from reservation object to the database
	 * @param customerId - primary key id for customer
	 * @param agencyId	- primary key id for agency
	 * @param dates	- dates when the customer wants the vehicle
	 */
	
	public void addReservation(int customerId, int agencyId, Dates dates){
		
		try{
			String sql = "INSERT INTO reservation" +
						 "(Customer, Agency, StartDate, EndDate, TotalDays) VALUES " +
						 "(?, ?, ?, ?, ?)";
			PreparedStatement prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, customerId);
			prepStmt.setInt(2, agencyId);
			prepStmt.setDate(3, java.sql.Date.valueOf(dates.getStartDate()));
			prepStmt.setDate(4, java.sql.Date.valueOf(dates.getEndDate()));
			prepStmt.setInt(5, dates.getTotalDays());
			
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("added new reservation");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Add information from reservation object to the database
	 * @param reservation - object
	 * @return - inserted reservationID 	//this can be used in gui's add reservation 
	 */
	public int addReservation(Reservation reservation){
		int insertedReservationId = 0;
		try{
			String sql = "INSERT INTO reservation" +
						 "(Customer, Agency, StartDate, EndDate, TotalDays) VALUES " +
						 "(?, ?, ?, ?, ?)";
			PreparedStatement prepStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepStmt.setInt(1, reservation.getCustomerId());
			prepStmt.setInt(2, reservation.getAgencyId());
			prepStmt.setDate(3, java.sql.Date.valueOf(reservation.getStartDate()));
			prepStmt.setDate(4, java.sql.Date.valueOf(reservation.getEndDate()));
			prepStmt.setInt(5, reservation.getTotalDays());
			
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("added new reservation");
			ResultSet rs = prepStmt.getGeneratedKeys();
			if (rs.next())
				insertedReservationId = rs.getInt(1);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return insertedReservationId;
	}
	
	/**
	 * Writes to the rental database with the information about rental, car, and dates
	 * @param rental object that contains customerid, insurnace
	 * @param car contains carid, mileage
	 * @param dates contains checkout date, return date, total days
	 * @return contractNumber 
	 */
	public int rentalCheckOut(Rental rental, Car car, Dates dates){
		int insertedContractNumber = 0;
		try{
			String sql = "INSERT INTO rental" +
						 "(Customer, Car, MilesOut, MilesIn, Agency, Insurance, InsurancePrice, "
						 + "StartDate, EndDate, TotalDays, TotalPrice, RentalStatus) VALUES" +
						 "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prepStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			prepStmt.setInt(1, rental.getCustomerId());
			prepStmt.setInt(2, rental.getCarId());
			prepStmt.setInt(3, car.getMileage());
			prepStmt.setInt(4, 0);	//set milesin as 0 at checkout. this is populated in rentalcheckin
			prepStmt.setInt(5, rental.getAgencyId());
			prepStmt.setString(6, rental.getInsurance());
			prepStmt.setInt(7, rental.getInsurancePrice());
			prepStmt.setDate(8, java.sql.Date.valueOf(dates.getStartDate()));
			prepStmt.setDate(9, java.sql.Date.valueOf(dates.getEndDate()));
			prepStmt.setInt(10, dates.getTotalDays());
			prepStmt.setInt(11, rental.getTotalPrice());
			prepStmt.setString(12,  "onRent");
			
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("added new rental");
			ResultSet rs = prepStmt.getGeneratedKeys();
			if (rs.next())
				insertedContractNumber = rs.getInt(1);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return insertedContractNumber;
	}
	
	
	/**
	 * updates the rental table with milesIn information and changes status to returned
	 * @param contractNumber contract that is being modified
	 * @param milesIn updated miles from the vehicle
	 */
	public void rentalCheckIn(int contractNumber, int milesIn){
		try{
			String sql = "UPDATE rental set "+
						"MilesIn = ?, RentalStatus = ? " + 
						"WHERE ContractNumber = ?";
			PreparedStatement prepStmt = myConn.prepareStatement(sql);
			
			prepStmt.setInt(1, milesIn);
			prepStmt.setString(2, "Returned");
			prepStmt.setInt(3, contractNumber);
			
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("closed the rental");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Checks if the given reservation exists or not. If it does, returns the reservation info
	 * @param reservationId that is being checked if it exists
	 * @return the reservation object
	 */
	public Reservation searchReservation(int reservationId)
	{
		Reservation reservation = null;
		ResultSet myRs = null;
		PreparedStatement prepStmt = null;
		try {
			String sql = "select reservation.*, fname, lname "
					+ "from customer, reservation "
					+ "where reservation.Customer = customer.uid and ReservationNumber = ?";
					
			prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, reservationId);
			myRs = prepStmt.executeQuery();
			while (myRs.next()){
				int reservationNumber = myRs.getInt("ReservationNumber");
				String fName = myRs.getString("fname");
				String lName = myRs.getString("lname");
				int agencyId = myRs.getInt("Agency");
				int customerId = myRs.getInt("Customer");
				
				LocalDate startDate = myRs.getDate("StartDate").toLocalDate();
				LocalDate endDate = myRs.getDate("endDate").toLocalDate();
				int totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
				
				Dates dates = new Dates(startDate, endDate, totalDays);
				reservation = new Reservation(reservationNumber, 
											customerId, fName, lName, agencyId, dates);
			}	
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(prepStmt, myRs);
		}
		return reservation;
	}	
	
	/**
	 * Checks if the given customerId exists. If it does, returns its customer object
	 * @param customerId 
	 * @return Customer object associated with the customerId
	 */
	public Customer searchCustomer(int customerId){
		Customer customer = null;
		ResultSet myRs = null;
		PreparedStatement prepStmt = null;
		try{
			String sql = "select * from customer where uid = ?";
			prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, customerId);
			myRs = prepStmt.executeQuery();
			
			while (myRs.next()){
				int uid = myRs.getInt("uid");
				String fname = myRs.getString("fname");
				String lname = myRs.getString("lname");
				int age = myRs.getInt("age");
				String licenceNumber = myRs.getString("LicenceNumber");
				String ccNumber = myRs.getString("ccNumber");
				String status = myRs.getString("CustomerStatus");
				
				customer = new Customer(fname, lname, age, licenceNumber, ccNumber, status);
				customer.setUserID(uid);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(prepStmt, myRs);
		}
		return customer;
	}
	
	/**
	 * Checks if the customer is under 25
	 * @param uid the customer's id
	 * @return under25 boolean value checking if customer is under 25
	 */
	public boolean under25(int uid) {
		boolean under25 = false;
		try{
			String sql = "select age from customer where uid = " + uid;
			ResultSet rs = myConn.createStatement().executeQuery(sql);
			while(rs.next()) {
				int age = rs.getInt("age");
				if (age < 25)
					under25 = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return under25;
		
	}
	
	/**
	 * check if a car with given carId exists or not. 
	 * @param carId - cID from database
	 * @return car object
	 */
	public Car searchCar(int carId){
		Car car = null;
		ResultSet myRs = null;
		PreparedStatement prepStmt = null;
		try{
			String sql = "select * from car where cID = ?";
			prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, carId);
			myRs = prepStmt.executeQuery();
			
			while (myRs.next()){
				String make = myRs.getString("Make");
				String model = myRs.getString("Model");
				int year = myRs.getInt("Year");
				int mileage = myRs.getInt("Mileage");
				String condition = myRs.getString("vehicleCondition");
				String type = myRs.getString("Type");
				int price = myRs.getInt("price");
				String status = myRs.getString("CarStatus");
				
				car = new Car(carId, make, model, year, mileage, condition, type, price, status);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(prepStmt, myRs);
		}
		return car;
	}
	
	/**
	 * Searches if the given rentalId exists in rental table or not and returns the rental information
	 * @param rentalId - id being checked 
	 * @return Rental object information
	 */
	public Rental searchRental(int rentalId){
		Rental rental = null;
		PreparedStatement prepStmt = null;
		ResultSet myRs = null;
		
		try{
			String sql = "SELECT fname, lname, year, make, model, uid, cID, rental.* "
					+ "from customer, car, rental "
					+ "where rental.Customer = customer.uid and rental.Car=car.cID and ContractNumber=?";
			prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, rentalId);
			myRs = prepStmt.executeQuery();
			while (myRs.next()){
				int contractNumber = myRs.getInt("ContractNumber");
				int uid = myRs.getInt("uid");
				int cID = myRs.getInt("cID");
				int insPrice = myRs.getInt("InsurancePrice");
				String insurance = myRs.getString("insurance");
				String fName = myRs.getString("fname");
				String lName = myRs.getString("lname");
				int year = myRs.getInt("year");
				String make = myRs.getString("make");
				String model = myRs.getString("model");
				int milesOut = myRs.getInt("MilesOut");
				int milesIn = myRs.getInt("MilesIn");
				int agencyId = myRs.getInt("Agency");
				LocalDate startDate = myRs.getDate("StartDate").toLocalDate();
				LocalDate endDate = myRs.getDate("EndDate").toLocalDate();
				int totalDays = myRs.getInt("TotalDays");
				int totalPrice = myRs.getInt("TotalPrice");
				String status = myRs.getString("rentalStatus");
				rental = new Rental(contractNumber, uid, cID, insurance, insPrice, year, milesOut, milesIn, agencyId, totalDays, totalPrice, fName, lName, status, make, model, startDate, endDate);
				//rental = new Rental(contractNumber, totalPrice, null, totalPrice, status, totalPrice, null, totalPrice, status)
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		finally {
			close(prepStmt, myRs);
		}
		return rental;
	}
	
	/**
	 * Gets an old customerId and updates that information to a newCostumer object
	 * @param customerId - existing customer's customerId
	 * @param newCostumer - new customer's customer object
	 */
	public void updateCustomer(int customerId, Customer newCostumer){
		Customer oldCustomer = searchCustomer(customerId);		//verify the customerId exists
		if (oldCustomer != null){
			try{
				String sql = "UPDATE CUSTOMER SET fname=?, lname=?, age=?, LicenceNumber=?, ccNumber=? where uid=?";
				PreparedStatement prepStmt = myConn.prepareStatement(sql);
				prepStmt.setString(1, newCostumer.getFname());
				prepStmt.setString(2, newCostumer.getLname());
				prepStmt.setInt(3, newCostumer.getAge());
				prepStmt.setString(4, newCostumer.getLicenceNumber());
				prepStmt.setString(5, newCostumer.getCcNumber());
				prepStmt.setInt(6, customerId);
			
				int count = prepStmt.executeUpdate();
				if (count != 0)
					System.out.println("updated with new person");
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		} else
			System.out.printf("CustomerID %d doesnt exist", customerId);
	}
	
	
	/**
	 * Gets old carId and updates that row with newCar object
	 * @param carId - for old car
	 * @param newCar - object containing new car's values
	 */
	public void updateCar(int carId, Car newCar){
		Car oldCar = searchCar(carId);
		if (oldCar != null){			
			try{
				String sql = "UPDATE CAR SET make=?, model=?, year=?, mileage=?, "
						+ "vehicleCondition=?, type=?, price=?, CarStatus=? where cID=?";
				PreparedStatement prepStmt = myConn.prepareStatement(sql);
				prepStmt.setString(1, newCar.getMake());
				prepStmt.setString(2, newCar.getModel());
				prepStmt.setInt(3, newCar.getYear());
				prepStmt.setInt(4, newCar.getMileage());
				prepStmt.setString(5, newCar.getCondition());
				prepStmt.setString(6, newCar.getType());
				prepStmt.setInt(7, newCar.getPrice());
				prepStmt.setString(8, newCar.getStatus());
				prepStmt.setInt(9, carId);
			
				int count = prepStmt.executeUpdate();
				if (count != 0)
					System.out.println("updated with new car");
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * update existing rental information with newRental information
	 * @param rentalId - existing rentalId
	 * @param newRental - Rental object with updated information
	 */
	public void updateRental(int rentalId, Rental newRental, Car newCar, Dates newDates){
		//Rental oldRental = searchRental(rentalId);
		
		try{
			String sql = "UPDATE RENTAL SET "
					+ "customer=?,car=?,milesOut=?, MilesIn=?, Agency=?, Insurance=?, InsurancePrice=?, "
					+ "StartDate=?, EndDate=?, TotalDays=?, TotalPrice=?, RentalStatus=? where ContractNumber=?";
			PreparedStatement prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, newRental.getCustomerId());
			prepStmt.setInt(2, newRental.getCarId());
			prepStmt.setInt(3, newCar.getMileage());
			prepStmt.setInt(4, 0);	//set milesin as 0 at checkout. this is populated in rentalcheckin
			prepStmt.setInt(5, newRental.getAgencyId());
			prepStmt.setString(6, newRental.getInsurance());
			prepStmt.setInt(7, newRental.getInsurancePrice());
			prepStmt.setDate(8, java.sql.Date.valueOf(newDates.getStartDate()));
			prepStmt.setDate(9, java.sql.Date.valueOf(newDates.getEndDate()));
			prepStmt.setInt(10, newDates.getTotalDays());
			prepStmt.setInt(11, newRental.getTotalPrice());
			prepStmt.setString(12,  "onRent");
			prepStmt.setInt(13, rentalId);
			
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("updated with new rental");
			
		} catch (SQLException e){
			e.printStackTrace();
		}

		
	}
	
	/**
	 * update existing agency information.
	 * @param aID the agency's id
	 * @param address the street of the agency
	 * @param city the city of the agency
	 * @param zip the zip code of the agency
	 */
	public void updateAgency(int aID, String address, String city, int zip){
		try{
			String sql = "UPDATE agency SET Address=?, City=?, Zip=? WHERE aID=?";
			
			PreparedStatement pS = myConn.prepareStatement(sql);
			pS.setString(1, address);
			pS.setString(2,  city);
			pS.setInt(3, zip);
			pS.setInt(4, aID);
			int count = pS.executeUpdate();
			if (count != 0)
				System.out.println("updated with new agency information.");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Update existing reservation with newReservation object
	 * @param reservationId - existing reservationId
	 * @param newReservation - Reservation object with updated information
	 */
	public void updateReservation(int reservationId, Reservation newReservation){
		Reservation oldReservation = searchReservation(reservationId);
		if (oldReservation != null){
			int customerId = newReservation.getCustomerId();
			int agencyId = newReservation.getAgencyId();
			LocalDate startDate = newReservation.getStartDate();
			LocalDate endDate = newReservation.getEndDate();
			int totalDays = newReservation.getTotalDays();
			try{
				String sql = "UPDATE RESERVATION SET "
						+ "customer=?, agency=?, startDate=?, endDate=?, TotalDays=? WHERE ReservationNumber=?"; 
				PreparedStatement prepStmt = myConn.prepareStatement(sql);
				prepStmt.setInt(1, customerId);
				prepStmt.setInt(2, agencyId);
				prepStmt.setDate(3, java.sql.Date.valueOf(startDate));
				prepStmt.setDate(4, java.sql.Date.valueOf(endDate));
				prepStmt.setInt(5, totalDays);
				prepStmt.setInt(6, reservationId);
				
				int count = prepStmt.executeUpdate();
				if (count != 0)
					System.out.println("updated with new reservation");
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		

	}
	/**
	 * Deletes the reservation from the reservation table
	 * @param reservationNumber The reservation id to be deleted.
	 */
	public void cancelReservation(int reservationNumber) {
		try {
			String sql = "DELETE FROM reservation WHERE ReservationNumber =?";
			PreparedStatement prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, reservationNumber);
			
			int count = prepStmt.executeUpdate();
			if (count != 0)
				System.out.println("Reservation cancelled");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
