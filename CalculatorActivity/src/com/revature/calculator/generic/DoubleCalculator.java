package com.revature.calculator.generic;

public class DoubleCalculator implements GenericCalculator<Double>{
	@Override
	public Double add(Double a, Double b) {
		return a+b;
	}

	@Override
	public Double subtract(Double a, Double b) {
		return a-b;
	}

	@Override
	public Double multiply(Double a, Double b) {
		return a*b;
	}

	@Override
	public Double divide(Double a, Double b) {
		return a/b;
	}

	@Override
	public Double exponent(Double x, Double e) {
		double result = 1;
		
		for(int i = 0; i < e; i++) {
			result *= x;
		}
		
		return result;
	}
	
	public Double exponentRecursive(Double x, Double e) {
		if (e == 0) return (double)1;
		return x * exponentRecursive(x, e - 1);
	}

	@Override
	//Base values: 0=0, 1=0-(-1);
	public Double fibonacci(Double i) {
		if(i <= 1) return i;
		return fibonacci(i-1) + fibonacci(i-2);
	}

	@Override
	public Double parse(String s) {
		
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
			return (double)expression1 + expression2;
		case 2:
			return (double)expression1 - expression2;
		case 3:
			return (double)expression1 * expression2;
		case 4:
			return (double)expression1 / expression2;
		default:
			return (double)Integer.MAX_VALUE;
		}
	}
	
	public Double parseWithSplit(String s) {
		String[] parts = s.split(" ");
		//"5 + 2"
		//gives array: ["5", "+", "2"]
		
		
		if(Character.isDigit(parts[0].charAt(0))) {
			int expr1 = Integer.valueOf(parts[0]);
			int expr2 = Integer.valueOf(parts[2]);
			switch(parts[1]) {
				case "+":
					return add((double)expr1,(double)expr2);
				case "-":
					return subtract((double)expr1,(double)expr2);
				case "*":
					return multiply((double)expr1,(double)expr2);
				case "/":
					return divide((double)expr1,(double)expr2);
				default:
					return (double)Integer.MAX_VALUE;
			}
		}else {
			switch(parts[0]) {
			case "fib":
				return fibonacci((double)Integer.parseInt(parts[1]));
			case "exp":
				return exponent((double)Integer.parseInt(parts[1]),(double)Integer.parseInt(parts[2]));
			default:
				return (double)Integer.MAX_VALUE;
			}
		}
	}
}
