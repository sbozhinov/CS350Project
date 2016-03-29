package cs35013s.cli.commands.munitions;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class MunitionLoad extends A_Command{
	
	private final AgentID actor;
	private final AgentID munition;
	
	public MunitionLoad(String actor, String munition, String originalString) {
		super(originalString);
		this.actor = ParseUtils.parseObject(AgentID.class, actor);
		this.munition = ParseUtils.parseObject(AgentID.class, munition);
	}

	public AgentID getActor() {return actor;}
	public AgentID getMunition() {return munition;}
	
	
}
