import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;


public class C206_CaseStudyTest {

	private User user111;
	private User user211;
	private CurrencyC curr1;
	private CurrencyC curr2;

	private Feedback fb1;
	private Feedback fb2;

	private ArrayList<User> userList;
	private ArrayList<Feedback> feedbackList;
	private ArrayList<CurrencyC> currencyList;

	@Before
	public void setUp() throws Exception {
		// User Setups
		user111 = new User(101, "User111", "1234", "Admin", 12345678);
		user211 = new User(102, "User211", "1234", "Moderator", 34567889);
		userList = new ArrayList<User>();

		// Currency Setups
		curr1 = new CurrencyC(1001, "United State Dollars", 1.36);
		curr2 = new CurrencyC(1002, "Great Britain Pounds", 1.87);
		currencyList = new ArrayList<CurrencyC>();

		// Feedback Setups
		fb1 = new Feedback("User111", "The service is streamline!", 8, "23/06/2023", "User111@gmail.com", 111);
		fb2 = new Feedback("User211", "The system need some improvement", 5, "12/08/2023", "User211@gmail.com", 211);
		feedbackList = new ArrayList<Feedback>();



	}    

	//========== USER TEST CASE ================

	@Test
	public void testAddUser() {
		// User list is not null and it is empty
		assertNotNull("Test if there is valid userList to add to", userList);
		assertEquals("Test that the userList is empty.", 0, userList.size());

		//Given an empty list, after adding 1 User, the size of the list is 1
		C206_CaseStudy.addUser(userList, user111);
		assertEquals("Test that the userList size is 1.", 1, userList.size());


		//Test that User Added is the same
		assertEquals("User object should be the same as expected.", user111, userList.get(0));


		// Add an item
		C206_CaseStudy.addUser(userList, user211);
		assertEquals("Test that the userList size is now 2.", 2, userList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that user is added to the end of the list.", user211, userList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addUser(userList, user211);
		assertEquals("Test that the userList size is unchanged.", 2, userList.size());

		// Add an item that has missing detail
		User user_missing = new User(999, "User199", "", "Admin", 99999999);
		C206_CaseStudy.addUser(userList, user_missing);
		assertEquals("Test that the userList size is unchanged.", 2, userList.size());
	}


	@Test

	public void testViewUser() {

		//Normal Condition: View Empty List
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid userList to add to", userList);
		assertEquals("Test that the userList is empty.", 0, userList.size());

		// Attempt to retrieve the Users 
		String retrieveUser= C206_CaseStudy.retrieveUser(userList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, retrieveUser);

		//Boundary Condition: Add Users to List & View
		C206_CaseStudy.addUser(userList, user111);
		C206_CaseStudy.addUser(userList, user211);
		// Test that the list is not empty
		assertEquals("Test that Camcorder arraylist size is 2.", 2, userList.size());

		// Attempt to retrieve the Users 
		retrieveUser= C206_CaseStudy.retrieveUser(userList);

		testOutput = String.format("%-10s %-15s %-15s %-20d\n", 101, "User111", "Admin", 12345678);
		testOutput += String.format("%-10s %-15s %-15s %-20d\n",102, "User211", "Moderator", 34567889);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, retrieveUser);

		// Error condition: Incomplete User View
		User incompleteUser = new User(104, "", "", "", 12341234);

		C206_CaseStudy.addUser(userList, incompleteUser);

		assertEquals("Test that userList size is 2.", 2, userList.size());

		// Attempt to retrieve the Users again
		retrieveUser= C206_CaseStudy.retrieveUser(userList);
		// Test that the output is still correct after errors
		assertEquals("Test that the display is correct", testOutput, retrieveUser);

	}

	@Test

	public void testDeleteUser() {
		C206_CaseStudy.addUser(userList, user111);
		C206_CaseStudy.addUser(userList, user211);

		// Normal condition: Delete existing user
		C206_CaseStudy.deleteUser(userList, user111.getUserID());
		assertEquals("Test that the user1 is removed from the list.", 1, userList.size());

		// Boundary condition: Delete until List is empty
		C206_CaseStudy.deleteUser(userList, user211.getUserID());
		assertEquals("Test that the list is empty.", 0, userList.size());

		C206_CaseStudy.addUser(userList, user111);

		// Error condition: Attempt to delete with negative user ID
		C206_CaseStudy.deleteUser(userList, 103);
		assertEquals("Test that the list size remains the same.", 1, userList.size());
	}

	//================ FEEDBACK TEST CASE ==================

	@Test

	public void testAddFeedback() {
		// Feedback list is not null and it is empty
		assertNotNull("Test if there is valid feedbackList to add to", feedbackList);
		assertEquals("Test that the feedbackList is empty.", 0, feedbackList.size());

		//Given an empty list, after adding 1 Feedback, the size of the list is 1
		C206_CaseStudy.addfeedback(feedbackList, fb1);		
		assertEquals("Test that the feedbackList size is 1.", 1, feedbackList.size());

		// Add an feedback
		C206_CaseStudy.addfeedback(feedbackList, fb2);
		assertEquals("Test that the feedbackList size is now 2.", 2, feedbackList.size());
		//The feedback just added is as same as the last feedback in the list
		assertSame("Test that feedback is added to the end of the list.", fb2, feedbackList.get(1));

		// Add an feedback that already exists in the list
		C206_CaseStudy.addfeedback(feedbackList, fb2);
		assertEquals("Test that the feedbackList size is unchanged.", 2, feedbackList.size());
	}

	@Test

	public void testViewFeedback() {

		//Normal Condition: View Empty List
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid feedbackList to add to", feedbackList);
		assertEquals("Test that the feedbackList is empty.", 0, feedbackList.size());

		// Attempt to retrieve the Feedback 
		String retrieveFeedback = C206_CaseStudy.retrieveFeedback(feedbackList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing displayed", testOutput, retrieveFeedback);

		//Boundary Condition: Add Feedback to List & View
		C206_CaseStudy.addfeedback(feedbackList, fb1);
		C206_CaseStudy.addfeedback(feedbackList, fb2);
		// Test that the list is not empty
		assertEquals("Test that Feedback arraylist size is 2.", 2, feedbackList.size());

		// Attempt to retrieve the Feedback 
		retrieveFeedback = C206_CaseStudy.retrieveFeedback(feedbackList);

		testOutput = String.format("%-10s %-40s %-20d %-20s %-30s %-20d\n", "User111", "The service is streamline!", 8, "23/06/2023", "User111@gmail.com", (111));
		testOutput += String.format("%-10s %-40s %-20d %-20s %-30s %-20d\n", "User211","The system need some improvement", 5, "12/08/2023", "User211@gmail.com", 211);
		// Test that the details are displayed correctly
		assertEquals("Test that the detail display is correct.", testOutput, retrieveFeedback);

		// Error condition: Incomplete Feedback View
		Feedback incompleteFeedback = new Feedback("The system is too slow", "", 3, "", "", 311);

		C206_CaseStudy.addfeedback(feedbackList, incompleteFeedback);

		assertEquals("Test that Feedback arraylist size is 2.", 2, feedbackList.size());

		// Attempt to retrieve the Feedback again
		retrieveFeedback = C206_CaseStudy.retrieveFeedback(feedbackList);
		// Test that the output is still correct after errors
		assertEquals("Test that the display is correct", testOutput, retrieveFeedback);
	}

	@Test
	public void testDeleteFeedback() {
		C206_CaseStudy.addfeedback(feedbackList, fb1);
		C206_CaseStudy.addfeedback(feedbackList, fb2);

		// Normal condition: Delete existing feedback
		C206_CaseStudy.deleteFeedback(feedbackList, fb1.getId());
		assertEquals("Test that the fb1 is removed from the list.", 1, feedbackList.size());

		// Boundary condition: Delete until List is empty
		C206_CaseStudy.deleteFeedback(feedbackList, fb2.getId());
		assertEquals("Test that the list is empty.", 0, feedbackList.size());

		C206_CaseStudy.addfeedback(feedbackList, fb1);

		// Error condition: Attempt to delete null in the feedback id
		C206_CaseStudy.deleteFeedback(feedbackList, 0);
		assertEquals("Test that the list size remains the same.", 1, feedbackList.size());

	}

	//================= CURRENCT TEST CASE ======================

	@Test
	public void testAddCurrency() {
		// Currency list is not null and it is empty
		assertNotNull("Test if there is valid currentList to add to", currencyList);
		assertEquals("Test that the currencyList is empty.", 0, currencyList.size());

		//Given an empty list, after adding 1 Currency, the size of the list is 1
		C206_CaseStudy.addCurrency(currencyList, curr1);
		assertEquals("Test that the currencyList size is 1.", 1, currencyList.size());


		// Add an item
		C206_CaseStudy.addCurrency(currencyList, curr2);
		assertEquals("Test that the currencyList size is now 2.", 2, currencyList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that currency is added to the end of the list.", curr2, currencyList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addCurrency(currencyList, curr2);
		assertEquals("Test that the currencyList size is unchanged.", 2, currencyList.size());

		// Add an item that has missing detail
		CurrencyC currency_missing = new CurrencyC(999, "", 99999999);
		C206_CaseStudy.addCurrency(currencyList, currency_missing);
		assertEquals("Test that the currencyList size is unchanged.", 2, currencyList.size());
	}

	@Test
	public void testViewCurrency() {

		//Normal Condition: View Empty List
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid currencyList to add to", currencyList);
		assertEquals("Test that the currencyList is empty.", 0, currencyList.size());

		// Attempt to retrieve the Users 
		String retrieveCurrencyC= C206_CaseStudy.retrieveCurrency(currencyList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, retrieveCurrencyC);

		//Boundary Condition: Add Currencies to List & View
		C206_CaseStudy.addCurrency(currencyList, curr1);
		C206_CaseStudy.addCurrency(currencyList, curr2);
		// Test that the list is not empty
		assertEquals("Test that Camcorder arraylist size is 2.", 2, currencyList.size());

		// Attempt to retrieve the Currencies
		retrieveCurrencyC= C206_CaseStudy.retrieveCurrency(currencyList);

		testOutput = String.format("%-20d %-25s %-25.2f\n",1001, "United State Dollars", 1.36);
		testOutput += String.format("%-20d %-25s %-25.2f\n",1002, "Great Britain Pounds", 1.87);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, retrieveCurrencyC);

		// Error condition: Incomplete Currency View
		CurrencyC incompleteCurrency = new CurrencyC(1004, "", 1.5 );

		C206_CaseStudy.addCurrency(currencyList, incompleteCurrency);

		assertEquals("Test that Currency arraylist size is 2.", 2, currencyList.size());

		// Attempt to retrieve the Currencies again
		retrieveCurrencyC= C206_CaseStudy.retrieveCurrency(currencyList);
		// Test that the output is still correct after errors
		assertEquals("Test that the display is correct", testOutput, retrieveCurrencyC);

	}

	@Test
	public void testDeleteCurrency() {
		C206_CaseStudy.addCurrency(currencyList, curr1);
		C206_CaseStudy.addCurrency(currencyList, curr2);

		// Normal condition: Delete existing user
		C206_CaseStudy.deleteCurrency(currencyList, curr1.getCurrencyCode());
		assertEquals("Test that the currency1 is removed from the list.", 1, currencyList.size());

		// Boundary condition: Delete until List is empty
		C206_CaseStudy.deleteCurrency(currencyList, curr2.getCurrencyCode());
		assertEquals("Test that the list is empty.", 0, currencyList.size());

		C206_CaseStudy.addCurrency(currencyList, curr1);

		// Error condition: Attempt to delete with negative user ID
		C206_CaseStudy.deleteCurrency(currencyList, -1000);
		assertEquals("Test that the list size remains the same.", 1, currencyList.size());
	}


	@After
	public void tearDown() throws Exception {
		//User Teardown
		user111 = null;
		user211 = null;
		userList = null;

		//Currency Teardown
		curr1 = null;
		curr2 = null;
		currencyList = null;

		//Feedback Teardown
		fb1 = null;
		fb2 = null;
		feedbackList = null;

	}
}
