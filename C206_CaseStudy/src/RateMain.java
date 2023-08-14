/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: phoen
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Monday 14-08-2023 16:32
 */

/**
 * @author phoen
 *
 */
import java.util.ArrayList;

public class RateMain{

	private static final int OPTION_QUIT = 1;

	public static void main(String[] args) {
		// Put all variables and arrayLists below here

		// User Class
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(101, "User1", "1234", "Admin", 12345678));
		userList.add(new User(102, "User2", "1234", "Moderator", 23456789));
		userList.add(new User(103, "User3", "1234", "Helper", 34567890));


		// Currency exchange management
		ArrayList<Rate> rateList = new ArrayList<Rate>();
		rateList.add(new Rate("Singapore Dollar", "SGD", 3.1));
		rateList.add(new Rate("Australian Dollar", "AUS", 2.1));
		rateList.add(new Rate("Ringgit", "RM", 2.1));

		// ================================= Main Program
		// =====================================================

		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_QUIT) {
				// User Management
				userManagement(rateList);

			} else if (option == 2) {
				// Currency Management

			} else if (option == 3) {
				// Transaction Processing

			} else if (option == 4) {
				// Account Management

			} else if (option == 5) {
				// Rate Management
				rateManagement(rateList);

			} else if (option == 6) {
				// Feedback Management

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

	// ================================ Create Management system below
	// ==============================================

	// User Management
	public static void userManagement(ArrayList<Rate> RateList) {
		rateMenu();
		int option = 0;
		option = Helper.readInt("Enter an option > ");

		while (option != 4) {
			if (option == 1) {
				String rate = inputDeleteRate();

				C206_CaseStudy.addRate(RateList);
				System.out.println("rate added");

				rateMenu();
				option = Helper.readInt("Enter an option > ");

			} else if (option == 2) {
				viewRate(RateList);

				rateMenu();
				option = Helper.readInt("Enter an option > ");

			} else if (option == 3) {
				String deleteRate = inputDeleteRate();
				delRate( RateList, deleteRate);

				rateMenu();
				option = Helper.readInt("Enter an option > ");

			} else if (option == 4) {
				System.out.println("Thank you for using the User Management System!");

			} else {
				System.out.println("Invalid Option");
			}
		}

	}

	public static void rateManagement(ArrayList<Rate> rateList) {
		rateMenu();
		int option = 0;
		option = Helper.readInt("Enter an option > ");

		while (option != 4) {
			if (option == 1) {
				String rate = inputDeleteRate();
				addRate(rateList);
				System.out.println("Rate added");

				rateMenu();
				option = Helper.readInt("Enter an option > ");
			} else if (option == 2) {
				viewRate(rateList);

				rateMenu();
				option = Helper.readInt("Enter an option > ");
			} else if (option == 3) {
				String deleteRate = inputDeleteRate();
				delRate( rateList, deleteRate);

				rateMenu();
				option = Helper.readInt("Enter an option > ");
			} else if (option == 4) {
				System.out.println("Thank you for using the Rate Management System!");
			} else {
				System.out.println("Invalid Option");
			}
		}
	}

	/**
	 * @return
	 */
	public static String inputDeleteRate() {
		String deleteRate=Helper.readString("Unique Currency Code To Delete: ");
		return deleteRate;
	}

	public static void rateMenu() {
		C206_CaseStudy.setHeader("Rate Management System");

		System.out.println("1. Add new Rate");
		System.out.println("2. View all Rates");
		System.out.println("3. Delete Rate");
		System.out.println("4. Back to Main Menu");

		Helper.line(80, "-");
	}

	// View Rate
	public static void viewRate(ArrayList<Rate> rateList) {
		System.out.println(String.format("%-10s %-15s %-15s", "Currency Name", "Unique Currency Code", "Exchange Rate"));
		for (Rate rate : rateList) {
			System.out.println(String.format("%-10s %-15s %-15.2f", rate.getCurrencyName(),
					rate.getUniqueCurrencyCode(), rate.getExchangeRate()));
		}
	}

	public static void addRate(ArrayList<Rate> rateList) {
		String currencyName = Helper.readString("Enter Currency Name >");
		String currCode = Helper.readString("Enter currency code: ");
		double rateEx = Helper.readDouble("Enter exchange rate: ");
		Rate rate = new Rate(currencyName, currCode, rateEx);
		rateList.add(rate);
	}

	public static void delRate(ArrayList<Rate> rateList, String uniqueCurrencyCode) {
		Rate rateToRemove = null;
		for (Rate rate : rateList) {
			if (rate.getUniqueCurrencyCode().equals(uniqueCurrencyCode)) {
				rateToRemove = rate;
				break;
			}
		}
		if (rateToRemove != null) {
			rateList.remove(rateToRemove);
		} else {
			System.out.println("Rate with unique currency code " + uniqueCurrencyCode + " not found.");
		}
	}



}
