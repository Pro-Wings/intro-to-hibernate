package com.prowings.entity.associations.onetoone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARD_ID")
	private IdentityCard idcard;

	public Student() {
		super();
	}

	public Student(long id, String name, IdentityCard idcard) {
		super();
		this.id = id;
		this.name = name;
		this.idcard = idcard;
	}

	public Student(String name, IdentityCard idcard) {
		super();
		this.name = name;
		this.idcard = idcard;
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

	public IdentityCard getIdcard() {
		return idcard;
	}

	public void setIdcard(IdentityCard idcard) {
		this.idcard = idcard;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", idcard=" + idcard + "]";
	}
}
