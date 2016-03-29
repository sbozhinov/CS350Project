package cs35013s.cli.commands.actors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class ActorSetAltitude extends A_Command{
	private final AgentID id;
	private final Altitude altitude;
	
	public ActorSetAltitude(String id, String alt, String originalString) {
		super(originalString);
		
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.altitude = ParseUtils.parseObject(Altitude.class, alt);
		
	}

	public AgentID getId() {
		return id;
	}

	public Altitude getAltitude() {
		return altitude;
	}

	
}
