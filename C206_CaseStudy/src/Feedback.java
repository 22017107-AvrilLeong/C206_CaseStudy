import java.util.Date;

public class Feedback {

	private String customername;
	private String message;
	private double rating;
	private Date fbdate;

	public Feedback(String customername, String message, int rating) {
		this.customername = customername;
		this.message = message;
		this.rating = rating;
		this.fbdate = new Date();
	}

	public String getCustomername() {
		return customername;
	}

	public String getMessage() {
		return message;
	}

	public double getRating() {
		return rating;
	}

	public Date getFBdate() {
		return fbdate;
	}
}
