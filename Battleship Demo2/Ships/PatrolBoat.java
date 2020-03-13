package Ships;

import Game.*;

/* 
 * Patrol boat is one of the five ships on each side.
 * This class is a sub class of Ship.
*/ 
public class PatrolBoat extends Ship 
{
    private final String SHIP_NAME = "PatrolBoat";
    private final int SHIP_SIZE = 2;
    private final char ID = 'P';
    
    //Constructor with no parameter.
    public PatrolBoat() 
    {
	super();
	shipName = SHIP_NAME;
    	shipSize = SHIP_SIZE;
    	id = ID;
    }
    
    public PatrolBoat(Tile a, Tile b, String player)
	{	
		super(a, b, player);
	    shipName = SHIP_NAME;
	    this.shipSize = SHIP_SIZE;
	    this.id = ID;
	}
}
