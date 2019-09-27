package com.im_web_app.validation;

import javax.validation.Payload;

public @interface ValidUsername {
	public String message();
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
