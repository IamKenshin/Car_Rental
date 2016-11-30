
public class Reservation {
	private int reservationNumber;
	private int customerId;
	private int agencyId;
	
	public Reservation(int reservationNumber, int customerId, int agencyId) {
		super();
		this.reservationNumber = reservationNumber;
		this.customerId = customerId;
		this.agencyId = agencyId;
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
	
	

}
