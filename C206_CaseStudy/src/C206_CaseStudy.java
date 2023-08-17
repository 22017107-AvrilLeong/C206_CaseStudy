import java.util.ArrayList;
import java.util.Currency;

public class C206_CaseStudy {

	private static final int ACCOUNT_OPTION_QUIT = 4;
	private static final int CURRENCY_OPTION_QUIT = 4;
	private static final int FEEDBACK_OPTION_QUIT = 4;
	private static final int OPTION_QUIT = 1;

	public static void main(String[] args) {
		// Put all variables and arrayLists below here

		// User Class
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(101, "User1", "1234", "Admin", 12345678));
		userList.add(new User(102, "User2", "1234", "Moderator", 23456789));
		userList.add(new User(103, "User3", "1234", "Helper", 34567890));
		
		//Currency Class
		ArrayList<CurrencyC> currencyList = new ArrayList<CurrencyC>();
		currencyList.add(new CurrencyC(1001,"United State Dollars", 1.36));
		currencyList.add(new CurrencyC(1002,"Great Britain Pounds", 1.87));

		//Account Class
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account(1235, 87654321));
		accountList.add(new Account(1245, 87634521));
		accountList.add(new Account(1256, 87645321));

		// Feedback Class
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		feedbackList.add(new Feedback("User111", "The service is streamline!", 8, "23/06/2023", "User111@gmail.com", (111)));
		feedbackList.add(new Feedback("User211","The system need some improvement", 5, "12/08/2023", "User211@gmail.com", 211));
		
		// ================================= Main Program =====================================================

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_QUIT) {
				// User Management
				userManagement(userList);

			} else if (option == 2) {
				// Currency Management
				currencyManagement(currencyList);

			} else if (option == 3) {
				// Transaction Processing

			} else if (option == 4) {
				// Account Management
				accountManagement(accountList);
			} else if (option == 5) {
				// Rate Management

			} else if (option == 6) {
				// Feedback Management
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

	//================================================User Management=================================
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


	//=================================Currency Management========================================
	
	public static void currencyManagement(ArrayList<CurrencyC> currencyList) {
		currencyMenu();
		int option = 0;
		option = Helper.readInt("Enter an option > ");

		while (option!= CURRENCY_OPTION_QUIT) {

			if (option ==1) {
				CurrencyC currency = inputCurrency();
				C206_CaseStudy.addCurrency(currencyList, currency);
				System.out.println("Currency added");

				currencyMenu();
				option = Helper.readInt("Enter an option > ");

			}
			else if (option ==2) {
				viewCurrencies(currencyList);

				currencyMenu();
				option = Helper.readInt("Enter an option > ");

			}
			else if (option ==3) {
				int deleteUser = inputDeleteUser();
				deleteCurrency(currencyList,deleteUser);

				currencyMenu();
				option = Helper.readInt("Enter an option > ");

			}else if (option == 4) {
				System.out.println("Thank you for using the Currency Management System!");

			}else {
				System.out.println("Invalid Option");
			}
		}

	}


	public static void currencyMenu() {
		C206_CaseStudy.setHeader("Currency Management System");

		System.out.println("1. Add new Currency");
		System.out.println("2. View all Currencies");
		System.out.println("3. Delete Currency");
		System.out.println("4. Back to Main Menu");

		Helper.line(80, "-");
	}

	//Currency Input Method
	public static CurrencyC inputCurrency(){
		//input User Details
		int currencyCode = Helper.readInt("Enter Currency Code > ");
		String currencyName = Helper.readString("Enter Currency Name > ");
		double exchangeRate = Helper.readDouble("Enter Exchange Rate > ");

		CurrencyC currency= new CurrencyC(currencyCode, currencyName, exchangeRate);
		return currency;
	}

	//Currency Add Method
	public static void addCurrency(ArrayList<CurrencyC> currencyList, CurrencyC currency) {
		CurrencyC loser;
		for(CurrencyC c: currencyList) {
			loser = c;
			if (loser.getCurrencyCode()== currency.getCurrencyCode())
				return;
		}

		
		if(currency.getCurrencyName().isEmpty()) {
			return;
		}

		currencyList.add(currency);
	}

	//Retrieve Currency Method
	public static String retrieveCurrency(ArrayList<CurrencyC> currencyList) {
		String output = "";

		for (CurrencyC currency : currencyList) {
			output += String.format("%-20s %-25s %-25.2f\n", currency.getCurrencyCode(), currency.getCurrencyName(),
					currency.getExchangeRate());
		}
		return output;
	}

	//View All Currencies
	public static void viewCurrencies(ArrayList<CurrencyC> currencyList) {
		C206_CaseStudy.setHeader("CURRENCY LIST");
		String output = String.format("%-20s %-25s %-25s\n", "CURRENCY CODE", "CURRENCY NAME",
				"EXCHANGE RATE");
		output += retrieveCurrency(currencyList);	
		System.out.println(output);
	}

	//Delete Input Method
	public static int inputDeleteCurrency(){
		int deleteCurrency = Helper.readInt("Enter the Currency Code to delete >");

		return deleteCurrency;
	}

	//Delete Currency
	public static void deleteCurrency(ArrayList<CurrencyC> currencyList, int deleteCurrencyCode) {

		boolean found = false;
		for (CurrencyC currency:currencyList) {
			if (currency.getCurrencyCode() == deleteCurrencyCode) {
				found = true;
				System.out.println(String.format("%-20s %-25s %-25s", "CURRENCY CODE", "CURRENCY NAME", "EXCHANGE RATE"));
				System.out.println(String.format("%-20d %-25s %-25.2f\n", currency.getCurrencyCode(), currency.getCurrencyName(),
						currency.getExchangeRate()));

				String confirm = Helper.readString("Confirm Deletion? (Y/N) >");

				if (confirm.equalsIgnoreCase("y")) {
					currencyList.remove(currency);
					System.out.println("Currency deleted.");
				} else {
					System.out.println("Deletion Cancelled");
				}
				break;
			}
		}

		if (!found) {
			System.out.println("Currency Code not found");

		}
	}
	
	//=================================Account Management========================================
	//AccountManagement
	public static void accountManagement(ArrayList<Account> accountList) {
		int option = 0;
		int deleteAccountID = 0;
		accountMenu();
		option = Helper.readInt("Enter an option > ");
		
		while (option != ACCOUNT_OPTION_QUIT) {

			if(option == 1) {
				Account account = inputAccount();
				C206_CaseStudy.addAccount(accountList, account);
				System.out.println("Account added");
				
				accountMenu();
				option = Helper.readInt("Enter an option > ");
			} else if (option == 2) {
	            viewAccounts(accountList);

	            accountMenu();
	            option = Helper.readInt("Enter an option > ");
			} else if (option == 3) {
				if (deleteAccountID == 0) {
					deleteAccountID = Helper.readInt("Enter Account ID to delete > ");
				}
	            deleteAccount(accountList, deleteAccountID);
	            
	            accountMenu();
	            option = Helper.readInt("Enter an option > ");
			} else if (option == 4) {
				System.out.println("Thank you for using Account Management System");
			} else {
				System.out.println("Invalid Option!");
			}
			
		}
	}
	
	//deleteAccount
	public static void deleteAccount(ArrayList<Account> accountList, int deleteAccountID) {
		// TODO Auto-generated method stub
		boolean found = false;
		for (Account account:accountList) {
			if (account.getAccountID() == deleteAccountID) {
				found = true;
			    System.out.println(String.format("%-10s %-15s %-10s %-15s\n", "ACCOUNT ID", "CUSTOMER ID", "BALANCE", "ACTIVE"));
			    
				System.out.println(String.format("%-10s %-15s %-15s %-20b\n", account.getAccountID(), account.getCustomerID(),
						account.getBalance(), account.isActive()));

				String confirm = Helper.readString("Confirm Deletion? (Y/N) >");

				if (confirm.equalsIgnoreCase("y")) {
					accountList.remove(account);
					System.out.println("Account deleted.");
				} else {
					System.out.println("Deletion Cancelled");
				}
				break;
			}
		}

		if (!found) {
			System.out.println("Account ID not found");

		}

	}


	//viewAccount
	public static void viewAccounts(ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("ACCOUNT LIST");
	    System.out.println(String.format("%-10s %-15s %-10s %-15s\n", "ACCOUNT ID", "CUSTOMER ID", "BALANCE", "ACTIVE"));
	    
	    String accountInfo = retrieveAccount(accountList);
	    System.out.println(accountInfo);

	    Helper.line(80, "-");
	}

	public static String retrieveAccount(ArrayList<Account> accountList) {
		String output = "";
		for (Account account : accountList) {
			if (account != null) {
				output += String.format("%-10d %-15d %-10.2f %-15b\n",
						account.getAccountID(), account.getCustomerID(),
						account.getBalance(), account.isActive() ? "Active" : "Inactive");
			}
		}
		return output;
	}
	
	
	public static void addAccount(ArrayList<Account> accountList, Account account) {
		// TODO Auto-generated method stub
		//check if account is null or not. 
		if (account == null || account.getAccountID() <= 0) {
			System.out.println("Invalid Account details. Account is not added!");
			return;
		}
		//check if account with same ID is in the system
		for (Account existAccount : accountList) {
			if (existAccount.getAccountID() == account.getAccountID()) {
				System.out.println("Account with same ID already exists. Account is not added!");
				return;
			}
		}
		accountList.add(account);
	}

	public static Account inputAccount() {
		// TODO Auto-generated method stub
		int accountID = Helper.readInt("Enter Account ID > ");
		int customerID = Helper.readInt("Enter Customer ID > ");
		Account account = new Account(accountID, customerID);
		return account;
	}

	public static void accountMenu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("Account Management System");
		
		System.out.println("1. Add new Account");
		System.out.println("2. View All Accounts");
		System.out.println("3. Delete Account");
		System.out.println("4. Back to Main Menu");
		
		Helper.line(80, "-");
	}

	
	
	//===========================Feedback Management ======================
	public static void feedbackManagement(ArrayList<Feedback> feedbackList) {
		feedbackMenu();
		int option = 0;
		option = Helper.readInt("Enter an option > ");

		while (option!= FEEDBACK_OPTION_QUIT) {
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

