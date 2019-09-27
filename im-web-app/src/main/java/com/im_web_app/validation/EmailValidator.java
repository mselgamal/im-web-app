package com.im_web_app.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.im_web_app.entity.User;
import com.im_web_app.service.UserServiceImpl;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{
	
	/*
	 * email format:
	 * 	- recipient@domain.xx
	 */
	private String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+("
			+ "?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private Messages messages;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		User user = userService.findByEmail(email);
		String errorMessageCode = null;
		
		if (user != null) {
			context.disableDefaultConstraintViolation();
			errorMessageCode = "error.email.emailAlreadyExists";
			context.buildConstraintViolationWithTemplate(messages.getMessage(errorMessageCode))
				.addConstraintViolation();
			return false;
		}
		
		Pattern pattern = Pattern.compile(regex);
		
		if (!pattern.matcher(email).matches()) {
			return false;
		}
		
		return true;
	}

}
