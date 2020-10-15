package com.revature.inheritance;

public class Animal {
	protected int numberOfEyes;
	protected int numberOfLegs;
	
	public Animal() {
		numberOfEyes=0;
		numberOfLegs=0;
	}
	
	public void makeNoise() {
		System.out.println("Some sound...");
	}
	
	public void eyesAndLegs() {
		System.out.println("Number of eyes: " + numberOfEyes);
		System.out.println("Number of legs: " + numberOfLegs);
	}
}
