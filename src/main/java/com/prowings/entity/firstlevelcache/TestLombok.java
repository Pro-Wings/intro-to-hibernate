package com.prowings.entity.firstlevelcache;

public class TestLombok {
	
	public static void main(String[] args) {
		
		Person p = new Person(10, "Ram", "Pune");
		System.out.println(p.getAddress());
		p.setAddress("Mumbai");
		System.out.println(p.getAddress());
		
		System.out.println(p);
	}

}
