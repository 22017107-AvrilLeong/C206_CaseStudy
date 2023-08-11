
public class C206_CaseStudy {

	public static void main(String[] args) {


//================================= Main Program  =====================================================
		
		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// User Management

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
		

		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	// Feedback Management
	
}


