package cs35013s.cli;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.CommandConstructor;

/*@Author: team 7 (Phillip Chen, Stan Bozhinov, Cord Rehn)
 * 
 * 
 * 
 * 
 */
public class CommandInterpreter {

	
	
	
	/**
	 * @param args
	 */
	public void evaluate(String originalString) {
		
		CommandConstructor constructor = new CommandConstructor(originalString);
		A_Command aCommand = constructor.getCommand();
		aCommand.execute();
		aCommand.getCommandText();
		
		
	}//end evaluate()

}
