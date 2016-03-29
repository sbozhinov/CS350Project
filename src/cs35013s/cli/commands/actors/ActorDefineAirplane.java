package cs35013s.cli.commands.actors;

import java.util.LinkedList;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;

public class ActorDefineAirplane extends A_Command{
	private final AgentID id;
	private final LinkedList<AgentID> munitionIDList;
	
	public ActorDefineAirplane(String id, LinkedList<String> munition, String orig_command) {
		super(orig_command);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		
		
		LinkedList<AgentID> agentList = new LinkedList<AgentID>();
		for(String str: munition){
			agentList.add(ParseUtils.parseObject(AgentID.class, str) );
		}
		agentList.toString();
		this.munitionIDList = agentList;
		
	}

	public AgentID getId() {
		return id;
	}

	public LinkedList<AgentID> getMunitionIDList() {
		return munitionIDList;
	}

	
}
