package Player;

import Game.Board;
import javafx.scene.control.Button;

// This class uses the logic code's 2D array elements' values for button clicks
public class TurnGui {
	private Board b=new Board();
	
	public void humanTurn(int x,int y, Button button) {
	
		// When the target tile is empty.
		if (b.getBoard2()[x][y] == 0) 
		{	button.setStyle("-fx-background-color: blue;");
			System.out.println("You missed!");
			//System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 4);
		} 
		// When the target tile is a ship Tile.
		else if (b.getBoard2()[x][y] == 2)
		{	button.setStyle("-fx-background-color: red;");
			System.out.println("You hit the computer's ship!");
			//System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 3);
			//computerShipsRemaining -= 1;
		}
		// When the tile has been shot at.
		else if (b.getBoard2()[x][y] == 3||b.getBoard2()[x][y] == 4)
		{	
			System.out.println("You have already shot here");
		}
			
			/* Assuming each ship has an ArrayList of all the tiles consisted by the ship.
			 * If: All the coordinate in the ArrayList have been marked as hit
			 *     (Whenever a ship's hit time becomes the same as its size, mark the coordinate to *3*)
			 * Then: Reduce the number of the computer's remaining ship.
			 */
				//this.computerShipsRemaining -= 1;
		// b.printBoard();
		} 

}
