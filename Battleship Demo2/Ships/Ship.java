package Ships;

import java.util.ArrayList;

import Game.Board;
import Game.Tile;

/**
 * This class is an abstract class of core game entity, ship.
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.21: GUI March 2020
 */
public abstract class Ship {
	
	// Instance variables
	protected String shipName;
	protected int shipSize;
	protected char id;
	protected String player;
	protected Tile tile;
	protected Tile startTile;
	protected Tile endTile;
	protected Board b = new Board();
	protected ArrayList<Tile> coordList = new ArrayList<Tile>(shipSize);
	
	/**
	 * Constructor with no parameter.
	 * @Constructor
	 */
	public Ship() {
	}
	/**
	 * Constructor with 3 parameter, start and end Tiles and player.
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
	 * @param startTile, endTile, shipName, shipSize, Tile, id, player, coordList
	 */
	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}
	public void setEndTile(Tile endTile) {
		this.endTile = endTile;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public void setShipSize(int shipSize) {
		this.shipSize = shipSize;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	public void setId(char id) {
		this.id = id;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public void setCoordList(ArrayList<Tile> coordList) {
		this.coordList = coordList;
	}
	/**
	 * Getter methods for each individual instance variable.
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
	public char getId() {
		return id;
	}
	public String getPlayer() {
		return player;
	}
	public ArrayList<Tile> getCoordList() {
		return coordList;
	}
}
	/*
	public void shoot(int x, int y)
	{
		location.remove(location.size()-1);
		location.remove(location.size()-1);
		for(int i=0;i<location.size()-1;i++)
		{	
			System.out.print(location.get(i)+",");
			if((i+1)<10)
			if(location.get(i)==x && location.get(i+1)==y)
				{
					location.remove(i);
					location.remove(i+1);
					System.out.println(shipName);
				}
		}
	}
	
	public boolean sink()
	{
		if(location.size()==0)
			{
				System.out.println(shipName+"sunk");
				return true;
			}
		return false;
	}
	*/
