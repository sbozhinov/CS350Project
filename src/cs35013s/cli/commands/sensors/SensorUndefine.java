package cs35013s.cli.commands.sensors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class SensorUndefine extends A_Command{
	
	private final AgentID id;
	
	public SensorUndefine(String id, String originalString) {
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
	}

	public AgentID getId() {return id;}

}
