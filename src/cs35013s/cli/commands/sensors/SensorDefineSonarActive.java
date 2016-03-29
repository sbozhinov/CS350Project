package cs35013s.cli.commands.sensors;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;


public class SensorDefineSonarActive extends A_Command{
	
	private final AgentID id;
	private final Power pwr;
	private final Sensitivity sense;

	public SensorDefineSonarActive(String id, String pwr,
			String sense, String originalString) {
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.pwr = ParseUtils.parseObject(Power.class, pwr);
		this.sense = ParseUtils.parseObject(Sensitivity.class, sense);
	}

	public AgentID getId() {return id;}
	public Power getPwr() {return pwr;}
	public Sensitivity getSense() {return sense;}

}
