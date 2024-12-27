package com.prowings.entity.associations.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestOneToMany {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 
		
		Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "ISBN1234");
		Book book2 = new Book("Harry Potter and the Chamber of Secrets", "ISBN3456");
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		
		Author author = new Author("J. K. Rolling", books);
		
		session.persist(author);
		
		Author fetchedAuther = session.get(Author.class, 1L);
		
		System.out.println(fetchedAuther);
		
//		System.out.println(fetchedAuther);
		
		txn.commit();
		session.close();

		
	}

}
