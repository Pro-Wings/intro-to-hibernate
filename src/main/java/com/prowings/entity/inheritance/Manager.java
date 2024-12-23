package com.prowings.entity.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "MNGR")
public class Manager extends Employee{

	@Column
	private String managerialWorkStatus;

	public Manager() {
	}

	public Manager(int age, String name, int salary, String department, String managerialWorkStatus) {
		super(age, name, salary, department);
		this.managerialWorkStatus = managerialWorkStatus;
	}

	public String getManagerialWorkStatus() {
		return managerialWorkStatus;
	}

	public void setManagerialWorkStatus(String managerialWorkStatus) {
		this.managerialWorkStatus = managerialWorkStatus;
	}

	@Override
	public String toString() {
		return "Manager [managerialWorkStatus=" + managerialWorkStatus + "]";
	}
	
	

}
