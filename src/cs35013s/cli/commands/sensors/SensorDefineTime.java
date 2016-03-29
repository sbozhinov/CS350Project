package cs35013s.cli.commands.sensors;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class SensorDefineTime extends A_Command{
	
	private final AgentID id;
	private final Time time;
	
	public SensorDefineTime(String id, String sec, String originalString ){
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.time = ParseUtils.parseObject(Time.class, sec);
	}

	public AgentID getId() {return this.id;}
	public Time getAlt() {return this.time;}
	
}
