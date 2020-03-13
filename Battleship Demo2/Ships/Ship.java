package Ships;

import java.util.ArrayList;

import Game.Board;
import Game.Tile;

// This is a abstract parent class for all the ships.
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
	protected ArrayList<Tile> coordList= new ArrayList<Tile> (shipSize);
	//Tuple t=new Tuple(double, int, int);
	
	/*
	public ArrayList<Integer> getLocation()
	{
		return location;
	}
	
	public void setLocation(int location)
	{
		this.location.add(location);
	}
	*/
	
	public Ship() {}
	
	public Ship(Tile startTile, Tile endTile, String player) 
	{
		super();
		this.player = player;
		this.startTile = startTile;
		this.endTile = endTile;
	}
	
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
	
	public String getShipName()
	{
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
	
	public char getId()
	{
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
	
	public ArrayList<Tile> getCoordList()
	{
		return coordList;
	}
	
	public void setCoordList(ArrayList<Tile> coordList)
	{
		this.coordList = coordList;
	}
	
	public void addCoord(Tile coord)
	{
		this.coordList.add(new Tile(coord));
	}
	
	public void removeCoord(Tile coord)
	{
		this.coordList.remove(new Tile(coord));
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
}
