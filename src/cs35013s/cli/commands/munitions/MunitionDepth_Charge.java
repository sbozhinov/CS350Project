package cs35013s.cli.commands.munitions;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class MunitionDepth_Charge extends A_Command{
	
	private final AgentID id;
	private final AgentID fuze;
	

	public MunitionDepth_Charge(String id, String fuze, String originalString){
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.fuze = ParseUtils.parseObject(AgentID.class, fuze);
	}

	public AgentID getId() {return this.id;}
	public AgentID getFuze() {return fuze;}
	
}
