package FlightManagementSystem.Dto;

public class UserDto {
	private long userId ;
	 private String userName;
	 private String userType;
	 private String userPassword;
	 private long userPhone;
	 private String email;
	 
	 /*--------------------------------------------------------Constructor--------------------------------------------------------*/
	public UserDto() {
		super();
		
	}

	/*------------------------------------------------GETTER AND SETTER-----------------------------------------------------------*/

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/*---------------------------------------------------------toString() Method----------------------------------------------*/
	@Override
	public String toString() {
		return "AirportDto [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", email=" + email + "]";
	}

	 
}
