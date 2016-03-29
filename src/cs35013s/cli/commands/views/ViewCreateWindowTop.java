/**
 * 
 */
package cs35013s.cli.commands.views;

import cs35013s.cli.commands.A_Command;
import cs35013s.cli.utils.ParseUtils;
import cs35013s.datatype.AgentID;
import cs35013s.datatype.Latitude;
import cs35013s.datatype.Longitude;

/**
 * @author Cord
 */
public class ViewCreateWindowTop  extends A_Command{
	
	private AgentID m_ID;
	private int m_Size;
	private Latitude m_CenterLat, m_VertExtentLat, m_GridSpacingLat;
	private Longitude m_CenterLong, m_HorzExtentLong, m_GridSpacingLong;
	
	public ViewCreateWindowTop(String id, String size, String center_lat,
			String vert_extent_lat, String grid_spacing_lat, String center_long,
			String horz_extent_long, String grid_spacing_long, String originalString) {
		super(originalString);
		
		m_ID = ParseUtils.parseObject(AgentID.class, id);
		m_Size = Integer.parseInt(size);
		
		m_CenterLat = ParseUtils.parseObject(Latitude.class, center_lat);
		m_VertExtentLat = ParseUtils.parseObject(Latitude.class, vert_extent_lat);
		m_GridSpacingLat = ParseUtils.parseObject(Latitude.class, grid_spacing_lat);
		
		m_CenterLong = ParseUtils.parseObject(Longitude.class, center_long);
		m_HorzExtentLong = ParseUtils.parseObject(Longitude.class, horz_extent_long);
		m_GridSpacingLong = ParseUtils.parseObject(Longitude.class, grid_spacing_long);
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

	public Longitude getCenterLong() {
		return m_CenterLong;
	}

	public Longitude getHorzExtentLong() {
		return m_HorzExtentLong;
	}

	public Longitude getGridSpacingLong() {
		return m_GridSpacingLong;
	}

	
}
