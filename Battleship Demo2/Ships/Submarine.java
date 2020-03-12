package Ships;

import Game.Tile;

/* 
 * Submarine is one of the five ships on each side.
 * This class is a sub class of Ship.
*/ 
public class Submarine extends Ship 
{
	private final String SHIP_NAME = "Submarine";
    private final int SHIP_SIZE = 3;
    private final char ID = 'S';
    
    //Constructor with no parameter.
    public Submarine() 
    {
    	super();
    	shipName = SHIP_NAME;
    	shipSize = SHIP_SIZE;
    	id = ID;
    }
    
    /* 
     * Constructor with parameters: 
     * 1) Start tile, 2) End tile and 3) player.
    */ 
	public Submarine(Tile a, Tile b, String player)
	{	
		super(a, b, player);
	    shipName = SHIP_NAME;
	    this.shipSize = SHIP_SIZE;
	    this.id = ID;
	}
	/*@Override
	public String toString() {
		return "Submarine [SHIP_NAME=" + SHIP_NAME + ", SHIP_SIZE=" + SHIP_SIZE + ", ID=" + ID + ", startX=" + startX
				+ ", startY=" + startY + ", endX=" + endX + ", endY=" + endY + ", shipName=" + shipName + ", shipSize="
				+ shipSize + ", id=" + id + ", player=" + player + ", getStartX()=" + getStartX() + ", getStartY()="
				+ getStartY() + ", getEndX()=" + getEndX() + ", getEndY()=" + getEndY() + ", getShipName()="
				+ getShipName() + ", getShipSize()=" + getShipSize() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public static void main(String args[] ) {
		int x=1,y=1,z=1,w=1;
		String player="Human";
		Submarine s=new Submarine(x,y,z,w,player);
		System.out.println(s.toString());
	}*/

}
