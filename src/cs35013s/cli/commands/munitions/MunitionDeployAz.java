package cs35013s.cli.commands.munitions;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class MunitionDeployAz extends A_Command{
	
	private final AgentID actor;
	private final AgentID munition;
	private final AttitudeYaw azimuth;
	private final AttitudePitch elevation;

	public MunitionDeployAz(String actor, String munition, String azimuth,
			String elevation, String originalString) {
		super(originalString);
		this.actor = ParseUtils.parseObject(AgentID.class, actor);
		this.munition = ParseUtils.parseObject(AgentID.class, munition);
		this.azimuth = ParseUtils.parseObject(AttitudeYaw.class, azimuth);
		this.elevation = ParseUtils.parseObject(AttitudePitch.class, elevation);
	}

	public AgentID getActor() {return actor;}
	public AgentID getMunition() {return munition;}
	public AttitudeYaw getAzimuth() {return azimuth;}
	public AttitudePitch getElevation() {return elevation;}
	
}
