package entity;

public class User {
	private String username;
	private String displayName;
	private int customerID;
	private int staffID;

	public User() {
		super();
	}

	public User(String username, String displayName, int customerID, int staffID) {
		super();
		this.username = username;
		this.displayName = displayName;
		this.customerID = customerID;
		this.staffID = staffID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", displayName=" + displayName + ", customerID=" + customerID
				+ ", staffID=" + staffID + "]";
	}
}
