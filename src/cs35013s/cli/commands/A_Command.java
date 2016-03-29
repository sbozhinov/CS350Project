/**
 * 
 */
package cs35013s.cli.commands;

import java.lang.reflect.Field;

/**
 * @author Cord
 */
public abstract class A_Command {

	private String m_OriginalCommandText;
	
	
	public A_Command(String orig_command) {
		m_OriginalCommandText = orig_command;
	}
	
	
	public final String getCommandText() {
		return m_OriginalCommandText;
	}
	
	
	/**
	 * Execute this command.  Default just prints out this command's data.
	 */
	public void execute() {
		System.out.println(this);
	}
	
	
	
	/**
	 * This will return a String as a display of all members of the
	 * instantiated class that extends A_Command this is called on. (meaning this is polymorphic, see below)
	 */
	@Override
	public String toString() { 
		StringBuilder output = new StringBuilder();

		output.append(getClass().getSimpleName() + " Data:\n");

		// get the fields/data for each specific command
		// this does NOT get A_Command's field (command text) as it will be
		// a super class to the class toString is called on, despite this code technically existing in A_Command
		Field[] fields = getClass().getDeclaredFields();
		
		for (Field field : fields)
			try {
				output.append("    " + field.getName() + ": ");
				field.setAccessible(true); // since most fields are private, we force access
				output.append(field.get(this) + "\n");
			} catch (IllegalAccessException e) {
				output.append(e.getLocalizedMessage() + "\n");
			}

		return output.toString();
	}
}
