package com.revature.app;

import com.revature.finallyize.WhatIsFinal;

/*
 * Annotations, including Override and Depracated
 * final vs finalize vs finally
 * Var args (or the ...) means 0 or more arguments
 * whereas [] in the main method uses 1 argument
 */
public class App {
	public static void main(String...args) {
		String a = "Hello", b = "there", c="friend!";
		String[] arr = {a,b,c};
		
		printArgs(arr);
		
		printVarArgs(a,b,c);
		printVarArgs(arr);
		printVarArgs();
		
		//Methods like printf use var args.
		System.out.printf("%d %d %d", 1,2,3);
		
		WhatIsFinal f = new WhatIsFinal();
		
	}
	
	public static void printArgs(String[] strings) {
		for(int i=0;i<strings.length;i++)
			System.out.println(strings[i]);
	}
	
	//Var args uses ellipsis instead of array symbol
	//to take 0 or more arguments
	public static void printVarArgs(String...strings) {
		for(int i=0;i<strings.length;i++)
			System.out.println(strings[i]);
	}
	
	//Other parameters need to be declared before var args declaration
	//There can only be 1 var args declared
	public static void aNameAndSomeStrings(String name, String...strings) {
		
	}
	
	
}
