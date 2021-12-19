package userenter;

public class FinalTicket {

	private String firstname;
	private String lastname;
	private String email;
	private String departure;
	private String arrival;
	private String date;
	private String type ;
	
	public FinalTicket(String firstname,String lastname,String email,String departure,String arrival,String date,String type) {
		
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.departure=departure;
		this.arrival=arrival;
		this.date=date;
		this.type=type;
		
		
		
	}

	public String getFirstname() {
		return firstname;
	}

	

	public String getLastname() {
		return lastname;
	}

	

	public String getEmail() {
		return email;
	}

	

	public String getDeparture() {
		return departure;
	}

	

	public String getArrival() {
		return arrival;
	}

	
	public String getDate() {
		return date;
	}

	

	public String getType() {
		return type;
	}

	
}
