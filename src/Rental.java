
public class Rental {
	
	private int contractNumber;
	private int customerId;
	private int carId;
	private int agencyId;
	private String insurance;
	private int insurancePrice;
	private int totalPrice;
	
	public Rental(int contractNumber, int customerId, int carId, int agencyId, String insurance,
			int insurancePrice, int totalPrice) {
		super();
		this.contractNumber = contractNumber;
		this.customerId = customerId;
		this.carId = carId;
		this.agencyId = agencyId;
		this.insurance = insurance;
		this.insurancePrice = insurancePrice;
		this.totalPrice = totalPrice;
	}
	
	public int getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(int contractNumber) {
		this.contractNumber = contractNumber;
	}
	public int getcustomerId() {
		return customerId;
	}
	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getcarId() {
		return carId;
	}
	public void setcarId(int carId) {
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
