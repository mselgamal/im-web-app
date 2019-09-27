package com.im_web_app.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im_web_app.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(User user) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(user);
	}
	
	private User find(String strQuery) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<User> query = session.createQuery(strQuery, User.class);
		User user = null;
		
		try {
			user = query.getSingleResult();
		} catch (Exception e) { 
			user = null;
		}
		
		return user;
	}

	@Override
	public User findByEmail(String email) {
		return find("from User where email='"+email+"'");
	}

	@Override
	public User findByUserName(String username) {
		return find("from User where username='"+username+"'");
	}

}
