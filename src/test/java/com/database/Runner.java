package com.database;

public class Runner {
	public static void main (String[] args) {
		MySingleton m = MySingleton.y();
		
		m.x();
		
		System.out.println(m);
		
		MySingleton m1 = MySingleton.y();
		
		m1.x();
		
		System.out.println(m1);
		
		
	}
}
