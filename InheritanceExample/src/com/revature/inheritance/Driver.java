package com.revature.inheritance;

public class Driver {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Lion lion = new Lion();
		
		animal.makeNoise();
		animal.eyesAndLegs();
		
		lion.makeNoise();
		lion.eyesAndLegs();
	}
}
