package com.im_web_app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.im_web_app.entity.User;
import com.im_web_app.service.UserService;
import com.im_web_app.user.ChatUser;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registerForm")
	public String siggnup(Model model) {
		model.addAttribute("chatUser", new ChatUser());
		return "sign-up";
	}
	
	@PostMapping("/registerUser")
	public String addUser(@Valid @ModelAttribute("chatUser") ChatUser chatUser, 
			BindingResult bindingResult, Model model) {
		
		// check
		if (bindingResult.hasErrors()) {
			return "sign-up";
		}
		
		// check if user in DB
		User user = userService.find(chatUser.getUserName());
		if (user != null) {
			model.addAttribute("chatUser", new ChatUser());
			model.addAttribute("error", "UserName Already Exists");
			
			return "sign-up";
		}
		
		// save to DB
		this.userService.save(chatUser);
		
		//authenticate user
		
		return "redirect:/index.jsp";
	}
}
