package ticketmain;

public class ReservedTicket {
	private String firstname;
	private String lastname;
	private String email;
	private String departure;
	private String arrival;
	private String date;
	
	
	public ReservedTicket(String firstname , String lastname , String email ,String departure ,String arrival ,String date) {
		this.firstname = firstname;
		this.lastname=lastname;
		this.email=email;
	}
	
	public String getfirstname() {
		return firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public String getemail() {
		return email;
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
