package com.revature;

public class ChildOfInheritance extends Inheritance{

	
	public ChildOfInheritance(String name) {
		//super used to call parent methods and constructors
		super(name, 1);
	}
	
	public ChildOfInheritance(String name, int age) {
		//super used to call parent methods and constructors
		super(name, age);
	}
	
	//overrides parent method of same name.
	public void printSelf() {
		System.out.println("I am a child!");
	}
}
