package com.im_web_app.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.im_web_app.entity.User;
import com.im_web_app.service.UserServiceImpl;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String>{
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private Messages messages;
	
	/**
	 * username requirements:
	 * 	- min 8 characters, max 50
	 * 	- must start with alphabet
	 * 	- only alphabets and numbers allowed
	 */
	private String regex = "^[a-zA-Z][a-zA-Z0-9]{7,49}$";
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		User user = this.userService.findByUserName(username);
		String errorMessageCode = null;
		
		if (user != null) {
			context.disableDefaultConstraintViolation();
			errorMessageCode = "error.username.usernameAlreadyExists";
			context.buildConstraintViolationWithTemplate(messages.getMessage(errorMessageCode))
				.addConstraintViolation();
			return false;
		}
		
		Pattern pattern = Pattern.compile(regex);
		
		if (!pattern.matcher(username).matches()) {
			return false;
		}
		
		return true;
	}

}
