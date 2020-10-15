package com.revature.calculator;

public interface Calculator {
	
	//basic operations
	public int add(int a, int b);
	public int subtract(int a, int b);
	public int multiply(int a, int b);
	public int divide(int a, int b);
	
	//advanced operations
	
	//return x to the power of e
	public int exponent(int x, int e);
	
	//return fib(i)
	public int fibonacci(int i);
	
	//given 5 + 2, return add(5, 2)
	//look into string.SPLIT()
	public int parse(String s);
}
