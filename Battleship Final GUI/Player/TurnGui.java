package Player;

import Game.Board;
import javafx.scene.control.Button;

/**
 * This class provides feedbacks to the user upon button clicks.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 4.2: Final GUI version. April 2020.
 */
public class TurnGui {

	// Instance variable
	private Board b = new Board();

	/**
	 * This method changes the colour of the button clicked or provides feedbacks of missing.
	 * 
	 * @param x      Row of the Board
	 * @param y      Column of the Board
	 * @param button Buttons of the gridPane
	 */
	public void humanTurn(int x, int y, Button button) {

		// When the target tile is empty.
		if (b.getBoard2()[x][y] == 0) {
			button.setStyle("-fx-background-color: blue;");
			System.out.println("You missed!");
			// System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 4);
		}
		// When the target tile is a ship Tile.
		else if (b.getBoard2()[x][y] == 2) {
			button.setStyle("-fx-background-color: red;");
			System.out.println("You hit the computer's ship!");
			// System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 3);
			// computerShipsRemaining -= 1;
		}
		// When the tile has been shot at.
		else if (b.getBoard2()[x][y] == 3 || b.getBoard2()[x][y] == 4) {
			System.out.println("You have already shot here");
		}
	}
}
