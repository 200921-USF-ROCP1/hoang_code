package com.revature.calculator.generic;

public abstract interface GenericCalculator<T> {
	
	//basic operations
	public T add(T a, T b);
	public T subtract(T a, T b);
	public T multiply(T a, T b);
	public T divide(T a, T b);
	
	//advanced operations
	
	//return x to the power of e
	public T exponent(T x, T e);
	
	//return fib(i)
	public T fibonacci(T i);
	
	//given 5 + 2, return add(5, 2)
	//look into string.SPLIT()
	public T parse(String s);
}
