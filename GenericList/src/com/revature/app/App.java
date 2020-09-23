package com.revature.app;

import com.revature.generic.list.LinkedList;
import com.revature.generic.list.LinkedList.Iterator;

public class App {
	public static void main(String[] args) {
		LinkedList<String> lst = new LinkedList<String>();
		lst.insert("Hello");
		lst.insert("World");
		
		//Using get
		for (int i = 0; i<lst.getSize();i++) {
			System.out.println(lst.get(i));
		}
		
		//Using Iterator
		Iterator itr = lst.getIterator();
		while(itr.hasNext()) {
			System.out.println(itr.getData());
			itr.next();
		}
	}
}
