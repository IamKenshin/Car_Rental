
public class Agency {
	
	private int agencyID;
	private String address;
	private String city;
	private int zip;

	public Agency(){
		
	}
	
	public Agency(int agencyId, String address, String city, int zip){
		super();
		this.agencyID = agencyId;
		this.address = address;
		this.city = city;
		this.zip = zip;
	}
	
	public String getAddress(){
		return address;
	}

	public String getCity() {
		return city;
	}
	
	public int getZip() {
		return zip;
	}
	
	public int getAgencyID() {
		return agencyID;
	}
	
	public void setCity(String city) {
		this.city = city;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}
	
	

}
