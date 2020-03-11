package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import Game.Board;
import Game.Tile;
import Ships.Carrier;
import Ships.Cruiser;
import Ships.Destroyer;
import Ships.PatrolBoat;
import Ships.Ship;
import Ships.Submarine;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

//import Control.Utilities;

public  class Turn {
	
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
	Ship humanCarrier=new Carrier();
	Ship humanCruiser=new Cruiser();
	Ship humanDestroyer=new Destroyer();
	Ship humanSubmarine=new Submarine();
	Ship humanPatrolBoat=new PatrolBoat();
Ship humanships[]= {humanCarrier,humanCruiser,humanDestroyer,humanSubmarine,humanPatrolBoat};
	
	Ship computerCarrier=new Carrier();
	Ship computerCruiser=new Cruiser();
	Ship computerDestroyer=new Destroyer();
	Ship computerSubmarine=new Submarine();
	Ship computerPatrolBoat=new PatrolBoat();
	Ship computerShips[]= {computerCarrier,computerCruiser,computerDestroyer,computerSubmarine,computerPatrolBoat};
	
	// All the ships start with full health.
	private int computerCarrierHealth = 5;
	private int computerCruiserHealth = 4;
	private int computerDestroyerHealth = 3;
	private int computerSubmarineHealth = 3;
	private int computerPatrolBoatHealth = 2;
	
	private int humanCarrierHealth = 5;
	private int humanCruiserHealth = 4;
	private int humanDestroyerHealth = 3;
	private int humanSubmarineHealth = 3;
	private int humanPatrolBoatHealth = 2;	
	
	private ArrayList<Tile> humanAllTiles = new ArrayList<Tile>(17);
	private ArrayList<Tile> computerAllTiles = new ArrayList<Tile>(17);
	private ArrayList<Tile> AI=new ArrayList<Tile>(4);
	private int AIx,AIy;
	private Label label1=new Label();
	private Label label2=new Label();
	private Label label3=new Label();
	private Label label4=new Label();
	private String labelString1="";
	private String labelString2="";
	public Label getLabel2() {
		return label2;
	}


	public Label getLabel3() {
		return label3;
	}


	public Label getLabel4() {
		return label4;
	}


	public Label getLabel1() {
		return label1;
	}

	
	public String tileBelongsTo(int x, int y, ArrayList<Tile> allTiles) {
		String shipName = "error";
		for (Tile tile: allTiles) {
			if (x == tile.getX() && y == tile.getY()) {
				shipName = tile.getName();
			}
		}
		return shipName;
	}
	
	public Ship[] getShipArray() {
		return ships;
	}
	public int getComputerShipsRemaining() {
		return computerShipsRemaining;
	}

	public int getHumanShipsRemaining() {
		return humanShipsRemaining;
	}

	public boolean middleEmptyH1(int x, int y , Ship ship) {
		boolean flag=true;
		for (int i=y;i<y+ship.getShipSize();i++)
			if (b.getBoard1()[x][i]!=0)
				flag= false;
		return flag;
	}
	public boolean middleEmptyH2(int x, int y , Ship ship) {
		boolean flag=true;
		for (int i=y;i>y-ship.getShipSize();i--)
			if (b.getBoard1()[x][i]!=0)
				flag= false;
		return flag;
	}	
	public boolean middleEmptyV1(int x, int y , Ship ship) {
		boolean flag=true;
		for (int i=x;i<x+ship.getShipSize();i++)
			if (b.getBoard1()[i][y]!=0)
				flag= false;
		return flag;
	}	
	public boolean middleEmptyV2(int x, int y , Ship ship) {
		boolean flag=true;
		for (int i=x;i>x-ship.getShipSize();i--)
			if (b.getBoard1()[i][y]!=0)
				flag= false;
		return flag;
	}	

	public void getComputerShips() {
		Tile tile1=new Tile();
		Tile tile2=new Tile();
		String player="Computer";
		
		getInputComputer( tile1,tile2,player);
	}
		
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
					b.setBoardComputer(tile3, tile4);}
				
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
			if (tile3.getX() == tile4.getX()) {
				for (int iy = tile3.getY(); iy < tile4.getY(); iy++) {
					Tile tile = new Tile(tile3.getX(),iy,computerShips[i].getShipName());
					System.out.println(tile3.getX()+","+iy);
					computerShips[i].addCoord(tile);
					computerAllTiles.add(tile);
				}
			}else if (tile3.getY() == tile4.getY()) {
				for (int ix = tile3.getX(); ix < tile4.getX(); ix++) {
					Tile tile = new Tile(ix,tile3.getY(),computerShips[i].getShipName());
					System.out.println(ix+","+tile3.getY());
					computerShips[i].addCoord(tile);
					computerAllTiles.add(tile);
				}
			}
			

			System.out.println(computerShips[i].getCoordList().size());
			System.out.println(computerShips[i].getShipName());
			System.out.println(computerAllTiles.size());
			
		}
		
        b.printBoard();
    }
	public boolean hship(int x,int y, Node node,GridPane grid,Ship ship)
	{ if (y<10-ship.getShipSize())
	{
		if(this.middleEmptyH1(x, y, ship))
		for (int i=y;i<y+ship.getShipSize();i++)
		{
			b.setBoard1(x,i,1);
		Node n=getNodeFromGridPane(grid , i, x);
		
		n.setStyle("-fx-background-color: black;");
		n.setOnMouseClicked(null);
		Tile tile = new Tile(x,i,ship.getShipName());
		System.out.println(x+","+i);
		ship.addCoord(tile);
		humanAllTiles.add(tile);}
	else
		{
		
		System.out.println("hship218");
		return false;
		}
	}
	
	if (y>10-ship.getShipSize())
		if(this.middleEmptyH2(x, y, ship))	
		for (int i=y;i>y-ship.getShipSize();i--)
		{b.setBoard1(x,i,1);
		Node n=getNodeFromGridPane(grid , i, x);
		n.setStyle("-fx-background-color: black;");
		n.setOnMouseClicked(null);
		Tile tile = new Tile(x,i,ship.getShipName());
		System.out.println(x+","+i);
		ship.addCoord(tile);
		humanAllTiles.add(tile);
		}
		else
		{
			
			System.out.println("hship235");
			return false;
			}
	
	
	
	b.printBoard();
	return true;}
	
	public boolean vship(int x,int y, Node node,GridPane grid,Ship ship)
	{
	
		if (x<10-ship.getShipSize())
			if(this.middleEmptyV1(x, y, ship))
		for (int i=x;i<x+ship.getShipSize();i++)
		{b.setBoard1(i,y,1);
		Node n=getNodeFromGridPane(grid , y, i);
		n.setStyle("-fx-background-color: black;");
		n.setOnMouseClicked(null);
		Tile tile = new Tile(i,y,ship.getShipName());
		System.out.println(i+","+y);
		ship.addCoord(tile);
		humanAllTiles.add(tile);
		}
			else
				return false;
		
	else
		if(this.middleEmptyV2(x, y, ship))
		for (int i=x;i>x-ship.getShipSize();i--)
		{b.setBoard1(i,y,1);
		Node n=getNodeFromGridPane(grid , y, i);
		n.setStyle("-fx-background-color: black;");
		n.setOnMouseClicked(null);
		Tile tile = new Tile(i,y,ship.getShipName());
		System.out.println(i+","+y);
		ship.addCoord(tile);
		humanAllTiles.add(tile);
		}
		else
			return false;
	
		
	
	
			
		System.out.println(ship.getCoordList().size());
		System.out.println(ship.getShipName());
		System.out.println(humanAllTiles.size());
	b.printBoard();
	return true;}
	
	public void humanboard(GridPane grid ) {
		for (int i=0;i<10;i++)
			for (int j=0;j<10;j++) {
				if(b.getBoard1()[i][j]==3) {
					Node n=getNodeFromGridPane(grid , j, i);
					n.setStyle("-fx-background-color: red;");
				}
		if(b.getBoard1()[i][j]==3) {
			Node n=getNodeFromGridPane(grid , j, i);
			n.setStyle("-fx-background-color: red;");
		}}
	}

	  private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	        for (Node node : gridPane.getChildren())
	            if (GridPane.getColumnIndex(node) != null
	                    && GridPane.getColumnIndex(node) != null
	                    && GridPane.getRowIndex(node) == row
	                    && GridPane.getColumnIndex(node) == col)
	                return node;
	        return null;
	    }
	
	public void nullify(GridPane grid) {
		for (int i=0;i<10;i++)
			for (int j=0;j<10;j++) {
				
					Node n=getNodeFromGridPane(grid , j, i);
					n.setOnMouseClicked(null);
					
				
	}System.out.println("Nullify");}
	
	public void ht(int x,int y, Button button)  {
		
		
		if (b.getBoard2()[x][y] == 0) 
		{	button.setStyle("-fx-background-color: blue;");
			button.setOnMouseClicked(null);
			System.out.println("You missed!");
			//System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 4);
		} 
		else if (b.getBoard2()[x][y] == 2)
		{	button.setStyle("-fx-background-color: red;");
			button.setOnMouseClicked(null);
			System.out.println("You hit the computer's ship!");
			//System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 3);
			String tileBelongsTo = tileBelongsTo(x,y,computerAllTiles);
			if (tileBelongsTo.equalsIgnoreCase("Carrier")){
				computerCarrierHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				computerCruiserHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				computerDestroyerHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				computerSubmarineHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				computerPatrolBoatHealth -= 1;
			}
			
			computerShipsRemaining -= 1;
			
			System.out.println("computer Carrier health "+computerCarrierHealth);
			System.out.println("computer Cruiser health "+computerCruiserHealth);
			System.out.println("computer Destroyer health "+computerDestroyerHealth);
			System.out.println("computer Submarine health "+computerSubmarineHealth);
			System.out.println("computer PatrolBoat health "+computerPatrolBoatHealth);
			label1.setText("computer Carrier health "+computerCarrierHealth+"\n"+"computer Cruiser health "+computerCruiserHealth+"\n"+"computer Destroyer health "+computerDestroyerHealth+"\n"+"computer Submarine health "+computerSubmarineHealth+"\n"+"computer PatrolBoat health "+computerPatrolBoatHealth);
			
			if (computerCarrierHealth == 0) {
				System.out.println("Computer carrier has been sunken!");
				labelString2="computer carrier has been sunken!"+"\n";
			}
			
			if (computerCruiserHealth == 0) {
				System.out.println("Computer cruier has been sunken!");
				labelString2="computer cruiser has been sunken!"+"\n";
			}
			
			if (computerDestroyerHealth == 0) {
				System.out.println("Computer destroyer has been sunken!");
				labelString2="computer destroyer has been sunken!"+"\n";
			}
			
			if (computerSubmarineHealth == 0) {
				System.out.println("Computer submarine has been sunken!");
				labelString2="computer submarine has been sunken!"+"\n";
			}
			
			if (computerPatrolBoatHealth == 0) {
				System.out.println("Computer patrol boat has been sunken!");
				labelString2="computer patrol boat has been sunken!"+"\n";
			}
			label2.setText(labelString2);
			System.out.println("computerShipsRemaining "+computerShipsRemaining);
		}
		else if (b.getBoard2()[x][y] == 3||b.getBoard2()[x][y] == 4)
		{	
			System.out.println("You have already shot here");
		}
}
	
			
	public void computerTurn(GridPane grid) {
	//Each side has 5 times of fires.
		 
		//Random rand = new Random();
		int x ;
		int y ;
		ArrayList<Integer> numbers1 = new ArrayList<Integer>(0);
		ArrayList<Integer> numbers = new ArrayList<Integer>(0);
		//Utilities turnUtilities = new Utilities();
		
		for(int i = 0; i < 10; i++)
		{
			numbers1.add(i);
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		Collections.shuffle(numbers1);
		//x = rand.nextInt(10);
		//y = rand.nextInt(10);	
		AIx=numbers1.get(0);
		AIy=numbers.get(1);
		

		//System.out.println(x);System.out.println(y);
			//Computer's random input for x and y are needed.
			//x=(int)x;
			//y=(int)y;
			// Assuming elements in the 2D array have been marked according to the legend.
			// Compare the element in the array to the coordinate entered to see if it is a hit or miss.
		if (b.getBoard1()[AIx][AIy] == 0) 
		{
			System.out.println("Computer missed!");
			Node n=getNodeFromGridPane(grid , AIy, AIx);
			n.setStyle("-fx-background-color: blue;");
			n.setOnMouseClicked(null);
			//System.out.println(b.getBoard1()[x][y]);
			b.setBoard1(AIx, AIy, 4);
		} 
		else if (b.getBoard1()[AIx][AIy] == 1)
		{	
			System.out.println("Computer hit your ship!");
			Node n=getNodeFromGridPane(grid , AIy, AIx);
			n.setStyle("-fx-background-color: red;");
			n.setOnMouseClicked(null);
			//System.out.println(b.getBoard1()[x][y]);
			b.setBoard1(AIx, AIy, 3);
			
			String tileBelongsTo = tileBelongsTo(AIx,AIy,humanAllTiles);
			if (tileBelongsTo.equalsIgnoreCase("Carrier")){
				humanCarrierHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				humanCruiserHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				humanDestroyerHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				humanSubmarineHealth -= 1;
			}else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				humanPatrolBoatHealth -= 1;
			}
			
			humanShipsRemaining -= 1;
			
			System.out.println("human Carrier health "+humanCarrierHealth);
			System.out.println("human Cruiser health "+humanCruiserHealth);
			System.out.println("human Destroyer health "+humanDestroyerHealth);
			System.out.println("human Submarine health "+humanSubmarineHealth);
			System.out.println("human PatrolBoat health "+humanPatrolBoatHealth);
			label3.setText("human Carrier health "+humanCarrierHealth+"\n"+"human Cruiser health "+humanCruiserHealth+"\n"+"human Destroyer health "+humanDestroyerHealth+"\n"+"human Submarine health "+humanSubmarineHealth+"\n"+"human PatrolBoat health "+humanPatrolBoatHealth);
			
			if (humanCarrierHealth == 0) {
				System.out.println("human carrier has been sunken!");
				labelString1+="human carrier has been sunken!"+"/n";
				
			}
			
			if (humanCruiserHealth == 0) {
				System.out.println("human cruier has been sunken!");
				labelString1+="human cruiser has been sunken!"+"/n";
			}
			
			if (humanDestroyerHealth == 0) {
				System.out.println("human destroyer has been sunken!");
				labelString1+="human destroyer has been sunken!"+"/n";
			}
			
			if (humanSubmarineHealth == 0) {
				System.out.println("human submarine has been sunken!");
				labelString1+="human submarine has been sunken!"+"/n";
			}
			
			if (humanPatrolBoatHealth == 0) {
				System.out.println("human patrol boat has been sunken!");
				labelString1+="human patrol boat has been sunken!"+"/n";
			}
			
			label4.setText(labelString1);
			System.out.println("humanShipsRemaining "+humanShipsRemaining);
			/*computerAI(AIx,AIy);
			AIx=AI.get(0).getX();
			AIy=AI.get(0).getY();
			System.out.println(AIx+""+AIy);
			if(b.getBoard1()[AIx][AIy] == 1)
				computerAI(AIx,AIy);*/
			
		}
		else if (b.getBoard1()[AIx][AIy] == 3||b.getBoard1()[AIx][AIy] == 4)
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
	
public boolean computerAI(int i,int j)
{
			
				Tile down=new Tile(i+1,j);
				Tile up=new Tile (i-1,j);
				Tile left=new Tile(i,j+1);
				Tile right=new Tile(i,j-1);
				AI.add(down);
				AI.add(up);AI.add(left);AI.add(right);
				return true;
}
	
	
}