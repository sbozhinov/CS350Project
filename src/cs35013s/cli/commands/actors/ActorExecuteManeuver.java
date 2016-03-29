package cs35013s.cli.commands.actors;

import java.util.LinkedList;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;

public class ActorExecuteManeuver extends A_Command{
	private final AgentID id1;
	private final AgentID id2;
	private final LinkedList<AgentID> maneuverIDList;
	

	public ActorExecuteManeuver(String id, String id2, LinkedList<String> agentIDList, String orig_command) {
		super(orig_command);
		this.id1 = ParseUtils.parseObject(AgentID.class, id);
		this.id2 = ParseUtils.parseObject(AgentID.class, id2);
		
		LinkedList<AgentID> agentList = new LinkedList<AgentID>();
		for(String str: agentIDList){
			agentList.add(ParseUtils.parseObject(AgentID.class, str) );
		}

		this.maneuverIDList = agentList;
		
	}

	public AgentID getId1() {
		return id1;
	}

	public AgentID getId2() {
		return id2;
	}

	public LinkedList<AgentID> getManeuverIDList() {
		return maneuverIDList;
	}


}
