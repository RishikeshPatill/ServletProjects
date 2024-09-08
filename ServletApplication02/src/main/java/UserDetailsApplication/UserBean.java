package UserDetailsApplication;

public class UserBean {

	private String userName;
	private String passWord;
	private String address;
	private String mailId;
	private long phone;
	private String state;
	private String country;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", passWord=" + passWord + ", address=" + address + ", mailId="
				+ mailId + ", phone=" + phone + ", state=" + state + ", country=" + country + "]";
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
