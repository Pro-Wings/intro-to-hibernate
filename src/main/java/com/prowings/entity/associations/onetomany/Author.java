package com.prowings.entity.associations.onetomany;

import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
//@NamedQuery(name = "getAllAuthers", query = "from Author")

@NamedQueries({
			@NamedQuery(name = "getAllAuthers", query = "from Author"),
			@NamedQuery(name = "getAllAuthersWithMin5Books", query = "from Author")
		})

@NamedNativeQuery(name = "SqlQuery1", query = "Select * from Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private List<Book> books;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
	}

	
}
