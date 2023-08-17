import java.time.LocalDate;

public class Feedback {

	private String customername;
	private String message;
	private int rating;
	private String fbdate;
	private String email;
	private int id;

	public Feedback(String customername, String message, int rating, String fbdate, String email, int id) {
		this.customername = customername;
		this.message = message;
		this.rating = rating;
		this.fbdate = fbdate;
		this.email = email;
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}
	
	public void setCustomername(String Customername) {
		this.customername = customername;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String Message) {
		this.message = message;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int Rating) {
		this.rating = rating;
	}

	public String getFBdate() {
		return fbdate;
	}
	
	public void setFBdate(String FBdate) {
		this.fbdate = fbdate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String Email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}