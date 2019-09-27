package com.im_web_app.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String>{
	
	/*
	 * pattern for password validation rules:
	 * 	- min one capital letter
	 *  - min one number
	 *  - supported special characters: !#$%&*
	 *  - min 8 characters length, max 62 characters
	 */
	private String regexPattern = "((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%&]).{6,60})";
	
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(regexPattern);
		boolean result = false;
		
		if (password == null) return false;
		
		result = pattern.matcher(password).matches();
		return result;
	}

}
