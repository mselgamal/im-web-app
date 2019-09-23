package com.im_web_app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.im_web_app.entity.User;
import com.im_web_app.user.ChatUser;

public interface UserService extends UserDetailsService {
	
	public void save(ChatUser user);
	public User find(String userName);
}
