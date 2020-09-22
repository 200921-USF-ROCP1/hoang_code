package com.revature.calculator;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Calculator!");
		System.out.println("Enter your command below: ");
		System.out.println("(Q - Quit)");
		
		//Declare a new scanner to get user input
		//Step 1 : Use scanner to get user input
		Scanner s = new Scanner(System.in);
		
		//The calculate will run until break is called.
		while(true) {
			//As long as program is running, program will continue to take user input.
			String command = s.nextLine();
			//Only run command if the user does not want to quit.
			if(command.equals("quit")||command.equals("Quit")||command.equals("q")||command.equals("Q"))
				break;
			else {
				try {
					//If valid, will output the result, or answer.
					calculate(command);
				} catch(Exception e){
					//If invalid will output the exception.
					e.printStackTrace();
					System.out.println("Error! Invalid input.");
				} finally {
					//Do something
					//System.out.println("Enter your command below: ");
				}
			}
		}
		
		s.close();
		System.out.println("End of program.");
	}

	public static void calculate(String s) {
		CalculatorImpl calc = new CalculatorImpl();
		
		//CalculatorImpl.parseWithSplit(String) will parse the user input
		int result = calc.parseWithSplit(s);
		if(result != Integer.MAX_VALUE)
			System.out.println("Answer: "+ result);
		else
			System.out.println("Error! Invalid input.");
	}
	
}
