package cs35013s.cli.commands.views;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;
import cs35013s.datatype.Altitude;
import cs35013s.datatype.Latitude;

/**
 * @author Cord
 */
public class ViewCreateWindowSide  extends A_Command{
	
	private AgentID m_ID;
	private int m_Size;
	private Latitude m_CenterLat, m_VertExtentLat, m_GridSpacingLat;
	private Altitude m_CenterAlt, m_VertExtentAlt, m_GridSpacingAboveAlt, m_GridSpacingBelowAlt;
	

	public ViewCreateWindowSide(String id, String size,
			String center_lat, String vert_extent_lat, String grid_spacing_lat,
			String center_alt,  String vert_extent_alt,  String above_water_grid_spacing_alt,
			String below_water_grid_spacing_alt, String originalString) {
		
		super(originalString);
		
		m_ID = ParseUtils.parseObject(AgentID.class, id);
		m_Size = Integer.parseInt(size);
		
		m_CenterLat = ParseUtils.parseObject(Latitude.class, center_lat);
		m_VertExtentLat = ParseUtils.parseObject(Latitude.class, vert_extent_lat);
		m_GridSpacingLat = ParseUtils.parseObject(Latitude.class, grid_spacing_lat);
		
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


	public Latitude getCenterLat() {
		return m_CenterLat;
	}


	public Latitude getVertExtentLat() {
		return m_VertExtentLat;
	}


	public Latitude getGridSpacingLat() {
		return m_GridSpacingLat;
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
