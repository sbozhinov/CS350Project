package cs35013s.cli.commands.sensors;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class SensorDefineDepth extends A_Command{
	
	private final AgentID id;
	private final Altitude trigAlt;
	
	
	public SensorDefineDepth(String id, String trigAlt, String originalString){
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.trigAlt = ParseUtils.parseObject(Altitude.class, trigAlt);
	}

	public AgentID getId() {return this.id;}
	public Altitude getAlt() {return this.trigAlt;}
	
}
