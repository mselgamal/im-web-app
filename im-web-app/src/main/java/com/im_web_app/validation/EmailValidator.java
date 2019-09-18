package com.im_web_app.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{
	
	/*
	 * email format:
	 * 	- recipient@domain.xx
	 */
	private String regexPattern = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*"
			+ "@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		Pattern pattern = Pattern.compile(regexPattern);
		
		if (email == null) return false;
		
		return pattern.matcher(email).matches();
	}

}
