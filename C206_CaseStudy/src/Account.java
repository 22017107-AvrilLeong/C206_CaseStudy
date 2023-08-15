
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * JocelynLee, 14 Aug 2023 10:09:25 am
 */

public class Account {
	private int accountID;
	private int customerID;
	private double balance;
	private boolean isActive;

	public Account(int accountID, int customerID) {
		this.accountID = accountID;
		this.customerID = customerID;
		this.balance = 0.0;
		this.isActive = true;
	}

	public int getAccountID() {
		return accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isActive() {
		return isActive;
	}

}
