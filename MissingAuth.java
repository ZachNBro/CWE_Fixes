/**
* File: MissingAuth.java
* Author: Zachary N. Brown
* Purpose: Demonstrates CWE-306: Missing Authentication 
* for Critical Function that does not authenticate whether
* the user posesses the access level or not.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MissingAuth {
		
	public static void main(String[] args) {

		InputStreamReader isReader = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(isReader);
		
		try {
			System.out.println("Enter Name:");
			String name = (stdin.readLine());
			System.out.println("Enter Access Level:"); // User can specify any access level
			int access = Integer.parseInt(stdin.readLine());
			System.out.println("Enter SSN:");
			int ssn = Integer.parseInt(stdin.readLine());
			
			System.out.println("Your credentials:" + "\n");
			System.out.println("Name: " + name);
			System.out.println("Access Level: " + access);
			System.out.println("SSN:" + ssn);
			
			} catch (IOException e) {
				e.printStackTrace();
				}
	}

}	
