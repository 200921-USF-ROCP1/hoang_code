package com.example.main;

import com.example.kevin.Kevin;

public class HelloWorld {
	//public - can be accessed from any other context
	//static - The method belongs to the class.
	//void - returns nothing. void means it returns nothing
	//String[] args - parameters to the method. Array of Strings
	public static void main(String[] args) {
		Kevin k = new Kevin();
		System.out.println("Hello world.");
		System.out.println(k.age);
	}
}
