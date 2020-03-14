
package Control;

import Game.Board;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import Player.Turn;

//import Ships.*;

/**
 * This class provides messages to the user, including:
 * 		inro and end messgaes in the console and win information box on GUI.
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.21: GUI March 2020
 */
public class Utilities {

	private Board board = new Board();

	/**
	 * This method prints into messages to the console.
	 */
	public void intro() {
		System.out.println("\t\t\t*****************************************");
		System.out.println("\t\t\t**     WELCOME TO BATTLESHIP GAME!!    **");
		System.out.println("\t\t\t**  (Presented by Tutorial 2 Group 6)  **");
		System.out.println("\t\t\t*****************************************\n");
		System.out.println("\t\t\tAt the moment, there is no ship in the sea.\n");
		board.printBoard();
	}
	/**
	 * This method prints the end message in the console.
	 * @param humanShip human's remaining ship Tiles
	 * @param computerShip computer's remaining ship Tiles
	 * @param grid JavaFX'ss gridPane
	 * @param turn Logic code's Turn
	 */
	public void end(int humanShip, int computerShip, GridPane grid, Turn turn) {
		String endMsg = "";
		if (computerShip == 0) {
			endMsg = "Human player won! All computer's ships have been sunken.";
		} else if (humanShip == 0) {
			endMsg = "Computer player won! All human's ships have been sunken.";
		} else if (humanShip == computerShip) {
			endMsg = "Both players are winners! Both players' ships have been sunken.";
		}
		System.out.println(endMsg);
		System.out.println("\t\t\t*******************************************");
		System.out.println("\t\t\t** GAME HAS ENDED. WELCOME TO PLAY AGAIN **");
		System.out.println("\t\t\t**   (Presented by Tutorial 2 Group 6)   **");
		System.out.println("\t\t\t*******************************************");
		turn.nullify(grid);

		// Info box pop up is displayed on GUI once the game ends.
		Alert badGrade = new Alert(AlertType.INFORMATION);
		badGrade.setTitle("Game Over");
		badGrade.setHeaderText(endMsg);
		badGrade.showAndWait();
	}
}
