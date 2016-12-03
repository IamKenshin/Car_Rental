import java.time.LocalDate;

public class Reservation {
	private int reservationNumber, customerId, agencyId, totalDays;
	private String fName, lName; 
	private LocalDate startDate, endDate;;

	
	public Reservation(int reservationNumber, int customerId, int agencyId, Dates dates) {
		super();
		this.reservationNumber = reservationNumber;
		this.customerId = customerId;
		this.agencyId = agencyId;
		this.startDate = dates.getStartDate();
		this.endDate = dates.getEndDate();
		this.totalDays = dates.getTotalDays();
	}
	
	//separate constructor with fname, lname because we need this for getallreservations 
	//while doing a join between customer and reservations table
	public Reservation(int reservationNumber, int customerId, String fName, String lName, int agencyId, Dates dates) {
		super();
		this.reservationNumber = reservationNumber;
		this.customerId = customerId;
		this.fName = fName;
		this.lName = lName;
		this.agencyId = agencyId;
		this.startDate = dates.getStartDate();
		this.endDate = dates.getEndDate();
		this.totalDays = dates.getTotalDays();
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

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	
	public int getReservationNumber() {
		return reservationNumber;
	}
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public String toString() {
		return reservationNumber + " | " + fName + " | " + lName + " | " + agencyId + " | " + startDate + " | " + endDate + " | " + totalDays; 		
	}
	
	
	
	
	

}
