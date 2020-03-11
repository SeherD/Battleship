package Ships;

import Game.*;

// This is the abstract parent class for the 5 sub classes of different ships.
public abstract class Ship 
{
	protected String shipName;
	protected int shipSize;
	protected char id;
	protected String player;
	protected Tile tile;
	protected Tile startTile;
	protected Tile endTile;
	protected Board b = new Board();
	//blank default constructor
	public Ship() {}
	//parameterised constructor to intialise startTile, endTile,player
	public Ship(Tile startTile, Tile endTile, String player) 
	{
		super();
		this.player = player;
		this.startTile = startTile;
		this.endTile = endTile;
	}	
	//getters and setters for all the atributes of the class
	public Tile getStartTile() 
	{
		return startTile;
	}

	public void setStartTile(Tile startTile) 
	{
		this.startTile = startTile;
	}

	public Tile getEndTile() 
	{
		return endTile;
	}

	public void setEndTile(Tile endTile) 
	{
		this.endTile = endTile;
	}

	public String getShipName() {
		return shipName;
	}
	
	public void setShipName(String shipName) 
	{
		this.shipName = shipName;
	}
	
	public int getShipSize() 
	{
		return shipSize;
	}
	public void setShipSize(int shipSize) 
	{
		this.shipSize = shipSize;
	}
	
	public Tile getTile() 
	{
		return tile;
	}
	
	public void setTile(Tile tile) 
	{
		this.tile = tile;
	}
	
	public char getId() {
		return id;
	}
	
	public void setId(char id) 
	{
		this.id = id;
	}
	
	public String getPlayer() 
	{
		return player;
	}
	
	public void setPlayer(String player) 
	{
		this.player = player;
	}
}
