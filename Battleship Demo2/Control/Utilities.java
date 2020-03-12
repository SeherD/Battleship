package Control;

import Game.Board;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import Player.Turn;

//import Ships.*;

public class Utilities {
	
	private Board board = new Board();
	//private Turn turn = new Turn();
	
	public void intro() {
		System.out.println("\t\t\t*****************************************");
	    System.out.println("\t\t\t**     WELCOME TO BATTLESHIP GAME!!    **");
	    System.out.println("\t\t\t**  (Presented by Tutorial 2 Group 6)  **");
	    System.out.println("\t\t\t*****************************************\n");
	    System.out.println("\t\t\tAt the moment, there is no ship in the sea.\n");
	    board.printBoard();
	}
	
	public void end(int humanShip, int computerShip,GridPane grid,Turn turn) {
String endMsg = "";
		
		if ( computerShip==0) {
			endMsg = "Human player won! All computer's ships have been sunken.";
		}else if (humanShip==0) {
			endMsg = "Computer player won! All human's ships have been sunken.";
		}else if (humanShip == computerShip) {
			endMsg = "Both players are winners! Both players' ships have been sunken.";
		}
		
		System.out.println(endMsg);
		
		System.out.println("\t\t\t*******************************************");
	    	System.out.println("\t\t\t** GAME HAS ENDED. WELCOME TO PLAY AGAIN **");
	    	System.out.println("\t\t\t**   (Presented by Tutorial 2 Group 6)   **");
	    	System.out.println("\t\t\t*******************************************");
	    turn.nullify(grid);	
    	Alert badGrade = new Alert(AlertType.INFORMATION);
		badGrade.setTitle("Game Over");
		badGrade.setHeaderText(endMsg);
		badGrade.showAndWait();
	   
	}
}
