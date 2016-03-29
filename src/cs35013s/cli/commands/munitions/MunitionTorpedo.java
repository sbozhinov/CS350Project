package cs35013s.cli.commands.munitions;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class MunitionTorpedo extends A_Command{
	
	private final AgentID id;
	private final AgentID sensor;
	private final AgentID fuze;
	private final Time time;
	
	public MunitionTorpedo(String id, String sensor, String fuze, String sec, String originalString){
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.sensor = ParseUtils.parseObject(AgentID.class, sensor);
		this.fuze = ParseUtils.parseObject(AgentID.class, fuze);
		this.time = ParseUtils.parseObject(Time.class, sec);
	}

	public AgentID getId() {return this.id;}
	public AgentID getSensor() {return this.sensor;}
	public AgentID getFuze() {return this.fuze;}
	public Time getTime() {return this.time;}
	
	
}
