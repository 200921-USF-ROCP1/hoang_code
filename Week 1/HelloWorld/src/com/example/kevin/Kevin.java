package com.example.kevin;

public class Kevin {
	public int age = 18;
	
	/* Primitive Types or Value Types */
	//data types: all types are 2^x
	boolean bool; //1 bit
	byte b; //8 bits, 2^3
	char c; //16 bits
	short s; //16 bits, 2^4
	int i; //32 bits, 2^5
	float f; //32 bits
	double d; //64 bits
	long l; //64 bits, 2^6
	
	/* Reference Types */
	//contains a reference or ADDRESS
	//of values in the heap
	String str = new String();
	char[] ch = {'I', ' ','a','m'}; // ==String "I am"
	Object o = new Object();
	
	/* Access Modifiers */
	//public
	//default
	//protected
	//private
	
	//Can be accessed from anywhere.
	public void myPublicMethod() {
		//Instance method
		str.charAt(0);
		//static method
		String.valueOf(false);
	}
	
	//No access modifier = default access modifier;
	//Anything within the same package can access
	//AKA package-private
	void myDefaultMethod() {}
	
	//Can be accessed from inside the class
	//and any subclasses (AKA child classes)
	protected void myProtectedMethod() {}
	
	//Private methods and variables cannot be seen
	//from anywhere but inside the class.
	private void myPrivateMethod() {}
	
	//Classes can only be public or default
	//unless declared inside of another class.
	
	private class PrivateClass{}
	static class StaticClass{}
	
	//Constructors (no parameters)
	public Kevin() {
		System.out.println("Inside Kevin()");
	}
	
	//Parameterized constructor
	public Kevin(int i) {
		this.i = i;
		System.out.println("Inside Kevin(int i), this.i = " + this.i);
	}
	
	public Kevin(int i, char c, boolean bool) {
		this.i = i;
		this.c = c;
		this.bool = bool;
	}
	
	//Java favors the most specific scope.
	//Class scope
	//Method scope
	//Block scope
	
	//i in parameters overshadows class's i
	public void scopes(int i) {
		if(bool) {
			//Use "this" to get to class variables in that case
			this.i = i;
		}
	}
	
	//Control statements
	public void control(boolean yes, int val) {
		if(yes) {
			//Do something if yes is true
		}else if(val == 2){
			//Do something if val is 2
		}else {
			//Do something if all of the above is false
		}
		
		//(Declaration:Condition:Iterator)
		for(int i = 0; i < val; i++) {
			//Do something while condition is held
			
			//break immediately exits the loop
			break;
		}
		
		//(Declaration:Condition:Iterator)
		for(int i = 0; i < val; i++) {
		//Do something while condition is held
					
			//skips the rest of the code underneath
			//in the same block, continues to next iteration
			continue;
		}
		
		while(yes) {
			//Do something repeatedly while yes is true
		}
		
		do {
			//Do something at least once before checking condition
		} while(yes);
		
		switch(val) {
		case 0:
			//Do something if val is 0
			break;
		case 1:
			//Do something if val is 1
			break;
		case 2:
			//Do something if val is 2
			break;
		default:
			//If no other cases match
			break;
		}
	}
}
