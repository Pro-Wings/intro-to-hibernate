package com.prowings.entity.associations.onetomany.bidirectional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.util.HibernateUtils;

public class TestOneToManyBiDirectional {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction(); 
		
//		Author author = new Author("J. K. Rolling");
//		
//		Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "ISBN1234");
//		Book book2 = new Book("Harry Potter and the Chamber of Secrets", "ISBN3456");
//		book1.setAuthor(author);
//		book2.setAuthor(author);
//		
//		List<Book> books = new ArrayList<>();
//		books.add(book1);
//		books.add(book2);
//		
//		author.setBooks(books);
//		
//		session.persist(author);

		Author author = session.get(Author.class, 1L);
		
		session.remove(author);
		
		txn.commit();
		session.close();

		
	}

}
