package com.revature.calculator;

public class CalculatorImpl implements Calculator{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	@Override
	public int multiply(int a, int b) {
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		return a/b;
	}

	@Override
	public int exponent(int x, int e) {
		int result = 1;
		
		for(int i = 0; i < e; i++) {
			result *= x;
		}
		
		return result;
	}
	
	public int exponentRecursive(int x, int e) {
		if (e == 0) return 1;
		return x * exponentRecursive(x, e - 1);
	}

	@Override
	//Base values: 0=0, 1=0-(-1);
	public int fibonacci(int i) {
		if(i <= 1) return i;
		return fibonacci(i-1) + fibonacci(i-2);
	}

	@Override
	public int parse(String s) {
		
		//Local variable declarations
		int expression1 = -1;
		int expression2 = -1;
		
		String expr ="";
		int operation = 0;
		
		//Iterate through the given string
		for (int i = 0; i < s.length(); i++) {
			
			if(Character.isDigit(s.charAt(i))){
				expr += s.charAt(i);
			}else {
				if(s.charAt(i) == ' ') {
					continue;
				}else if (s.charAt(i) == '+') {
					operation = 1;
				}else if (s.charAt(i) == '-') {
					operation = 2;
				}else if (s.charAt(i) == '*') {
					operation = 3;
				}else if (s.charAt(i) == '/') {
					operation = 4;
				}

				if(expression1 < 0) {
					
					expression1 = Integer.parseInt(expr);
					expr = "";
				}
			}
			
			if(i == s.length() - 1) {
				if(expression2 < 0) {
					expression2 = Integer.parseInt(expr);
				}
			}
		}
		
		switch(operation) {
		case 1:
			return expression1 + expression2;
		case 2:
			return expression1 - expression2;
		case 3:
			return expression1 * expression2;
		case 4:
			return expression1 / expression2;
		default:
			return Integer.MAX_VALUE;
		}
	}
	
	public int parseWithSplit(String s) {
		String[] parts = s.split(" ");
		//"5 + 2"
		//gives array: ["5", "+", "2"]
		
		
		if(Character.isDigit(parts[0].charAt(0))) {
			int expr1 = Integer.valueOf(parts[0]);
			int expr2 = Integer.valueOf(parts[2]);
			switch(parts[1]) {
				case "+":
					return add(expr1,expr2);
				case "-":
					return subtract(expr1,expr2);
				case "*":
					return multiply(expr1,expr2);
				case "/":
					return divide(expr1,expr2);
				default:
					return Integer.MAX_VALUE;
			}
		}else {
			switch(parts[0]) {
			case "fib":
				return fibonacci(Integer.parseInt(parts[1]));
			case "exp":
				return exponent(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
			default:
				return Integer.MAX_VALUE;
			}
		}
	}
	
}
