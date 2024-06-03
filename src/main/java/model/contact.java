package model;

public class contact {

	private String Phone;
	private String gmail;
	private String messages;
	public contact(String phone, String gmail, String messages) {
		super();
		Phone = phone;
		this.gmail = gmail;
		this.messages = messages;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
}
