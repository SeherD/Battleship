package Control;

import Player.Turn;


/**
 * This class launches the game and controls the general game flow as the following:
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.2: Final Text-based Version
 */
public class Launcher {
	
	/**
	 * This is the main of the program. The game flow is as follows:
	 * Intro->Human ship placement->AI ship placement->Human attack->Switch turns->AI attack->End
	 * 
	 * @MAIN
	 */
	public static void main(String args[]) 
	{
		Turn turn = new Turn();
		Utilities utilities = new Utilities();
		utilities.intro();
		turn.getUserShips();
		turn.getComputerShips();
		turn.switchTurns();
		utilities.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining());
	}
}
