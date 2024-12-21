package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Car;

public class TestHibernate {
	
	public static void main(String[] args) {
		
		System.out.println("Creating session factory object!!");
		//step-1 : create session factory object
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//Step-2 : Create Session object
		Session session = sessionFactory.openSession();
		
		//Step-3 : Create Transaction object
		Transaction txn = session.beginTransaction(); //--txn started
		
		//Step-4 : Perform DB operations on object
//		Car car1 = new Car();
//		car1.setName("Audi X1");
//		car1.setSpeed(455);
//		Integer id = (Integer) session.save(car1);
//		System.out.println("Car saved with id : "+id);
		
//		session.saveOrUpdate(car1);
		
//		System.out.println("Car object saved to DB successfully!!");
		
//		System.out.println("Getting car object from DB!!");
//		
//		Car fetchedCar = session.get(Car.class, 152);
////		Car fetchedCar = session.load(Car.class, 152);
//		
//		fetchedCar.setSpeed(555);
//		session.update(fetchedCar);
//		
//		System.out.println("Fetched Car from DB : "+fetchedCar);
		
		
		Car fetchedCar1 = session.get(Car.class, 52);
		System.out.println("1--->>>>"+fetchedCar1);

		Car fetchedCar2 = session.get(Car.class, 102);
		System.out.println("2--->>>>"+fetchedCar2);

		Car fetchedCar3 = session.get(Car.class, 52);
		System.out.println("3--->>>>"+fetchedCar3);

		Car fetchedCar4 = session.get(Car.class, 102);
		System.out.println("2--->>>>"+fetchedCar4);
		
		txn.commit();
		session.close();
		
	}

}
