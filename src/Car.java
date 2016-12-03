
public class Car {
	
	private int carId, year, mileage, price;
	private String make, model, vehicleCondition, type, carStatus;
	
	public Car(int carId, String make, String model, int year, int mileage, String vehicleCondition, String type, int price, String carStatus) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.vehicleCondition = vehicleCondition;
		this.type = type;
		this.price = price;
		this.carStatus = carStatus;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getCondition() {
		return vehicleCondition;
	}
	public void setCondition(String vehicleCondition) {
		this.vehicleCondition = vehicleCondition;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus(){
		return carStatus;
	}
	public void setStatus(String carStatus){
		this.carStatus = carStatus;
	}
	@Override
	public String toString() {
		return carId + " | " + make + " | " + model + " | " + year + " | " + mileage + " | " + vehicleCondition 
				+ " | " + type + " | " + price + " | " + carStatus;
		
	}
	
	

}
