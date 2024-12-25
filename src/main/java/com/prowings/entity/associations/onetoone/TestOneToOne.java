package com.prowings.entity.associations.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestOneToOne {
	
	public static void main(String[] args) {
		
//		IdentityCard card = new IdentityCard(12345, "RFID");
//		Student std1 = new Student("Ram", card);
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 
		
//		session.persist(std1);
		
		Student fetchedStd = session.get(Student.class, 1);
//		session.remove(fetchedStd);
		
		System.out.println(fetchedStd);
		
		System.out.println("done!!");
		txn.commit();
		session.close();

		
	}

}
