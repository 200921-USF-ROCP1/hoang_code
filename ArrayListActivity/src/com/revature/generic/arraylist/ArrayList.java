package com.revature.generic.arraylist;

public class ArrayList<T> {
	T[] arr;
	
	public ArrayList() {
		arr = (T[]) new Object[1];
	}
	
	public void add(T t) {
		
		//keep track of if the array is full or not
		boolean assigned = false;
		
		//iterate through the array
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == null) {
				//if the element is assigned, break out of the loop
				arr[i] = t;
				assigned = true;
				break;
			}
		}
		
		if(!assigned) {
			int indexToAssign = arr.length;
			T[] tempArr = (T[]) new Object[arr.length * 2];
			for(int i= 0;i<arr.length;i++) {
				tempArr[i] = arr[i];
			}
			arr = tempArr;
			arr[indexToAssign] = t;
		}
	}
	
	public T get(int i) {
		if(i < 0 || i >arr.length-1)
			throw new IndexOutOfBoundsException();
		
		return arr[i];
	}
	
	public int size() {
		return arr.length;
	}
	
	public int length() {
		int length = 0;
		
		for(int i = 0; i<size();i++)
			if(arr[i]!=null)
				length++;
		
		return length;
	}
	
	public void displayArray() {
		for(int i = 0;i <size();i++) {
			if(arr[i]!=null)
				System.out.println(arr[i]);
		}
	}
	
	/*
	 * Split should take arr and split into a number of subarrays
	 * The number is given by numberOfArrays
	 * 
	 * eg if [1, 5, 6, 5, 7] and input is 3
	 * 1 = 0
	 * 5 = 1
	 * 6 = 2
	 * 5 = 3
	 * 7 = 4
	 * so the output would be:
	 * [[1,5], 1 = (0,0) | 5 = (0,1)
	 * 	[6,5], 6 = (1,0) | 5 = (1,1)
	 *  [7]]   7 = (2,0)
	 */
	public T[][] split(int numberOfNewArrays){

		//How big each subarray should be
		//int sizeOfSubArray = size() / numberOfNewArrays;
		
		//takes the ceiling of length / numberOfNewArrays
		int sizeOfSubArray = (length() + numberOfNewArrays - 1) / numberOfNewArrays;
		
		//Declare what to return
		T[][] splitArray = (T[][]) new Object[numberOfNewArrays][sizeOfSubArray];
		
		for(int i = 0; i < numberOfNewArrays; i++) {
			for(int j = 0; j < sizeOfSubArray; j++) {
				if(arr[(i * sizeOfSubArray + j)] != null)
					splitArray[i][j] = arr[(i * sizeOfSubArray + j)];
			}
		}
		
		return splitArray;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;++i) {
			sb.append(arr[i]);
		
			if(1 + i < arr.length)
				sb.append(", ");
		}
		
		return sb.toString();
	}
	
}
