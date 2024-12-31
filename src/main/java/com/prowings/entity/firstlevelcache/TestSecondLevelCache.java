package com.prowings.entity.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestSecondLevelCache {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 

		Person ram1 = session.get(Person.class, 1);
		System.out.println("First time fetched Ram's object: "+ram1);

		Person ram2 = session.get(Person.class, 1);
		System.out.println("Second time fetched Ram's object: "+ram2);
		
		txn.commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		Transaction txn2 = session2.beginTransaction(); 
		
		Person ramFromSession2 = session2.get(Person.class, 1);
		System.out.println("First time fetched Ram's object but in another session: "+ramFromSession2);

		Person ram2FromSession2 = session2.get(Person.class, 1);
		System.out.println("Second time fetched Ram's object but in another session: "+ram2FromSession2);

		txn2.commit();
		session2.close();
	}

}
