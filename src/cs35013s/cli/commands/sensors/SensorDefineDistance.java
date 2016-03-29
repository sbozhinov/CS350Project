package cs35013s.cli.commands.sensors;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class SensorDefineDistance extends A_Command{
	
	private final AgentID id;
	private final DistanceNauticalMiles dist;
	
	public SensorDefineDistance(String id, String alt, String originalString){
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.dist = ParseUtils.parseObject(DistanceNauticalMiles.class, alt);
	}

	public AgentID getId() {return this.id;}
	public DistanceNauticalMiles getAlt() {return this.dist;}

}
