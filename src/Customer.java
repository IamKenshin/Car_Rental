
public class Customer {
	
	private int customerId, year, age;
	private String fName, lName, licenceNumber, ccNumber, make, model, customerStatus;
	
	public Customer(String fName, String lName, int age, String licenceNumber, String ccNumber, String status) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.licenceNumber = licenceNumber;
		this.ccNumber = ccNumber;
		this.customerStatus = status;
	}


	public Customer(String make, String model, int year, String fName, String lName, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.make = make;
		this.model = model;
		this.year = year;
		
		// TODO Auto-generated constructor stub
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setUserID(int userID) {
		this.customerId = userID;
	}
	public String getFname() {
		return fName;
	}
	public void setFname(String fName) {
		this.fName = fName;
	}
	public String getLname() {
		return lName;
	}
	public void setLname(String lName) {
		this.lName = lName;
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
	public String getStatus() {
		return customerStatus;
	}
	public void setStatus(String status) {
		this.customerStatus = status;
	}
	public String toString(){
		return customerId  + " | " + fName  + " | " + lName  + " | " + age  + " | " + licenceNumber  + " | " +
							ccNumber  + " | " + customerStatus;
	}
	
	

}
