package cs35013s.cli.commands.munitions;
import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class MunitionBomb extends A_Command{
	
	private final AgentID id;
	
	public MunitionBomb(String id, String originalString){
		super(originalString);
		this.id = ParseUtils.parseObject(AgentID.class, id);
	}

	public AgentID getId() {return this.id;}
	
}
