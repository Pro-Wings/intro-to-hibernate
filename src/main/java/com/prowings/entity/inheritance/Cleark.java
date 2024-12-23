package com.prowings.entity.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "CLRK")
public class Cleark extends Employee{

	@Column
	private String clericalWorkStatus;

	public Cleark() {
	}

	public Cleark(int age, String name, int salary, String department, String clericalWorkStatus) {
		super(age, name, salary, department);
		this.clericalWorkStatus = clericalWorkStatus;
	}


	public String getClericalWorkStatus() {
		return clericalWorkStatus;
	}

	public void setClericalWorkStatus(String clericalWorkStatus) {
		this.clericalWorkStatus = clericalWorkStatus;
	}

	@Override
	public String toString() {
		return "Cleark [clericalWorkStatus=" + clericalWorkStatus + "]";
	}

	
}
