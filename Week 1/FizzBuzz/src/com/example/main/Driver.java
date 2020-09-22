package com.example.main;

import com.example.classes.FizzBuzz;

public class Driver {
	public static void main(String[] args) {
		int num = 15;
		
		System.out.println("FizzBuzz for " + num + ": ");
		FizzBuzz.fizzBuzz(num);
	}
}
