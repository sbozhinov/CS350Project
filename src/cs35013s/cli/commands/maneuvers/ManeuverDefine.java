package cs35013s.cli.commands.maneuvers;

import java.util.LinkedList;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class ManeuverDefine extends A_Command{
	private final AgentID id;
	private final LinkedList<String> commandList;
	
	public ManeuverDefine(String id, LinkedList<String> command, String orig_command) {
		super(orig_command);
		
		this.id = ParseUtils.parseObject(AgentID.class, id);
		LinkedList<String> cmdList = new LinkedList<String>();
		for(String str: command){
			cmdList.add(str);
		}
		cmdList.toString();
		this.commandList = cmdList;
	}

	public AgentID getId() {return id;}
	public LinkedList<String> getCommandList() {return commandList;}

}
