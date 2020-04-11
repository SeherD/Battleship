package Game;

/**
 * This class forms the boards.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.2: Final Text-based Version
 */
public class Board {
	
	// Two 2D arrays as Boards.
	private int[][] board1, board2;

	/**
	 * Constructor Creates 10x10 boards for human and computer
	 * 
	 * @Constructor
	 */
	public Board() {
		int x = 10;
		board1 = new int[x][x];
		board2 = new int[x][x];
	}

	/**
	 * Setter methods for both Boards.
	 * 
	 * @param i row of the 2D array and Board
	 * @param j column of the 2D array and Board
	 * @param value value of the element of 2D array
	 */
	public void setBoard1(int i, int j, int value) {
		this.board1[i][j] = value;
	}

	public void setBoard2(int i, int j, int value) {
		this.board2[i][j] = value;
	}

	/**
	 * Getter methods for both Boards.
	 * 
	 * @return both Boards
	 */
	public int[][] getBoard1() {
		return board1.clone();
	}

	public int[][] getBoard2() {
		return board2.clone();
	}

	/**
	 * Setter for Computer Board Takes start and end tiles for ships and places the
	 * ships Populates the area around the ships as empty sea
	 * 
	 * @param t1 start Tile
	 * @param t2 end Tile
	 */
	public void setBoardComputer(Tile t1, Tile t2) {

		{
			if (t1.getX() == t2.getX())
				for (int i = t1.getY(); i < t2.getY(); i++)
					setBoard2(t1.getX(), i, 2);

			else if (t1.getY() == t2.getY())
				for (int i = t1.getX(); i < t2.getX(); i++)
					setBoard2(i, t1.getY(), 2);
		}

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)

				if (getBoard2()[i][j] != 1 && getBoard2()[i][j] != 2)
					setBoard2(i, j, 0);
	}

	/**
	 * Setter for Human Board Takes start and end tiles for ships and places the
	 * ships Populates the area around the ships as empty sea
	 * 
	 * @param t1 start Tile
	 * @param t2 end Tile
	 */
	public void setBoardHuman(Tile t1, Tile t2) {
		if (t1.getX() == t2.getX()) {
			if (t1.getY() < t2.getY())
				for (int i = t1.getY(); i < t2.getY(); i++)
					setBoard1(t1.getX(), i, 1);
			else if (t1.getY() > t2.getY())
				for (int i = t2.getY(); i < t1.getY(); i++)
					setBoard1(t1.getX(), i, 1);
		}

		if (t1.getY() == t2.getY()) {
			if (t1.getX() < t2.getX())
				for (int i = t1.getX(); i < t2.getX(); i++)
					setBoard1(i, t1.getY(), 1);
			else if (t1.getX() > t2.getX())
				for (int i = t2.getX(); i < t1.getX(); i++)
					setBoard1(i, t1.getY(), 1);
		}

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				if (getBoard1()[i][j] != 1 && getBoard1()[i][j] != 2)
					setBoard1(i, j, 0);
			}
	}

	/**
	 * This method determines if the the location of Tile is in bounds.
	 * 
	 * @param location Tile's location in coordinates
	 * @return whether the Tile location is in bounds.
	 */
	public boolean inBounds(Tile location) {
		if (location.getX() >= 0 && location.getX() < 10 && location.getY() >= 0 && location.getY() < 10)
			return true;
		else
			return false;
	}

	/*
	 * Legend: 0 - empty location 1 - Player's ship - print (@) 2 - Computer's ship.
	 * 3 - Sunk computer ship - print (!) 4 - Sunk player's ship - print (x) 5 -
	 * Player missed - print (-) 8 - Computer missed 9 - Both player and computer
	 * missed this spot - print (-)
	 */

	/**
	 * This method prints the board to the console. This method is called when an
	 * update of board needs to be presented.
	 */
	public void printBoard() {
		System.out.println("     0  1  2  3  4  5  6  7  8  9 \t\t     0  1  2  3  4  5  6  7  8  9  ");
		System.out.println("     -----------------------------\t\t     -----------------------------");
		// Each value of the 2D array element is evaluated based on the legend above.
		for (int i = 0; i < 10; i++) {
			// print instead of println, so each element is printed on the same line.
			System.out.print(i + " |  ");
			for (int j = 0; j < 10; j++) {
				if (getBoard1()[i][j] == 0)
					System.out.print(" " + "  ");
				if (getBoard1()[i][j] == 1)
					System.out.print("#" + "  ");
				if (getBoard1()[i][j] == 3)
					System.out.print("!" + "  ");
				if (getBoard1()[i][j] == 4)
					System.out.print("~" + "  ");
				if (getBoard1()[i][j] == 5)
					System.out.print(" " + "  ");
				if (j == 9)
					System.out.print(" | " + i);
			}
			System.out.print("\t \t");
			System.out.print(i + " |  ");
			for (int k = 0; k < 10; k++) {
				if (getBoard2()[i][k] == 0)
					System.out.print(" " + "  ");
				if (getBoard2()[i][k] == 2)
					System.out.print("@" + "  ");
				if (getBoard2()[i][k] == 3)
					System.out.print("!" + "  ");
				if (getBoard2()[i][k] == 4)
					System.out.print("~" + "  ");
				if (getBoard2()[i][k] == 5)
					System.out.print(" " + "  ");
				if (k == 9)
					System.out.print(" | " + i);
			}
			System.out.println();
		}
		System.out.println("     -----------------------------\t\t     -----------------------------");
		System.out.println("     0  1  2  3  4  5  6  7  8  9 \t\t     0  1  2  3  4  5  6  7  8  9  ");
		System.out.println("             Human Board          \t\t             Computer Board ");
	}
}