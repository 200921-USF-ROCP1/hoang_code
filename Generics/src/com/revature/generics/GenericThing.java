package com.revature.generics;

//A generic is a type-agnostic class
//meaning, it could interact with any given class.
public class GenericThing<T> {
	T t;
	
	public GenericThing(T newT) {
		this.t = newT;
		
		System.out.println(t.toString());
		
	}
	
	//public T add(T a, T b) {
		//return a + b;
	//}
}
