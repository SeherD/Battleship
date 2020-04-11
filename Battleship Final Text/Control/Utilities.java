package Control;

import Game.Board;

/**
 * This class provides messages to the user, including: inro and end messgaes in console.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.2: Final Text-based Version
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
		System.out.println("\t\t\tAt the moment, there is no ship in the see.\n");
		board.printBoard();
	}

	/**
	 * This method prints the end message in the console.
	 * 
	 * @param humanShip human's remaining ship Tiles
	 * @param computerShip computer's remaining ship Tiles
	 */
	public void end(int humanShip, int computerShip) {
		
		// Based on the game status, win/lose messages are printed.
		if (humanShip > computerShip) {
			System.out.println("Human player won! All computer's ships have been sunken.");
		} else if (humanShip < computerShip) {
			System.out.println("Computer player won! All human's ships have been sunken.");
		} else if (humanShip == computerShip) {
			System.out.println("Both players are winners! Both players' ships have been sunken.");
		}

		System.out.println("\t\t\t*******************************************");
		System.out.println("\t\t\t** GAME HAS ENDED. WELCOME TO PLAY AGAIN **");
		System.out.println("\t\t\t**   (Presented by Tutorial 2 Group 6)   **");
		System.out.println("\t\t\t*******************************************");
	}
}
