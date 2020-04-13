package Game;

/**
 * This class processes the coordinates.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.2: Final Text-based Version
 */
public class Tile {

	// Instance variables.
	private int x;
	private int y;
	private String name = "error";

	/**
	 * Constructor with no argument.
	 * 
	 * @Constructor
	 */
	public Tile() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param toCopy Tile
	 */
	public Tile(Tile toCopy) {
		this.x = toCopy.x;
		this.y = toCopy.y;
	}

	/**
	 * Constructor with x and y as coordinates.
	 * 
	 * @param x Row of the Board
	 * @param y Column of the Board
	 */
	public Tile(int x, int y) {
		// this.setPiece(piece);
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor with 3 arguments, x, y and name.
	 * 
	 * @param x Row of the Board
	 * @param y Column of the Board
	 * @param name Ship's name
	 */
	public Tile(int x, int y, String name) {
		// this.setPiece(piece);
		this.x = x;
		this.y = y;
		this.name = name;
	}

	/**
	 * This method returns newly created Tile based on the user's input of x and y.
	 * 
	 * @param input User's console input
	 * @return Tile object with inputed x and y
	 */
	public Tile createLocation(String input) {
		int row = Integer.parseInt(input.split(",")[0].trim());
		int col = Integer.parseInt(input.split(",")[1].trim());
		return new Tile(row, col);
	}
	
	/**
	 * Getter methods for row, column and Ship's name.
	 * 
	 * @return x, y and name
	 */
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String getName() {
		return name;
	}

	/**
	 * Setter methods for row, column and name.
	 * 
	 * @param x, y and name
	 */
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setName(String name) {
		this.name = name;
	}
}
