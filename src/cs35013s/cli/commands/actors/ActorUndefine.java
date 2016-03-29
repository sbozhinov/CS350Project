package cs35013s.cli.commands.actors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;

public class ActorUndefine extends A_Command {
	private final AgentID id;
	
	public AgentID getId() {
		return id;
	}


	public ActorUndefine(String id, String originalString) {
		super(originalString);
		
		this.id = ParseUtils.parseObject(AgentID.class, id);
	}

}
