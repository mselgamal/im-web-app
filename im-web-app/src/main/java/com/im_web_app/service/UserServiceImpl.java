package com.im_web_app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.im_web_app.dao.RoleDAO;
import com.im_web_app.dao.UserDAO;
import com.im_web_app.entity.User;
import com.im_web_app.entity.Role;
import com.im_web_app.user.ChatUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.find(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void save(ChatUser chatUser) {
		User user = new User();
		user.setUsername(chatUser.getUserName());
		user.setFirstName(chatUser.getUserName());
		user.setLastName(chatUser.getLastName());
		user.setPassword(passwordEncoder.encode(chatUser.getPassword()));
		user.setEmail(chatUser.getEmail());
		
		user.setRoles(Arrays.asList(roleDao.find("ROLE_USER")));
		
		userDao.save(user);
	}

	@Override
	@Transactional
	public User find(String userName) {
		return userDao.find(userName);
	}

}
