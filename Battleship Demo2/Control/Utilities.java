package Control;

import Game.Board;
import Player.Turn;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

//import Ships.*;

public class Utilities {
	
	private Board board = new Board();
	//private Turn turn = new Turn();
	
	public void intro() {
		
	    board.printBoard();
	}
	
	public void end(int humanShip, int computerShip,GridPane grid,Turn turn) {
String endMsg = "";
		
		if ( computerShip<=0) {
			endMsg = "Human player won! All computer's ships have been sunken.";
		}else if (humanShip<=0) {
			endMsg = "Computer player won! All human's ships have been sunken.";
		}else if (humanShip == computerShip) {
			endMsg = "Both players are winners! Both players' ships have been sunken.";
		}
		else
		{
			endMsg = "HumanShip: "+humanShip+" ComputerShip: "+computerShip;
		}
		
	
	    turn.nullify(grid);	
    	Alert badGrade = new Alert(AlertType.INFORMATION);
		badGrade.setTitle("Game Over");
		badGrade.setHeaderText(endMsg);
		//badGrade.showAndWait();
		Platform.runLater(badGrade::showAndWait);
	   
	}
}
