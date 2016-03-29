package cs35013s.cli.commands.actors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;


public class ActorSetSpeed extends A_Command{
	private final AgentID id;
	private final Groundspeed speed;
	
	public AgentID getId() {
		return id;
	}

	public Groundspeed getSpeed() {
		return speed;
	}

	
	public ActorSetSpeed(String id, String speed, String originalString) {
		super(originalString);
		
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.speed = ParseUtils.parseObject(Groundspeed.class, speed);
	}

	
}
