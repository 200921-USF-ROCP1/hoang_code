package com.revature.generic.arraylist;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		
		arrList.add(1);
		arrList.add(5);
		arrList.add(6);
		arrList.add(5);
		arrList.add(7);
		
		/*
		arrList.displayArray();
		System.out.println("Array List content at index 2: " + arrList.get(2));
		System.out.println("Array Size: " + arrList.size());
		System.out.println("Array Length: " + arrList.length());
		*/
		
		Object[][] splitArray = arrList.split(3);
		
		//Using a bunch of System.out.println statements
		print2dArray(splitArray);
		
		//Using StringBuilder
		System.out.println(get2dArrayString(splitArray));
	}
	
	public static void print2dArray(Object[][] array) {
		for(int i = 0; i <array.length;i++) {
			for(int j = 0; j<array[i].length;j++) {
				System.out.print(array[i][j]);
				
				if(j+1<array[i].length)
					System.out.print(", ");
			}
			System.out.print("\n");
		}
	}
	
	public static String get2dArrayString(Object[][] array) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				sb.append(array[i][j]);
				
				if(j + 1 < array[i].length) {
					sb.append(", ");
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
