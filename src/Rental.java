import java.time.LocalDate;

public class Rental {
	
	private int contractNumber, customerId, carId, milesOut, milesIn,
				agencyId, insurancePrice, totalDays, totalPrice, year;
	private String fName, lName, insurance, status, make, model;
	private LocalDate startDate, endDate;
	
	public Rental(int contractNumber, int customerId, Car car, int agencyId,
			String insurance,int insurancePrice, Dates dates, int totalPrice, String status) {
	super();
	this.contractNumber = contractNumber;
	this.customerId = customerId;
	this.carId = car.getCarId();
	this.milesOut = car.getMileage();
	this.agencyId = agencyId;
	this.insurance = insurance;
	if (this.insurance == "Yes"){
		this.insurancePrice = insurancePrice;
	} else if (this.insurance == "No"){
		this.insurancePrice = 0;
	}
	this.startDate = dates.getStartDate();
	this.endDate = dates.getEndDate();
	this.totalDays = dates.getTotalDays();
	this.totalPrice = totalPrice;
	this.status = status;
}
	
	//this contructor is used by searchReservation or getAllReservation where it grabs a bunch of data
	//and needs to initialize them before printing it
	public Rental(int contractNumber, int year, int milesOut, int milesIn, int agencyId, int totalDays, int totalPrice,
			String fName, String lName, String status, String make, String model, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.contractNumber = contractNumber;
		this.year = year;
		this.milesOut = milesOut;
		this.milesIn = milesIn;
		this.agencyId = agencyId;
		this.totalDays = totalDays;
		this.totalPrice = totalPrice;
		this.fName = fName;
		this.lName = lName;
		this.status = status;
		this.make = make;
		this.model = model;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Rental (Reservation reservation, Car car, Dates dates){
		//working on creating new rental based on reservation, car, dates and other fields
	
		this.customerId = reservation.getCustomerId();
		this.carId = car.getCarId();
		this.milesOut = car.getMileage();
		this.agencyId = reservation.getAgencyId();
		this.insurance = insurance;
		this.insurancePrice = insurancePrice;
		
		this.startDate = dates.getStartDate();
		this.endDate = dates.getEndDate();
		this.totalDays = dates.getTotalDays();
		this.totalPrice = totalPrice;
	}
	
	public String toString(){
		return contractNumber  + " | " + fName  + " " + lName  + " | " + year  + " " + make + " " +  model + " | " + 
				milesOut  + " - " + milesIn  + " | " + startDate + " till " +  endDate  + " | " + totalDays  + "days | $" + totalPrice 
				 + " | " + status;
	}
	public int getMilesOut() {
		return milesOut;
	}

	public void setMilesOut(int milesOut) {
		this.milesOut = milesOut;
	}

	public int getMilesIn() {
		return milesIn;
	}

	public void setMilesIn(int milesIn) {
		this.milesIn = milesIn;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	
	public int getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyID(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public int getInsurancePrice() {
		return insurancePrice;
	}
	public void setInsurancePrice(int insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
