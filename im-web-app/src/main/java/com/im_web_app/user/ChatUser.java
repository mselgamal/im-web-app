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
	
	@ValidName(message="{error.firstname.validname}")
	@NotNull(message="{error.firstname.notnull}")
	@Size(min=2, max=60, message="{error.firstname.size}")
	private String firstName;
	
	@ValidName(message="{error.lastname.validname}")
	@NotNull(message="{error.lastname.notnull}")
	@Size(min=2, max=60, message="{error.lastname.size}")
	private String lastName;
	
	@ValidEmail(message="{error.email.validemail}")
	@NotNull(message="error.email.notnull")
	@Size(min=7, max=60, message="{error.email.size}")
	private String email;
	
	@ValidUsername(message="{error.username.validusername}")
	@NotNull(message="{error.username.notnull}")
	@Size(min=5, max=50, message="{error.username.size}")
	private String userName;
	
	@ValidPassword(message="{error.password.validpassword}")
	@NotNull(message="{error.password.notnull}")
	@Size(min=7, max=60, message="{error.password.size}")
	private String password;
	
	@NotNull(message="{error.matchingpassword.notnull}")
	@Size(min=7, max=60, message="{error.matchingpassword.size}")
	private String matchingPassword;
	
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
