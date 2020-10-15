package com.revature.inheritance;

public class Lion extends Animal{
	public Lion() {
		numberOfEyes = 2;
		numberOfLegs = 4;
	}
	
	public void makeNoise() {
		System.out.println("Lion: Roar!");
	}
}

