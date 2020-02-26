package Game;

//import Ships.Ship;

public class Tile {
	
	/* 
	Instance variables:
	X- and Y- coordinates of one tile on the battleship board 
	*/
	private int x; 
	private int y;
	
	// Constructor with no argument.
	public Tile()
	{
		this.x=0;
		this.y=0;
	}
	
	// Constructor with values of X- and Y- coordinates
	public Tile(int x, int y) 
	{ 
	    //this.setPiece(piece); 
	    this.x=x;
	    this.y=y;		
	} 
	
	/* 
	User inputs of the coordinates in the form of number pairs x,y are taken in.
	X- and Y- coordinates are then seperated.
	*/
	public Tile createLocation(String input) 
	{
	    int row = Integer.parseInt(input.split(",")[0].trim());
	    int col = Integer.parseInt(input.split(",")[1].trim());
	    return new Tile(row, col);
	}
	
	// The following methods are getters and setters for X- and Y- coordinates.
	public int getX() 
	{ 
	    return this.x; 
	}
	
	public void setX(int x) 
	{ 
	    this.x = x; 
	} 
	
	public int getY() 
	{ 
	    return this.y; 
	} 
	
	public void setY(int y) 
	{ 
	    this.y = y; 
	}	
}
	    
	   /* @Override
	    public boolean equals(Object obj) {
	        if (obj != null && obj instanceof Tile) {
	            Tile l = (Tile) obj;
	            return (x == l.getX() &&
	                    y == l.getY());
	        }
	        return false;
	    }*/


	   /* public Ship getPiece() 
	    { 
	        return this.piece; 
	    } 
	  
	    public void setPiece(Ship p) 
	    { 
	        this.piece = p; 
	    } 
	  */
