package com.prowings.query.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.entity.associations.onetomany.Author;
import com.prowings.entity.associations.onetomany.bidirectional.Book;
import com.prowings.util.HibernateUtils;

import jakarta.persistence.Query;


public class QueryDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 

		
		Query query = session.createQuery("From Author", Author.class);
		
		List<Book> authrs = query.getResultList();
		
		System.out.println(authrs);
		
		txn.commit();
		session.close();
		
	}
	
}
