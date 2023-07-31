public class User {
	private int userID;
	private String username;
	private String password;
	private String role;
	private int contactInfo;
	
	public User(int userID, String username, String password, String role, int contactInfo) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
		this.contactInfo = contactInfo;
	}
	
	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public int getContactInfo() {
		return contactInfo;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setContactInfo(int contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}

