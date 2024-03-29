package com.im_web_app.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im_web_app.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Role find(String name) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Role> query = session.createQuery("from Role where name=:uName", Role.class);
		query.setParameter("uName", name);
		Role role = null;
		
		try {
			role = query.getSingleResult();
		} catch (Exception e) { 
			role = null;
		}
		
		return role;
	}

}
