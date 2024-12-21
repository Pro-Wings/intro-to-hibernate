package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Car;

public class TestUpdateMethodOfSessionErrSc {
	
	public static void main(String[] args) {
		
		System.out.println("Creating session factory object!!");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session1 = sessionFactory.openSession();
		Transaction txn1 = session1.beginTransaction(); //--txn started
		
		Car fetchedCar = session1.get(Car.class, 252);
		System.out.println("Session1 Car--->>>>"+fetchedCar);
		
		fetchedCar.setName("Audi X3");
		
		txn1.commit();


		Session session2 = sessionFactory.openSession();
		Transaction txn2 = session2.beginTransaction(); //--txn started
		
		Car fetchedCar2 = session2.get(Car.class, 252);
		System.out.println("Session2 Car--->>>>"+fetchedCar2);

		
//		session2.update(fetchedCar);
		session2.merge(fetchedCar);
		
		txn2.commit();
		session2.close();
		
		
	}

}
