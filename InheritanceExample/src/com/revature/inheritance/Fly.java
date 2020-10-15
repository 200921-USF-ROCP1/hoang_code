package com.revature.inheritance;

public class Fly extends Animal{
	public Fly() {
		numberOfEyes = 100;
		numberOfLegs = 6;
	}
	
	public void makeNoise() {
		System.out.println("Fly: Buzz buzz...");
	}

}
