package Ships;

import Game.*;

/* 
 * Carrier is one of the five ships on each side.
 * This class is a sub class of Ship.
*/ 
public class Carrier extends Ship 
{
	private final String SHIP_NAME = "Carrier";
    private final int SHIP_SIZE = 5;
    private final char ID = 'C';
    
    //Constructor with no parameter.
    public Carrier() 
    {
    	super();
    	shipName = SHIP_NAME;
    	shipSize = SHIP_SIZE;
    }
    
    /* 
     * Constructor with parameters: 
     * 1) Start tile, 2) End tile and 3) player.
    */ 
	public Carrier( Tile a, Tile b, String player)
	{	
		super(a, b, player);
	    shipName = SHIP_NAME;
	    this.shipSize = SHIP_SIZE;
	    this.id = ID;
	}
}