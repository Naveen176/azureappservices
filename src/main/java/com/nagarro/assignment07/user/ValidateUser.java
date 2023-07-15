package com.nagarro.assignment07.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ValidateUser {
	private SessionFactory sf;

	public ValidateUser() {
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		sf = con.buildSessionFactory();
	}

	public User getUserByUsername(String username) {

		Session session = sf.openSession();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from User where username=:username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
}
