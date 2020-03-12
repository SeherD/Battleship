package Game;

//import Ships.Ship;

public class Tile {
	
	//private Ship piece; 
	private int x; 
	private int y;
	private String name = "error";
	
	// Constructor with no argument.
	public Tile()
	{
		this.x=0;
		this.y=0;
	}
	// Copy constructor.
	public Tile(Tile toCopy) {
		this.x = toCopy.x;
		this.y = toCopy.y;
	}
	// Constructor with x and y as coordinates.
	public Tile(int x, int y) 
	{ 
	    //this.setPiece(piece); 
	    this.x=x;
	    this.y=y;		
	}
	// Constructor with 3 arguments, x, y and name.
	public Tile(int x, int y, String name) 
	{ 
	    //this.setPiece(piece); 
	    this.x=x;
	    this.y=y;
	    this.name = name;
	} 
	
	public  Tile createLocation(String input) 
	{
	    int row = Integer.parseInt(input.split(",")[0].trim());
	    int col = Integer.parseInt(input.split(",")[1].trim());
	    return new Tile(row, col);
	}
	
	// The following methods are getters and setters for X and Y coordinates.
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
