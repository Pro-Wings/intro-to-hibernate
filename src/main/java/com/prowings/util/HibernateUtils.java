package com.prowings.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null) {
			System.out.println("Creating session factory object!!");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		else {
			System.out.println("SessionFactory is already initialized.. so returning same sessionfactory object!!");
			return sessionFactory;
		}
	}

}
