package com.im_web_app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im_web_app.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(user);
	}

	@Override
	public User find(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User where username=:uName", User.class);
		query.setParameter("uName", username);
		User user = null;
		
		try {
			user = query.getSingleResult();
		} catch (Exception e) { 
			user = null;
		}
		
		return user;
	}

}
