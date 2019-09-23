package com.im_web_app.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.im_web_app.validation.FieldMatch;
import com.im_web_app.validation.ValidEmail;
import com.im_web_app.validation.ValidName;
import com.im_web_app.validation.ValidPassword;
import com.im_web_app.validation.ValidUsername;

@FieldMatch.List(value = { @FieldMatch(first = "password", 
	second = "matchingPassword", message = "The password fields must match") })
public class ChatUser {

	@ValidUsername
	@NotNull(message="Username is required")
	@Size(min=8, max=50, message="Username - Invalid number of characters")
	private String userName;
	
	@ValidPassword
	@NotNull(message="Password is required")
	@Size(min=7, max=60, message="Password - Invalid number of characters")
	private String password;
	
	@NotNull(message="Re-enter password is required")
	@Size(min=7, max=60, message="Re-enter Password - Invalid number of characters")
	private String matchingPassword;
	
	@ValidName(message="Invalid firstName, Alphabets only")
	@NotNull(message="Firstname - is required")
	@Size(min=7, max=60, message="Firstname - Invalid number of characters")
	private String firstName;
	
	@ValidName(message="Invalid lastName, Alphabets only")
	@NotNull(message="Lastname - is required")
	@Size(min=7, max=60, message="lastname - Invalid number of characters")
	private String lastName;
	
	@ValidEmail
	@NotNull(message="Email - is required")
	@Size(min=7, max=60, message="email - Invalid number of characters")
	private String email;
	
	public ChatUser() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ChatUser [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
	
}
