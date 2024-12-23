package com.prowings.entity.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestSingleTableStrategy {
	
	public static void main(String[] args) {
		
		Manager manager = new Manager(37, "Ram", 89999, "IT", "pending");
		Cleark cleark = new Cleark(33, "Sham", 23333, "IT", "completed");
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 
		
		session.save(manager);
		session.save(cleark);
		txn.commit();
		session.close();

		
	}

}
