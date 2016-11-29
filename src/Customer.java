
public class Customer {
	
	private int customerId;
	private String fname;
	private String lname;
	private int age;
	private String licenceNumber;
	private String ccNumber; //String or long?
	private Car rentedCar;
	private String status;
	
	public Customer(int customerId, String fname, String lname, int age, String licenceNumber, String ccNumber,
			Car rentedCar, String status) {
		super();
		this.customerId = customerId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.licenceNumber = licenceNumber;
		this.ccNumber = ccNumber;
		this.rentedCar = rentedCar;
		this.status = status;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setUserID(int userID) {
		this.customerId = userID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public Car getRentedCar() {
		return rentedCar;
	}
	public void setRentedCar(Car rentedCar) {
		this.rentedCar = rentedCar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
