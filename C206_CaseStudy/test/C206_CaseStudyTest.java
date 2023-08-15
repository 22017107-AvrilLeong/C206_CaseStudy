import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User user111;
	private User user211;
	private Feedback fb1;
	private Feedback fb2;

	private ArrayList<User> userList;
	private ArrayList<Feedback> feedbackList;


	@Before
	public void setUp() throws Exception {
		//User Setups
		user111 = new User(101, "User111", "1234", "Admin", 12345678);
		user211 = new User(102, "User211", "1234", "Moderator", 234567889);

		userList = new  ArrayList<User>();

		// Feedback Setups
		fb1 = new Feedback("User111", "The service is streamline!", 8, "23/06/2023", "User111@gmail.com", 111);
		fb2 = new Feedback("User211", "The system need some improvement", 5, "12/08/2023", "User211@gmail.com", 211);

		feedbackList = new ArrayList<Feedback>();



	}    

	@Test
	public void testAddUser() {
		// User list is not null and it is empty
		assertNotNull("Test if there is valid userList to add to", userList);
		assertEquals("Test that the userList is empty.", 0, userList.size());

		//Given an empty list, after adding 1 User, the size of the list is 1
		C206_CaseStudy.addUser(userList, user111);		
		assertEquals("Test that the userList size is 1.", 1, userList.size());


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
	public void testAddFeedback() {
		// User list is not null and it is empty
		assertNotNull("Test if there is valid feedbackList to add to", feedbackList);
		assertEquals("Test that the feedbackList is empty.", 0, feedbackList.size());

		//Given an empty list, after adding 1 Feedback, the size of the list is 1
		C206_CaseStudy.addfeedback(feedbackList, fb1);		
		assertEquals("Test that the feedbackList size is 1.", 1, feedbackList.size());

		// Add an item
		C206_CaseStudy.addfeedback(feedbackList, fb2);
		assertEquals("Test that the feedbackList size is now 2.", 2, feedbackList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that feedback is added to the end of the list.", fb2, feedbackList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addfeedback(feedbackList, fb2);
		assertEquals("Test that the feedbackList size is unchanged.", 2, feedbackList.size());
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
		testOutput += String.format("%-10s %-15s %-15s %-20d\n",102, "User211", "Moderator", 234567889);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, retrieveUser);

		// Error condition: Incomplete User View
		User incompleteUser = new User(104, "", "", "", 12341234);

		C206_CaseStudy.addUser(userList, incompleteUser);

		assertEquals("Test that Chromebook arraylist size is 2.", 2, userList.size());

		// Attempt to retrieve the Users again
		retrieveUser= C206_CaseStudy.retrieveUser(userList);
		// Test that the output is still correct after errors
		assertEquals("Test that the display is correct", testOutput, retrieveUser);

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


	@After
	public void tearDown() throws Exception {
		//User Teardown
		user111 = null;
		user211 = null;
		userList = null;

		//Feedback Teardown
		fb1 = null;
		fb2 = null;
		feedbackList = null;
	}
}
