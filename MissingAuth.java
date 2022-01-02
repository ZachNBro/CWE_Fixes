import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingAuth {
	
	
	public static void main(String[] args) {

		InputStreamReader isReader = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(isReader);
		
		try {
			System.out.println("Enter Name:");
			String name = (stdin.readLine());
			System.out.println("Enter Access Level:");
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