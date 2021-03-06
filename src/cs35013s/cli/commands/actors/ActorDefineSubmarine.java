package cs35013s.cli.commands.actors;

import java.util.LinkedList;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;

public class ActorDefineSubmarine extends A_Command{
	private final AgentID id;
	
	public AgentID getId() {
		return id;
	}

	public LinkedList<AgentID> getMunitionIDList() {
		return munitionIDList;
	}

	private final LinkedList<AgentID> munitionIDList;
	
	public ActorDefineSubmarine(String id, LinkedList<String> munition, String orig_command) {
		super(orig_command);
		LinkedList<AgentID> agentList = new LinkedList<AgentID>();
		for(String str: munition){
			agentList.add(ParseUtils.parseObject(AgentID.class, str) );
		}
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.munitionIDList = agentList;
	}
}
