package com.im_web_app.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String>{
	
	/*
	 * Name format:
	 * 	- must be alphabets only
	 */
	private String regexPattern = "^[a-zA-Z]*$";
	
	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		
		Pattern pattern = Pattern.compile(regexPattern);
		
		if (name == null) return false;
		
		return pattern.matcher(name).matches();
	}

}
