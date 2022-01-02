/**
* File: ExcessiveAuth.java
* Author: Zachary N. Brown
* Purpose: Demonstrates CWE-307: Improper Restriction 
* of Excessive Authentication Attempts that allows 
* a user unlimited login attempts increasing the risk
* of a brute force-type attack.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ExcessiveAuth {

    public static void main(String[] args) throws IOException {

        menu();
        
    }

        public static void menu() throws IOException{
            
            String validation = "aQ5t&y!"; // passwords should never be hardcoded (used for simple demonstrative purposes only)
					   // store passwords elsewhere with a hash and salt algorithm
            
            InputStreamReader isReader = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isReader);

			while (true) {
			
			System.out.println("What would you like to do?");
			System.out.println("1. Login");
			System.out.println("2. Exit");
				
			int input = Integer.parseInt(stdin.readLine());
	            
	            if (input == 1) {
	            System.out.println("Enter your username:");
	            String username = (stdin.readLine());
	            System.out.println("Enter your password:");
	            String password = (stdin.readLine());
                    
                    if(password.equals(validation)) {
	                    System.out.println("Welcome back!");
	                    break;

                    } else {
	                    System.out.println("Invalid");
	                    continue; // loop continues with no break allowing excessive attempts
                    } 
                     
	            } else if (input == 2) {
	            	System.out.println("Exiting....");
	            	break;
	            	
	            } else {
	                System.out.println("Invalid input");
	                menu();
	            } 
	           
            } 
        } 
}
