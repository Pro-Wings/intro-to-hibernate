package com.prowings.entity.associations.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestOneToOneBiDirectional {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 
		
		Customer customer = new Customer("Ram", "Pune", null);
		Passport passport = new Passport("R123A45M", "India", customer);
		customer.setPassport(passport);

//		session.persist(customer);
		session.persist(passport);
		
		txn.commit();
		session.close();

		
	}

}
