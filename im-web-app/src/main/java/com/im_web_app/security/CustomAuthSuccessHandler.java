package com.im_web_app.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.im_web_app.entity.User;
import com.im_web_app.service.UserService;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
    private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

		String userName = authentication.getName();
		
		System.out.println("userName=" + userName);

		User user = userService.findByUserName(userName);
		
		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		// forward to home page
		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath() + "/");
	}

}
