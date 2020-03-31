package Ships;

import java.util.ArrayList;

import Game.Board;
import Game.Tile;

/**
 * This class is an abstract class of core game entity, ship.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 3.3: Improved GUI and AI. March 2020
 */
public abstract class Ship {

	// Instance variables
	protected String shipName;
	protected int shipSize;
	protected String player;
	protected Tile tile;
	protected Tile startTile;
	protected Tile endTile;
	protected Board b = new Board();
	protected ArrayList<Tile> coordList = new ArrayList<Tile>(shipSize);

	/**
	 * Constructor with no parameter.
	 * 
	 * @Constructor
	 */
	public Ship() {
	}

	/**
	 * Constructor with 3 parameter, start and end Tiles and player.
	 * 
	 * @Constructor
	 */
	public Ship(Tile startTile, Tile endTile, String player) {
		super();
		this.player = player;
		this.startTile = startTile;
		this.endTile = endTile;
	}

	/**
	 * The following 2 methods add and remove Tile from the Ship arrayList.
	 * 
	 * @param coord
	 */
	public void addCoord(Tile coord) {
		this.coordList.add(new Tile(coord));
	}

	public void removeCoord(Tile coord) {
		this.coordList.remove(new Tile(coord));
	}

	/**
	 * Setter methods for each individual instance variable.
	 * 
	 * @param startTile, endTile, shipName, shipSize, Tile, player, coordList
	 */
	public void setStartTile(Tile startTile) {
		this.startTile = new Tile(startTile);
	}

	public void setEndTile(Tile endTile) {
		this.endTile = new Tile(endTile);
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public void setShipSize(int shipSize) {
		this.shipSize = shipSize;
	}

	public void setTile(Tile tile) {
		this.tile = new Tile(tile);
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	/**
	 * Getter methods for each individual instance variable.
	 * 
	 * @return startTile, endTile, shipName, shipSize, Tile, id, player, coordList
	 */
	public Tile getStartTile() {
		return startTile;
	}

	public Tile getEndTile() {
		return endTile;
	}

	public String getShipName() {
		return shipName;
	}

	public int getShipSize() {
		return shipSize;
	}

	public Tile getTile() {
		return tile;
	}

	public String getPlayer() {
		return player;
	}

	public ArrayList<Tile> getCoordList() {
		ArrayList<Tile> cloneAL = new ArrayList<Tile>();
		for (Tile tile : this.coordList) {
			cloneAL.add(new Tile(tile));
		}
		return cloneAL;
	}
}
