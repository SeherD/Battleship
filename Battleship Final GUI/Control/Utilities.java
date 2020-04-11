package Control;

import Game.Board;
import Player.Turn;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

/**
 * This class provides messages to the user, including: inro and end messgaes in
 * the console and win information box on GUI.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 4.2: Final GUI version. April 2020.
 */
public class Utilities {

	private Board board = new Board();
	// private Turn turn = new Turn();

	public void intro() {

		board.printBoard();
	}

	/**
	 * This method prints the end message in the console.
	 * 
	 * @param humanShip    human's remaining ship Tiles
	 * @param computerShip computer's remaining ship Tiles
	 * @param grid         JavaFX'ss gridPane
	 * @param turn         Logic code's Turn
	 */
	public void end(int humanShip, int computerShip, GridPane grid, Turn turn) {
		
		// End messages are formed based on the win status.
		String endMsg = "";
		if (computerShip <= 0) {
			endMsg = "Human player won! All computer's ships have been sunken.";
		} else if (humanShip <= 0) {
			endMsg = "Computer player won! All human's ships have been sunken.";
		} else if (humanShip == computerShip) {
			endMsg = "Both players are winners! Both players' ships have been sunken.";
		} else {
			endMsg = "HumanShip: " + humanShip + " ComputerShip: " + computerShip;
		}
		
		// Info box pop up is displayed on GUI once the game ends.
		turn.nullify(grid);
		Alert badGrade = new Alert(AlertType.INFORMATION);
		badGrade.setTitle("Game Over");
		badGrade.setHeaderText(endMsg);
		// badGrade.showAndWait();
		Platform.runLater(badGrade::showAndWait);

	}
}
