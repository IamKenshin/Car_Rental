import java.time.LocalDate;

public class Dates {
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int totalDays;
	
	public Dates(LocalDate startDate, LocalDate endDate, int totalDays) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalDays = totalDays;
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


}
