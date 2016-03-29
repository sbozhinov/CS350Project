package cs35013s.cli.commands.sensors;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class SensorDefineSonarPassive extends A_Command{
	
	private final AgentID id;
	private final Sensitivity sense;
	
	public SensorDefineSonarPassive(String id, String sense,
			String originalString) {
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.sense = ParseUtils.parseObject(Sensitivity.class, sense);
	}

	public AgentID getId() {return id;}
	public Sensitivity getSense() {return sense;}
}
