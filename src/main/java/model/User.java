package model;

public class User {
    private String userName;
    private String firstName;
	private String lastName;
    private String password;
    private String email;
    private boolean isAdmin;
	public User(String userName, String firstName, String lastName, String password, String email,
			boolean isAdmin) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin;
	}
	
	public User(String userName2, String firstName2, String lastName2, String email2, String password2,
			String retypePassword) {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}