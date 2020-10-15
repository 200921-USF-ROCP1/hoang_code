package com.revature.app;

import org.mindrot.jbcrypt.BCrypt;

public class App {
	static int x=10;
	
	public static void main(String[] args) {
		/*for (int x = 0;x<5;x++) {
			System.out.print(x);
		}*/
		System.out.println(017);
		System.out.println("");
		String password = "password";
		
		// Hash a password for the first time
		String hashed = BCrypt.hashpw(password,BCrypt.gensalt());

		// gensalt's log_rounds parameter determines the complexity
		// the work factor is 2**log_rounds, and the default is 10
		//String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

		// Check that an unencrypted password matches one that has
		// previously been hashed
		String check = "password";
		if (BCrypt.checkpw(check, hashed)) {
			System.out.println("It matches");
			System.out.println("Unhashed: " + password);
			System.out.println("Hashed: " + hashed);
		}
		else {
			System.out.println("It does not match");
		}
	}
	
	void Example() {
		System.out.println("Hello");
	}
}
