package cs35013s.cli.commands.sensors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class SensorDefineThermal extends A_Command{
	
	private final AgentID id;
	private final FieldOfView fov;
	private final Sensitivity sense;
	
	public SensorDefineThermal(String id, String fov, String sense,
			String originalString) {
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.fov = ParseUtils.parseObject(FieldOfView.class, fov);
		this.sense = ParseUtils.parseObject(Sensitivity.class, sense);
		
	}

	public AgentID getId() {return id;}
	public FieldOfView getFov() {return fov;}
	public Sensitivity getSense() {return sense;}

}
