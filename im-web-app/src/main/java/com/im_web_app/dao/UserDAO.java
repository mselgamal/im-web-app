package com.im_web_app.dao;

import com.im_web_app.entity.User;

public interface UserDAO {
	
	public void save(User user);
	public User findByUserName(String username);
	public User findByEmail(String email);
}
