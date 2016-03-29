package cs35013s.cli.commands.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.CommandConstructor;

public class Load extends A_Command{
	
	private CommandConstructor m_CommandConstructor;
	private File m_File;
	
	public Load(String filename, CommandConstructor commandConstructor, String originalString) {
		super(originalString);
		
		m_CommandConstructor = commandConstructor;
		m_File = new File(filename);
	}


	
	public void execute() {
		System.out.println("Executing commands inside " + m_File.getName() + "...");
		
		Scanner file_in = null;
		
		try {
			file_in = new Scanner(m_File);
			
			while (file_in.hasNext()) {
				String command = file_in.nextLine();
				
				if (command.isEmpty())
					continue;
				
				System.out.println("\nExecuting command: " + command);
				
				try {
					m_CommandConstructor.evaluate(command);
				} catch (RuntimeException e) {
					System.out.println("Error: " + e.getLocalizedMessage());
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error loading file: " + e);
		} finally {
			file_in.close();
		}

		System.out.println();
	}
}
