package Player;

import Game.*; 

import java.util.*;

import Ships.*;

//import Control.Utilities;

public  class Turn {
	//attributes
	private Board b= new Board();
	private Scanner kb= new Scanner(System.in);
	private Tile t=new Tile();
	Ship ship1=new Carrier();
	Ship ship2=new Cruiser();
	Ship ship3=new Destroyer();
	Ship ship4=new Submarine();
	Ship ship5=new PatrolBoat();
	Ship ships[]= {ship1,ship2,ship3,ship4,ship5};
	private int computerShipsRemaining = 17;
	private int humanShipsRemaining = 17;
	
	//getters for computer and human ships
	public int getComputerShipsRemaining() {
		return computerShipsRemaining;
	}

	public int getHumanShipsRemaining() {
		return humanShipsRemaining;
	}
	//checks if tile is empty to avoid overlap
	public boolean isTileEmpty(Tile t) {
		return b.getBoard1()[t.getX()][t.getY()] == 0;}
	
	//checks if the space between two tiles is empty
	public boolean isMiddleEmpty(Tile t1, Tile t2) {
		
	    if (t1.getX()==t2.getX())
	   	   for (int i=t1.getY();i<t2.getY();i++)
	   		if (b.getBoard1()[t1.getX()][i]!=0)
	   		{System.out.println(b.getBoard1()[t1.getX()][i]!=0);
	   			return false;}
	   
	    if (t1.getY()==t2.getY())
		   	   for (int j=t1.getX();j<t2.getX();j++)
		   		if (b.getBoard1()[j][t1.getY()]!=0)
		   			return false;
	    return true;
	   
}
	//checks is the coordinates entered by the user are spaced correctly
	public boolean checkLength(Tile tile1, Tile tile2, Ship ship) {
		
		if (Math.abs(tile1.getX()-tile2.getX())==ship.getShipSize() && Math.abs(tile1.getY()-tile2.getY())==0)
			return true;
		else if ((Math.abs(tile1.getX()-tile2.getX())==0 && Math.abs(tile1.getY()-tile2.getY())==ship.getShipSize()))
			return true;
		return false;}
	
	//director function to get user ships
	public void getUserShips() {
		Tile tile1=new Tile();
		Tile tile2=new Tile();
		String player="Human";
		
		for (int i=0;i<5;i++)
			getInputShips(tile1, tile2,player,ships[i]) ;
		
		}
	//function that consists of a do while loop that prompts the user for start and end coordinates of the ships	
	public void getInputShips(Tile tile1,Tile tile2,String player,Ship ship) {
		do {try {
			do {
			System.out.println("Enter the start cordinates of the "+ship.getShipName()+" "+ship.getShipSize());
			String input=kb.nextLine();
			tile1=t.createLocation(input);
			if(!b.inBounds(tile1))
				System.out.println("Location not on board,try again");
			if(!isTileEmpty(tile1))
				System.out.println("Location not empty,try again");
		
			}while(!b.inBounds(tile1)||!isTileEmpty(tile1));
			do {
				System.out.println("Enter the end cordinates of the "+ship.getShipName()+" "+ship.getShipSize());
				String input=kb.nextLine();
				tile2=t.createLocation(input);
				if(!b.inBounds(tile2))
					System.out.println("Location not on board,try again");
				if(!isTileEmpty(tile2))
					System.out.println("Location not empty,try again");
			
			}while(!b.inBounds(tile2)||!isTileEmpty(tile2));
			
			
			if (checkLength(tile1, tile2,ship)) {
				
				//System.out.println(carrier.toString());
				b.setBoardHuman(tile1, tile2);
				b.printBoard();
				
			}
			else 
				System.out.println("Invalid , try again");}
		catch(Exception e) {
			System.out.println("TryAgain");
		}
		}while(!checkLength(tile1, tile2,ship));
	
		}
			
	//director function to get computer ships	
	public void getComputerShips() {
		Tile tile1=new Tile();
		Tile tile2=new Tile();
		String player="Computer";
		
		getInputComputer( tile1,tile2,player);
	}
	//function that randomizes the ships using cells to prevent overlap	
	public void getInputComputer(Tile tile1,Tile tile2,String player) {
		Random rand = new Random();
		Tile tile3 = new Tile();
		Tile tile4 = new Tile();
		int x,y,or;
		or = rand.nextInt(2);
		for (int i = 0; i < 5; i ++) {
			if (i == 0) {
			or = rand.nextInt(2);
				if ((int)or == 0) {
					x = 5;
					y = rand.nextInt(5) + 4;
					tile3.setX(x);
					tile3.setY((int)y);
					tile4.setX(tile3.getX() + ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				}
				if((int)or == 1) {
					x = rand.nextInt(5) + 5;
					y =5;
					tile3.setX((int)x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY() + ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);	
				}
			}
			
			
			if (i == 1) {
				or=rand.nextInt(2);
				if ((int)or == 0) {
					x = 0;
					y = rand.nextInt(4);
					tile3.setX(x);
					tile3.setY((int)y);
					tile4.setX(tile3.getX()+ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if((int)or==1) {
					x= rand.nextInt(4);
					y =0;
					tile3.setX((int)x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY()+ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);	
				}
			}
			
			
			if (i==2) {
				or=rand.nextInt(2);
				if ((int)or==0) {
					x= 0;
					y = rand.nextInt(1)+7;
					tile3.setX(x);
					tile3.setY((int)y);
					tile4.setX(tile3.getX()+ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if((int)or==1) {
					x= rand.nextInt(2);
					y =7;
					tile3.setX((int)x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY()+ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			
			
			if (i==3) {
				or=rand.nextInt(2);
				if ((int)or==0) {
					x= 7;
					y = rand.nextInt(1);
					tile3.setX(x);
					tile3.setY((int)y);
					tile4.setX(tile3.getX()+ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if((int)or==1) {
					x= rand.nextInt(2)+7;
					y =0;
					tile3.setX((int)x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY()+ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			
			
			if (i==4) {
				or=rand.nextInt(2);
				if ((int)or==0) {
					x= rand.nextInt(3);
					y =5 ;
					tile3.setX(x);
					tile3.setY((int)y);
					tile4.setX(tile3.getX()+ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if((int)or==1) {
					x=5;
					y =rand.nextInt(3);
					tile3.setX((int)x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY()+ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);	
				}
			}
		}
        b.printBoard();
    }
	//prompts the user for coordinates to shoot at
	public void humanTurn() {
		//Each side has 5 times of fires.
			Tile tile1=new Tile();
			//Scanner kb= new Scanner(System.in);
			//Utilities turnUtilities = new Utilities();
			
				do {
					System.out.println("Enter cordinates to shoot at");
					String input=kb.nextLine();
					tile1=t.createLocation(input);
					if(!b.inBounds(tile1))
						System.out.println("Location not on board,try again");
					
					}while(!b.inBounds(tile1));
				//User's input for x and y are needed.
				int x = tile1.getX();
				int y = tile1.getY();
				
				// Assuming elements in the 2D array have been marked according to the legend.
				// Compare the element in the array to the coordinate entered to see if it is a hit or miss.
				if (b.getBoard2()[x][y] == 0) 
				{
					System.out.println("You missed!");
					//System.out.println(b.getBoard2()[x][y]);
					b.setBoard2(x, y, 4);
				} 
				else if (b.getBoard2()[x][y] == 2)
				{
					System.out.println("You hit the computer's ship!");
					//System.out.println(b.getBoard2()[x][y]);
					b.setBoard2(x, y, 3);
					computerShipsRemaining -= 1;
				}
				else if (b.getBoard2()[x][y] == 3||b.getBoard2()[x][y] == 4)
				{
					System.out.println("You have already shot here");
				}
					
					/* Assuming each ship has an ArrayList of all the tiles consisted by the ship.
					 * If: All the coordinate in the ArrayList have been marked as hit
					 *     (Whenever a ship's hit time becomes the same as its size, mark the coordinate to *3*)
					 * Then: Reduce the number of the computer's remaining ship.
					 */
						//this.computerShipsRemaining -= 1;
				 b.printBoard();
				} 
	
	
	//prompts the computer for coordinates to shoot at		
	public void computerTurn() {
	//Each side has 5 times of fires.
		 
		//Random rand = new Random();
		int x ;
		int y ;
		ArrayList<Integer> numbers = new ArrayList<Integer>(0);
		//Utilities turnUtilities = new Utilities();
		
		for(int i = 0; i < 10; i++)
		{
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		//x = rand.nextInt(10);
		//y = rand.nextInt(10);	
		x=numbers.get(0);
		y=numbers.get(1);
		

		//System.out.println(x);System.out.println(y);
			//Computer's random input for x and y are needed.
			//x=(int)x;
			//y=(int)y;
			// Assuming elements in the 2D array have been marked according to the legend.
			// Compare the element in the array to the coordinate entered to see if it is a hit or miss.
		if (b.getBoard1()[x][y] == 0) 
		{
			System.out.println("Computer missed!");
			//System.out.println(b.getBoard1()[x][y]);
			b.setBoard1(x, y, 4);
		} 
		else if (b.getBoard1()[x][y] == 1)
		{
			System.out.println("Computer hit your ship!");
			//System.out.println(b.getBoard1()[x][y]);
			b.setBoard1(x, y, 3);
			
			humanShipsRemaining -= 1;
			
		}
		else if (b.getBoard1()[x][y] == 3||b.getBoard1()[x][y] == 4)
		{
			System.out.println("Computer has already shot here");
		}
			
			/* Assuming each ship has an ArrayList of all the tiles consisted by the ship.
			 * If: All the coordinate in the ArrayList have been marked as hit
			 *     (Whenever a ship's hit time becomes the same as its size, mark the coordinate to *4*)
			 * Then: Reduce the number of the player's remaining ship.
			 */
				//this.humanShipsRemaining -= 1;
		b.printBoard();
	}
	//controls switching of turns,alternating between user and computer till all ships are sunk  
	public void switchTurns() 
	{
		// Switch turns based on the number of remaining human and computer ships. 
		// The while loop stops when both side's numbers of remaining ships reach 0.
		while((computerShipsRemaining != 0) && (humanShipsRemaining != 0))
		{
			System.out.println("Your turn");
	        humanTurn();
	       
	        System.out.println("Computer's turn");
	        computerTurn();
	    }
	        //Present board after each side's turn
	}		
	/*	
	public static void main(String args[])
	{
		Turn a=new Turn();
		a.getUserShips();
		a.getComputerShips() ;
		a.switchTurns();
	}
	*/
}
