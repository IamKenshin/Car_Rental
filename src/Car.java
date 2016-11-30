
public class Car {
	
	private int carId;
	private String make;
	private String model;
	private int year;
	private int mileage;
	private String condition;
	private String type;
	private int price;
	
	public Car(int carId, String make, String model, int year, int mileage, String condition, String type, int price) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.condition = condition;
		this.type = type;
		this.price = price;
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
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
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
	
	

}
