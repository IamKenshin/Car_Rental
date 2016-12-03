import java.time.LocalDate;

public class Rental {
	
	private int contractNumber;
	private int customerId;
	private int carId;
	private int milesOut;
	private int milesIn;
	private int agencyId;
	private String insurance;
	private int insurancePrice;
	private LocalDate startDate;
	private LocalDate endDate;
	private int totalDays;
	private int totalPrice;
	private String status;
	
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
