import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User user111;
	private User user211;
	
	private ArrayList<User> userList;


	@Before
	public void setUp() throws Exception {
		//User Setups
		user111 = new User(101, "User111", "1234", "Admin", 12345678);
		user211 = new User(102, "User211", "1234", "Moderator", 234567889);
		
		userList = new  ArrayList<User>();
		
	
		
	}    
	
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
    
	
	@After
	public void tearDown() throws Exception {
		//User Teardown
		user111 = null;
		user211 = null;
		userList = null;
	}
}
