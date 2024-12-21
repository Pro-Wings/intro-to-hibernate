package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Car;

public class TestMergeMethodOfSession {
	
	public static void main(String[] args) {
		
		System.out.println("Creating session factory object!!");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Transaction txn1 = session1.beginTransaction(); //--txn started
		
		Car fetchedCar = session1.get(Car.class, 102);
		System.out.println("Original Car--->>>>"+fetchedCar);
		
		txn1.commit();
		session1.close();
		
		fetchedCar.setId(111);
		fetchedCar.setSpeed(700);
		fetchedCar.setName("Tesla 5.o");
		System.out.println("After changes in Detached Car Object--->>>>"+fetchedCar);
		
		Session session2 = sessionFactory.openSession();
		Transaction txn2 = session2.beginTransaction(); //--txn started
		
		session2.merge(fetchedCar);
		
		txn2.commit();
		session2.close();
		
	}

}
