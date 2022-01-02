import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcessiveAuthFix {

    public static void main(String[] args) throws IOException {

        menu();
        
    }

        public static void menu() throws IOException{
            
            String validation = "aQ5t&y!";
            // include starting value for counter
            int login_attempts = 1;
            
            InputStreamReader isReader = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isReader);

			while (true) {
			
			// condition for max login attempts
			if (login_attempts <= 3) {
			
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
	                    // increment counter
	                    login_attempts++;
	                    continue;
                    }
                   
	            } else if (input == 2) {
	            	System.out.println("Exiting....");
	            	break;
	            	
	            } else {
	                System.out.println("Invalid input");
	                menu();
	            }
	           
            } else {
            	// display error when max attempts are
                System.out.println("Contact your administrator.");
                break;
            }
        } 
    }
}