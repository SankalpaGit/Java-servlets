package model;

public class profile {
	private int profileId;
	private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String description;
    
	public profile(int profileId, int userId, String firstName, String lastName, String email, String phoneNumber,
			String description) {
		super();
		this.profileId = profileId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	int getProfileId() {
		return profileId;
	}

	void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	int getUserId() {
		return userId;
	}

	void setUserId(int userId) {
		this.userId = userId;
	}

	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getLastName() {
		return lastName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getPhoneNumber() {
		return phoneNumber;
	}

	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	String getDescription() {
		return description;
	}

	void setDescription(String description) {
		this.description = description;
	}
    
    
}
