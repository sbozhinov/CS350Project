package cs35013s.cli.commands.actors;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;
import cs35013s.datatype.CoordinateWorld3D;
import cs35013s.datatype.Course;
import cs35013s.datatype.Groundspeed;

public class ActorCreate extends A_Command {
	private final AgentID id1;
	private final AgentID id2;
	private final Course course;
	private final CoordinateWorld3D coords;
	private final Groundspeed speed;
	
	public AgentID getId1() {
		return id1;
	}


	public AgentID getId2() {
		return id2;
	}


	public Course getCourse() {
		return course;
	}


	public CoordinateWorld3D getCoords() {
		return coords;
	}


	public Groundspeed getSpeed() {
		return speed;
	}


	public ActorCreate(String id1, String id2, String coords,
						String course, String speed, String originalString) {
		
		super(originalString);
		
				
		this.coords = ParseUtils.parseObject(CoordinateWorld3D.class, coords); 
		this.id1 = ParseUtils.parseObject(AgentID.class, id1);
		this.id2 = ParseUtils.parseObject(AgentID.class, id2);
		this.course = ParseUtils.parseObject(Course.class, course);
		this.speed = ParseUtils.parseObject(Groundspeed.class, speed);
	}


}
