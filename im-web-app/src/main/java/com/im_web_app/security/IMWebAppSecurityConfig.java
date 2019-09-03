package com.im_web_app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class IMWebAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// temp in-memmory authentication for testing
		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(users.username("mando")
				.password("mando").roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// setup authentication to different login page
		http.authorizeRequests().anyRequest().authenticated()
			.and().formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateUser")
				.permitAll();
	}
}
