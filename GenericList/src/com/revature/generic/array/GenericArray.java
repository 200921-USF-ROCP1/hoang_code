package com.revature.generic.array;

public class GenericArray<T> {
	T[] arr;
	
	public GenericArray(T t) {
		arr = (T[])(new Object[10]);
	}
}
