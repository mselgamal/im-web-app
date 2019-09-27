package com.im_web_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.im_web_app.validation.Messages;

@Controller
public class LoginController {
	
	@Autowired
	private Messages messages;

	@GetMapping("/login")
	public String showLogin() {
		return "login.html";
	}
	
	@GetMapping("/login/newuser")
	public String showLogin(@ModelAttribute String message, Model model) {
		System.out.println("new user login "+message);
		model.addAttribute("message", message);
		return "login.html";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("error", messages.getMessage("error.login.auth"));
		return "login";
	}
}
