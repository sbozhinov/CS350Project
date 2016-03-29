package cs35013s.cli.commands.views;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class ViewLockWindow  extends A_Command{
	
	private final AgentID window;
	private final AgentID agent;
	
	public ViewLockWindow(String window, String agent, String originalString) {
		super(originalString);
		this.window = ParseUtils.parseObject(AgentID.class, window);
		this.agent = ParseUtils.parseObject(AgentID.class, agent);
	}

	public AgentID getWindow() {return window;}
	public AgentID getAgent() {return agent;}

}
