package View_Tickets;

public class Ticket {
	private String departure;
	private String arrival;
	private String date;
	
	
	public Ticket(String departure , String arrival , String date) {
		this.departure = departure;
		this.arrival=arrival;
		this.date=date;
	}
	
	public String getdeparture() {
		return departure;
	}
	public String getarrival() {
		return arrival;
	}
	public String getdate() {
		return date;
	}
}
