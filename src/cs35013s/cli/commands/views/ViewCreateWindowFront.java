/**
 * 
 */
package cs35013s.cli.commands.views;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;
import cs35013s.datatype.Altitude;
import cs35013s.datatype.Longitude;

/**
 * @author Cord
 */
public class ViewCreateWindowFront extends A_Command {
	
	private AgentID m_ID;
	private int m_Size;
	private Longitude m_CenterLong, m_HorzExtentLong, m_GridSpacingLong;
	private Altitude m_CenterAlt, m_VertExtentAlt, m_GridSpacingAboveAlt, m_GridSpacingBelowAlt;
	
	public ViewCreateWindowFront(String id, String size,
								String center_long, String horz_extent_long, String grid_spacing_long,
								String center_alt,  String vert_extent_alt,  String above_water_grid_spacing_alt,
								String below_water_grid_spacing_alt, String originalString) {
		
		super(originalString);
		
		m_ID = ParseUtils.parseObject(AgentID.class, id);
		m_Size = Integer.parseInt(size);
		
		m_CenterLong = ParseUtils.parseObject(Longitude.class, center_long);
		m_HorzExtentLong = ParseUtils.parseObject(Longitude.class, horz_extent_long);
		m_GridSpacingLong = ParseUtils.parseObject(Longitude.class, grid_spacing_long);
		
		m_CenterAlt = ParseUtils.parseObject(Altitude.class, center_alt);
		m_VertExtentAlt = ParseUtils.parseObject(Altitude.class, vert_extent_alt);
		m_GridSpacingAboveAlt = ParseUtils.parseObject(Altitude.class, above_water_grid_spacing_alt);
		m_GridSpacingBelowAlt = ParseUtils.parseObject(Altitude.class, below_water_grid_spacing_alt);
	}

	public AgentID getID() {
		return m_ID;
	}

	public int getSize() {
		return m_Size;
	}

	public Longitude getCenterLong() {
		return m_CenterLong;
	}

	public Longitude getHorzExtentLong() {
		return m_HorzExtentLong;
	}

	public Longitude getGridSpacingLong() {
		return m_GridSpacingLong;
	}

	public Altitude getCenterAlt() {
		return m_CenterAlt;
	}

	public Altitude getVertExtentAlt() {
		return m_VertExtentAlt;
	}

	public Altitude getGridSpacingAboveAlt() {
		return m_GridSpacingAboveAlt;
	}

	public Altitude getGridSpacingBelowAlt() {
		return m_GridSpacingBelowAlt;
	}
}
