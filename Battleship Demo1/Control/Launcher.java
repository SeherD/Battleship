package Control;

import Player.Turn;

import Control.Utilities;

/* 
This class controls the general flow of the game as the following:
Intro message -> user places the ships -> computer places the ships -> Shoot at each others' ships
-> switch turns until one side's ships are all sunken -> End message.
*/
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
