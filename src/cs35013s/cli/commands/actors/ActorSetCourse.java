package cs35013s.cli.commands.actors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.*;

public class ActorSetCourse extends A_Command{
	private final AgentID id;

	private final Course course;
	
	public AgentID getId() {
		return id;
	}

	public Course getCourse() {
		return course;
	}

	public ActorSetCourse(String id, String course, String originalString) {
		super(originalString);
		
		this.id = ParseUtils.parseObject(AgentID.class, id);
		this.course = ParseUtils.parseObject(Course.class, course);
	}

}
