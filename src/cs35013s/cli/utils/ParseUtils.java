package cs35013s.cli.utils;

import cs35013s.datatype.AgentID;
import cs35013s.datatype.Altitude;
import cs35013s.datatype.AngleNavigational;
import cs35013s.datatype.AttitudePitch;
import cs35013s.datatype.AttitudeYaw;
import cs35013s.datatype.CoordinateWorld3D;
import cs35013s.datatype.Course;
import cs35013s.datatype.DistanceNauticalMiles;
import cs35013s.datatype.E_DirectionView;
import cs35013s.datatype.FieldOfView;
import cs35013s.datatype.Groundspeed;
import cs35013s.datatype.Latitude;
import cs35013s.datatype.Longitude;
import cs35013s.datatype.Power;
import cs35013s.datatype.Sensitivity;
import cs35013s.datatype.Time;

/**
 * Valuable helper functions to speed up parsing of data from command strings.
 * @author Cord
 *
 */
public class ParseUtils {
	
	@SuppressWarnings("unchecked")
	/**
	 * Given a data string, this will parse the desired datatype object from it.
	 * Extremely useful when constructing command objects.
	 * 
	 * Check out ViewCreateWindowFront.java for example usage.
	 * I promise you will _love_ this function.
	 * 
	 * ~cord
	 *  
	 * @param desired_type Class type to return. Example: Longitude.class
	 * @param data_string Data string to extract the class object from. Example (longitude): "1*2"3'"
	 * @return a constructed object from the data_string of the desired class 
	 */
	public static <T> T parseObject(Class<T> desired_type, String data_string) {
		T object = null;
		
		if (desired_type.equals(Altitude.class))
			object = (T) new Altitude(Integer.parseInt(data_string));
		else if (desired_type.equals(AttitudeYaw.class))
			object = (T) new AttitudeYaw(Double.parseDouble(data_string));
		else if (desired_type.equals(CoordinateWorld3D.class)) {
			String[] blocks = data_string.split("/", 3); // recursive parsing = bad ass.
			object = (T) new CoordinateWorld3D( parseObject(Latitude.class, blocks[0]), parseObject(Longitude.class, blocks[1]), parseObject(Altitude.class, blocks[2]));
		} else if (desired_type.equals(Course.class))
			object = (T) new Course(Integer.parseInt(data_string));
		else if (desired_type.equals(E_DirectionView.class)) {
			if (data_string.equals("top"))
				object = (T) E_DirectionView.TOP;
			else if (data_string.equals("front"))
				object = (T) E_DirectionView.FRONT;
			else
				object = (T) E_DirectionView.SIDE;
		} else if (desired_type.equals(DistanceNauticalMiles.class))
			object = (T) new DistanceNauticalMiles(Double.parseDouble(data_string));
		else if (desired_type.equals(AttitudePitch.class))
			object = (T) new AttitudePitch(Double.parseDouble(data_string));
		else if (desired_type.equals(FieldOfView.class))
			object = (T) new FieldOfView(new AngleNavigational(Double.parseDouble(data_string)));
		else if (desired_type.equals(AgentID.class))
			object = (T) new AgentID(data_string);
		else if (desired_type.equals(Latitude.class))
			object = (T) new Latitude(parseHour(data_string), parseMinute(data_string), parseSecond(data_string));
		else if (desired_type.equals(Longitude.class))
			object = (T) new Longitude(parseHour(data_string), parseMinute(data_string), parseSecond(data_string));
		else if (desired_type.equals(Power.class))
			object = (T) new Power(Double.parseDouble(data_string));
		else if (desired_type.equals(Sensitivity.class))
			object = (T) new Sensitivity(Double.parseDouble(data_string));
		else if (desired_type.equals(Groundspeed.class))
			object = (T) new Groundspeed(Double.parseDouble(data_string));
		else if (desired_type.equals(Time.class))
			object = (T) new Time(Double.parseDouble(data_string));
		
		if (object == null)
			throw new RuntimeException("Could not find this datatype to parse data string into: " + desired_type.getSimpleName());
		
		return object;
	}
	
	private static final int parseHour(String str) {
		return Integer.parseInt(str.substring(0, str.indexOf('*')));
	}
	
	private static final int parseMinute(String str) {
		return Integer.parseInt(str.substring(str.indexOf('*') + 1, str.indexOf('\'')));
	}
	
	private static final double parseSecond(String str) { 
		return Double.parseDouble(str.substring(str.indexOf('\'') + 1, str.length()-1));
	}
}
