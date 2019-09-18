package com.im_web_app.validation;

public @interface ValidUsername {
	
	public String message() default "Username Already Exists";
}
