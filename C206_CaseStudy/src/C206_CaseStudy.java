import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 1;

	public static void main(String[] args) {
		//put all variables and arrayLists below here

		//User Class
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(101, "User1", "1234", "Admin", 12345678));
		userList.add(new User(102, "User2", "1234", "Moderator", 23456789));
		userList.add(new User(103, "User3", "1234", "Helper", 34567890));
		
		// Feedback Class
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		feedbackList.add(new Feedback("User111", "The service is streamline!", 8, "23/06/2023", "User111@gmail.com", (111)));
		feedbackList.add(new Feedback("User211","The system need some improvement", 5, "12/08/2023", "User211@gmail.com", 211));

		//================================= Main Program  =====================================================

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_QUIT) {
				// User Management
				userManagement(userList);

			} else if (option == 2) {
				// Currency Management


			} else if (option == 3) {
				// Transaction Processing


			} else if (option == 4) {
				// Account Management


			} else if (option == 5) {
				//Rate Management


			} else if (option == 6) {
				//Feedback Management
				feedbackManagement(feedbackList);

			} else if (option == 7) {
				System.out.println("Bye!");


			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("Money Exchange Management System");
		System.out.println("1. User Management");
		System.out.println("2. Currency Management");
		System.out.println("3. Transaction Processing");
		System.out.println("4. Account Management");
		System.out.println("5. Rate Management");
		System.out.println("6. Feedback Management");
		System.out.println("7. Exit System");



		Helper.line(80, "-");

	}



	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//================================ Create Management system below ==============================================

	//User Management
	public static void userManagement(ArrayList<User> userList) {
		userMenu();
		int option = 0;
		option = Helper.readInt("Enter an option > ");

		while (option!= 4) {
			if (option ==1) {
				User user = inputUser();
				C206_CaseStudy.addUser(userList, user);
				System.out.println("User added");

				userMenu();
				option = Helper.readInt("Enter an option > ");

			}
			else if (option ==2) {
				viewUsers(userList);
				
				userMenu();
				option = Helper.readInt("Enter an option > ");
				
			}
			else if (option ==3) {
				int deleteUser = inputDeleteUser();
				deleteUser(userList,deleteUser);
				
				userMenu();
				option = Helper.readInt("Enter an option > ");

			}else if (option == 4) {
				System.out.println("Thank you for using the User Management System!");

			}else {
				System.out.println("Invalid Option");
			}
		}

	}
	
	public static void userMenu() {
		C206_CaseStudy.setHeader("User Management System");

		System.out.println("1. Add new User");
		System.out.println("2. View all User");
		System.out.println("3. Delete User");
		System.out.println("4. Back to Main Menu");

		Helper.line(80, "-");
	}
	
	//User Input Method
	public static User inputUser(){
		//input User Details
		int UserID = Helper.readInt("Enter UserID > ");
		String username = Helper.readString("Enter Username > ");
		String pass = Helper.readString("Enter password > ");
		String role = Helper.readString("Enter User Role > ");
		int contactInfo = Helper.readInt("Enter Contact Information > ");

		User user= new User(UserID, username, pass, role, contactInfo);
		return user;
	}
	
	//User Add Method
	public static void addUser(ArrayList<User> userList, User user) {
		User loser;
		for(User u: userList) {
			loser = u;
			if (loser.getUserID()== user.getUserID())
				return;
		}
		if ((user.getUsername().isEmpty()) || (user.getRole().isEmpty())|| (user.getPassword().isEmpty())){
			return;
		}
		userList.add(user);
	}
	
	//Retrieve User Method
	public static String retrieveUser(ArrayList<User> userList) {
		String output = "";

		for (User user : userList) {
			output += String.format("%-10s %-15s %-15s %-20d\n", user.getUserID(), user.getUsername(),
					user.getRole(), user.getContactInfo());
		}
		return output;
	}
	
	//View All Users
	public static void viewUsers(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-15s %-15s %-20s\n", "USER ID", "USERNAME",
				"ROLE", "CONTACT INFORMATION");
		output += retrieveUser(userList);	
		System.out.println(output);
	}
	
	//Delete Input Method
	public static int inputDeleteUser(){
		int deleteUser = Helper.readInt("Enter the User ID to delete >");

		return deleteUser;
	}
	
	//Delete Users
	public static void deleteUser(ArrayList<User> userList, int deleteUser) {

		boolean found = false;
		for (User user:userList) {
			if (user.getUserID() == deleteUser) {
				found = true;
				System.out.println(String.format("%-10s %-15s %-15s %-20s", "USER ID", "USERNAME",
						"ROLE", "CONTACT INFORMATION"));
				System.out.println(String.format("%-10s %-15s %-15s %-20d\n", user.getUserID(), user.getUsername(),
						user.getRole(), user.getContactInfo()));

				String confirm = Helper.readString("Confirm Deletion? (Y/N) >");

				if (confirm.equalsIgnoreCase("y")) {
					userList.remove(user);
					System.out.println("User deleted.");
				} else {
					System.out.println("Deletion Cancelled");
				}
				break;
			}
		}

		if (!found) {
			System.out.println("User ID not found");

		}
	}

	// Feedback Management
	public static void feedbackManagement(ArrayList<Feedback> feedbackList) {
		feedbackMenu();
		int option = 0;
		option = Helper.readInt("Enter an option > ");

		while (option!= 4) {
			if (option == 1) {
				Feedback feedback = inputFeedback();
				C206_CaseStudy.addfeedback(feedbackList, feedback);
				System.out.println("Feedback added");

				feedbackMenu();
				option = Helper.readInt("Enter an option > ");

			}
			else if (option == 2) {
				ViewFeedback(feedbackList);
				
				feedbackMenu();
				option = Helper.readInt("Enter an option > ");
				
			}
			else if (option == 3) {
				int delete = inputDeleteFeedback();
				deleteFeedback(feedbackList,delete);
				
				feedbackMenu();
				option = Helper.readInt("Enter an option > ");

			}else if (option == 4) {
				System.out.println("Thank you for using the Feedback Management System!");

			}else {
				System.out.println("Invalid Option");
			}
		}

	}
	
	public static void feedbackMenu() {
		C206_CaseStudy.setHeader("Feedback Management System");

		System.out.println("1. Add new Feedback");
		System.out.println("2. View all Feedback");
		System.out.println("3. Delete Feedback");
		System.out.println("4. Back to Main Menu");

		Helper.line(80, "-");
	}
	
	//Feedback Input Method
		public static Feedback inputFeedback(){
			//input Feedback Details
			String customername = Helper.readString("Enter Name > ");
			String message = Helper.readString("Enter Message > ");
			int rating = Helper.readInt("Enter Rating > ");
			String fbdate = Helper.readString("Enter Date > ");
			String email = Helper.readString("Enter email > ");
			int id = Helper.readInt("Enter ID > ");

			Feedback feedback = new Feedback(customername, message, rating, fbdate, email, id);
			return feedback;
		}
	
		//Feedback Add Method
		public static void addfeedback(ArrayList<Feedback> feedbackList, Feedback feedback) {
			int maxWordLimit = 100; // Define the maximum word limit
			Feedback good;
			for(Feedback f: feedbackList) {
				good = f;
				if (good.getCustomername().equals(feedback.getCustomername()))
					return;
			}
			if ((feedback.getMessage().isEmpty()) || (feedback.getRating() == 0)|| (feedback.getFBdate().isEmpty())){
				return;
			}
			
			if (feedback.getMessage().split("\\s+").length > maxWordLimit) {
				return;
			}
			
			if (!feedback.getEmail().equals(feedback.getEmail())) {
		        return; // Exit if the feedback email is not the same as the account email
		    }
			feedbackList.add(feedback);
		}
		
		//Retrieve Feedback Method
		public static String retrieveFeedback(ArrayList <Feedback> feedbackList) {
			String output = "";

			for (Feedback feedback : feedbackList) {
				output += String.format("%-10s %-40s %-20d %-20s %-30s %-20d\n", feedback.getCustomername(), feedback.getMessage(),
						feedback.getRating(), feedback.getFBdate(), feedback.getEmail(), feedback.getId());
			}
			return output;
		}
		
		//View All Feedbacks
		public static void ViewFeedback(ArrayList <Feedback> feedbackList) {
			C206_CaseStudy.setHeader("FEEDBACK LIST");
			String output = String.format("%-10s %-40s %-20s %-20s %-30s %-20s\n", "NAME", "MESSAGE",
					"RATING", "DATE", "EMAIL", "ID");
			output += retrieveFeedback(feedbackList);	
			System.out.println(output);
		}
		
		//Delete Input Method
		public static int inputDeleteFeedback(){
			int deleteFeedback = Helper.readInt("Enter the Feedback to delete >");

			return deleteFeedback;
		}
		
		//Delete Feedback
		public static void deleteFeedback(ArrayList <Feedback> feedbackList, int deleteFeedback) {

			boolean found = false;
			for (Feedback feedback:feedbackList) {
				if (feedback.getId() == deleteFeedback) {
					found = true;
					System.out.println(String.format("%-10s %-40s %-20s %-20s %-30s %-20s\n", "NAME", "MESSAGE",
							"RATING", "DATE", "EMAIL", "ID"));
					System.out.println(String.format("%-10s %-40s %-20s %-20s %-30s %-20s\n", feedback.getCustomername(), feedback.getMessage(),
							feedback.getRating(), feedback.getFBdate(), feedback.getEmail(), feedback.getId()));

					String confirm = Helper.readString("Confirm Deletion? (Y/N) >");

					if (confirm.equalsIgnoreCase("y")) {
						feedbackList.remove(feedback);
						System.out.println("Feedback deleted.");
					} else {
						System.out.println("Deletion Cancelled");
					}
					break;
				}
			}

			if (!found) {
				System.out.println("Customer Name not found");

			}
		}
}




