package Control;

import Player.Turn;

import Control.Utilities;

public class Launcher {
	
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
