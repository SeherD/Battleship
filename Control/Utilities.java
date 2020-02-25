package Control;

import Game.Board;

//import Player.Turn;

//import Ships.*;

public class Utilities {
	
	private Board board = new Board();
	//private Turn turn = new Turn();
	
	public void intro() {
		System.out.println("\t\t\t*****************************************");
	    System.out.println("\t\t\t**     WELCOME TO BATTLESHIP GAME!!    **");
	    System.out.println("\t\t\t**  (Presented by Tutorial 2 Group 6)  **");
	    System.out.println("\t\t\t*****************************************\n");
	    System.out.println("\t\t\tAt the moment, there is no ship in the see.\n");
	    board.printBoard();
	}
	
	public void end(int humanShip, int computerShip) {
		if (humanShip > computerShip) {
			System.out.println("Human player won! All computer's ships have been sunken.");
		}else if (humanShip < computerShip) {
			System.out.println("Computer player won! All human's ships have been sunken.");
		}else if (humanShip == computerShip) {
			System.out.println("Both players are winners! Both players' ships have been sunken.");
		}
		
		System.out.println("\t\t\t*******************************************");
	    System.out.println("\t\t\t** GAME HAS ENDED. WELCOME TO PLAY AGAIN **");
	    System.out.println("\t\t\t**   (Presented by Tutorial 2 Group 6)   **");
	    System.out.println("\t\t\t*******************************************");
	}
}
