package com.revature;

/*
 * We use Encapsulation to protect our data from misuse
 * via getters and setters
 */
public class Encapsulation {
	
	private int i;
	
	String name;
	
	//We use getters to get values of private variables
	public int getI() {
		return i;
	}

	//can be protected or default, depending on the need
	protected void setI(int i) {
		this.i = i;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
