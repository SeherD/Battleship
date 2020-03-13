package Ships;

import Game.Tile;

/* 
 * Destroyer is one of the five ships on each side.
 * This class is a sub class of Ship.
*/ 
public class Destroyer extends Ship
{
	private final String SHIP_NAME = "Destroyer";
	private final int SHIP_SIZE = 3;
	private final char ID = 'D';
	
	//Constructor with no parameter.
	public Destroyer() 
	{
    	    super();
    	    shipName = SHIP_NAME;
    	    shipSize = SHIP_SIZE;
    	    id = ID;
	}
	
	public Destroyer( Tile a, Tile b,String player)
	{	
		super(a, b, player);
		shipName = SHIP_NAME;
		this.shipSize = SHIP_SIZE;
		this.id = ID;	
	}
}
