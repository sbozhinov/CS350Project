package cs35013s.cli.commands.misc;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class Wait extends A_Command{
	private final Time time;
	
	public Time getTime() {
		return time;
	}

		
	public Wait(String time, String originalString) {
		super(originalString);
		this.time = ParseUtils.parseObject(Time.class, time);
		
	}

	

}
