package cs35013s.cli;


import java.util.*;

/*@Author: team 7 (Phillip Chen, Stan Bozhinov, Cord Rehn)
 * 
 * 
 * 
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		CommandInterpreter command = new CommandInterpreter();
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter a command ('quit' to exit): ");
			
			String inputStr = in.nextLine();
			
			if (inputStr.equals("quit"))
				break;
			
			try {
				command.evaluate(inputStr);
			} catch (RuntimeException e) {
				System.out.println("Error: " + e.getLocalizedMessage());
			}
		}
		
		in.close();
		
		System.out.println("Exiting...");
	}

}
