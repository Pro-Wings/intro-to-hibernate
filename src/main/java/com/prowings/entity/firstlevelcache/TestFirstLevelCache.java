package com.prowings.entity.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestFirstLevelCache {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 

//		Person person1 = new Person();
//		person1.setName("Ram");
//		person1.setAddress("Pune");
//
//		Person person2 = new Person();
//		person2.setName("Sham");
//		person2.setAddress("Mumbai");
//		
//		Person person3 = new Person();
//		person3.setName("Sachin");
//		person3.setAddress("Pune");
//		
//		Person person4 = new Person();
//		person4.setName("Rajiv");
//		person4.setAddress("Kolhapur");
//		
//		session.save(person1);
//		session.save(person2);
//		session.save(person3);
//		session.save(person4);

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
