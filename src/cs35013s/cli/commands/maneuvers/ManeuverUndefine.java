package cs35013s.cli.commands.maneuvers;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class ManeuverUndefine extends A_Command{
	
	private final AgentID id;
	
	public ManeuverUndefine(String id, String originalString) {
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
	}

	public AgentID getId() {return id;}

}
