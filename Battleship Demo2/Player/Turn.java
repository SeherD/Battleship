package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
//import java.util.Scanner;

/**
 * This class is the main logic class to process players' SShip placement and attack.
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.21: GUI March 2020
 */
public class Turn {
	
	// Instance variables
	private Board b = new Board();
	//private Scanner kb = new Scanner(System.in);
	//private Tile t = new Tile();
	Ship ship1 = new Carrier();
	Ship ship2 = new Cruiser();
	Ship ship3 = new Destroyer();
	Ship ship4 = new Submarine();
	Ship ship5 = new PatrolBoat();
	Ship ships[] = { ship1, ship2, ship3, ship4, ship5 };
	private int computerShipsRemaining = 17;
	private int humanShipsRemaining = 17;
	
	// All the Ship objects of both sides are stored in arrays.
	Ship humanCarrier = new Carrier();
	Ship humanCruiser = new Cruiser();
	Ship humanDestroyer = new Destroyer();
	Ship humanSubmarine = new Submarine();
	Ship humanPatrolBoat = new PatrolBoat();
	Ship humanships[] = { humanCarrier, humanCruiser, humanDestroyer, humanSubmarine, humanPatrolBoat };
	Ship computerCarrier = new Carrier();
	Ship computerCruiser = new Cruiser();
	Ship computerDestroyer = new Destroyer();
	Ship computerSubmarine = new Submarine();
	Ship computerPatrolBoat = new PatrolBoat();
	Ship computerShips[] = { computerCarrier, computerCruiser, computerDestroyer, computerSubmarine, computerPatrolBoat };

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
	
	// All the coordinates of the ships are collected in an ArrayList.
	private ArrayList<Tile> humanAllTiles = new ArrayList<Tile>(17);
	private ArrayList<Tile> computerAllTiles = new ArrayList<Tile>(17);
	private ArrayList<Tile> AI = new ArrayList<Tile>(4);
	
	private int AIx, AIy;
	private Label label1 = new Label();
	private Label label2 = new Label();
	private Label label3 = new Label();
	private Label label4 = new Label();
	private String labelString1 = "";
	private String labelString2 = "";
	
	/**
	 * Getter methods to get labels
	 * @return labels
	 */
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

	/**
	 * This method determines which Ship the Tile belongs to.
	 * @param x Row of the Board
	 * @param y Column of the Board
	 * @param allTiles arrayList of all Tiles for each Ship
	 * @return the name of the Ship
	 */
	public String tileBelongsTo(int x, int y, ArrayList<Tile> allTiles) {
		String shipName = "error";
		for (Tile tile : allTiles) {
			if (x == tile.getX() && y == tile.getY()) {
				shipName = tile.getName();
			}
		}
		return shipName;
	}
	/**
	 * Getter method for array of Ships.
	 * @return array of Ships
	 */
	public Ship[] getShipArray() {
		return ships;
	}
	/**
	 * Getter method for the remaining number of Tiles for human or computer.
	 * @return Total remaining Tiles of human or computer side
	 */
	public int getComputerShipsRemaining() {
		return computerShipsRemaining;
	}
	public int getHumanShipsRemaining() {
		return humanShipsRemaining;
	}
	/**
	 * The following 4 methods check if the middle of given start and end is empty.
	 * @param x Row of Board
	 * @param y Column of Board
	 * @param ship a concrete Ship class
	 * @return boolean whether the middle of the start and end is empty
	 */
	// Checks the horizontal ship placement.
	public boolean middleEmptyH1(int x, int y, Ship ship) {
		boolean flag = true;
		for (int i = y; i < y + ship.getShipSize(); i++)
			if (b.getBoard1()[x][i] != 0)
				flag = false;
		return flag;
	}
	public boolean middleEmptyH2(int x, int y, Ship ship) {
		boolean flag = true;
		for (int i = y; i > y - ship.getShipSize(); i--)
			if (b.getBoard1()[x][i] != 0)
				flag = false;
		return flag;
	}
	// Checks the verticle ship placement.
	public boolean middleEmptyV1(int x, int y, Ship ship) {
		boolean flag = true;
		for (int i = x; i < x + ship.getShipSize(); i++)
			if (b.getBoard1()[i][y] != 0)
				flag = false;
		return flag;
	}
	public boolean middleEmptyV2(int x, int y, Ship ship) {
		boolean flag = true;
		for (int i = x; i > x - ship.getShipSize(); i--)
			if (b.getBoard1()[i][y] != 0)
				flag = false;
		return flag;
	}
	/**
	 * This method gets the computer's input based on the next method, a randomizer.
	 */
	public void getComputerShips() {
		Tile tile1 = new Tile();
		Tile tile2 = new Tile();
		String player = "Computer";
		// The randomizer method is called to get computer's Ship locations.
		getInputComputer(tile1, tile2, player);
	}
	/**
	 * This method generates random coordinates that are legitimate for the computer player.
	 * @param tile1 Start Tile
	 * @param tile2 End Tile
	 * @param player Either the human or computer player.
	 */
	public void getInputComputer(Tile tile1, Tile tile2, String player) {
		Random rand = new Random();
		Tile tile3 = new Tile();
		Tile tile4 = new Tile();
		int x, y, or;
		or = rand.nextInt(2);
		for (int i = 0; i < 5; i++) {
			
			// One scenario generated by the randomizer.
			if (i == 0) {
				or = rand.nextInt(2);
				if ((int) or == 0) {
					x = 5;
					y = rand.nextInt(5) + 4;
					tile3.setX(x);
					tile3.setY((int) y);
					tile4.setX(tile3.getX() + ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				}

				if ((int) or == 1) {
					x = rand.nextInt(5) + 5;
					y = 5;
					tile3.setX((int) x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY() + ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			// One scenario generated by the randomizer.
			if (i == 1) {
				or = rand.nextInt(2);
				if ((int) or == 0) {
					x = 0;
					y = rand.nextInt(4);
					tile3.setX(x);
					tile3.setY((int) y);
					tile4.setX(tile3.getX() + ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if ((int) or == 1) {
					x = rand.nextInt(4);
					y = 0;
					tile3.setX((int) x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY() + ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			// One scenario generated by the randomizer.
			if (i == 2) {
				or = rand.nextInt(2);
				if ((int) or == 0) {
					x = 0;
					y = rand.nextInt(1) + 7;
					tile3.setX(x);
					tile3.setY((int) y);
					tile4.setX(tile3.getX() + ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if ((int) or == 1) {
					x = rand.nextInt(2);
					y = 7;
					tile3.setX((int) x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY() + ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			// One scenario generated by the randomizer.
			if (i == 3) {
				or = rand.nextInt(2);
				if ((int) or == 0) {
					x = 7;
					y = rand.nextInt(1);
					tile3.setX(x);
					tile3.setY((int) y);
					tile4.setX(tile3.getX() + ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if ((int) or == 1) {
					x = rand.nextInt(2) + 7;
					y = 0;
					tile3.setX((int) x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY() + ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			// One scenario generated by the randomizer.
			if (i == 4) {
				or = rand.nextInt(2);
				if ((int) or == 0) {
					x = rand.nextInt(3);
					y = 5;
					tile3.setX(x);
					tile3.setY((int) y);
					tile4.setX(tile3.getX() + ships[i].getShipSize());
					tile4.setY(tile3.getY());
					b.setBoardComputer(tile3, tile4);
				} else if ((int) or == 1) {
					x = 5;
					y = rand.nextInt(3);
					tile3.setX((int) x);
					tile3.setY(y);
					tile4.setX(tile3.getX());
					tile4.setY(tile3.getY() + ships[i].getShipSize());
					b.setBoardComputer(tile3, tile4);
				}
			}
			// Between the start and end Tiles, new Tile objects are created and collected in an arrayList.
			if (tile3.getX() == tile4.getX()) {
				for (int iy = tile3.getY(); iy < tile4.getY(); iy++) {
					Tile tile = new Tile(tile3.getX(), iy, computerShips[i].getShipName());
					System.out.println(tile3.getX() + "," + iy);
					computerShips[i].addCoord(tile);
					computerAllTiles.add(tile);
				}
			} else if (tile3.getY() == tile4.getY()) {
				for (int ix = tile3.getX(); ix < tile4.getX(); ix++) {
					Tile tile = new Tile(ix, tile3.getY(), computerShips[i].getShipName());
					System.out.println(ix + "," + tile3.getY());
					computerShips[i].addCoord(tile);
					computerAllTiles.add(tile);
				}
			}
			// Computer player's Ship details are printed to the console.
			System.out.println(computerShips[i].getCoordList().size());
			System.out.println(computerShips[i].getShipName());
			System.out.println(computerAllTiles.size());

		}
		// Both human and computer players' updated Boards are presented.
		b.printBoard();
	}

	/**
	 * This method checks if the clicked location on Board GUI can be used to place a ship horizontally.
	 * @param x Row of Board
	 * @param y Column of Board
	 * @param node node of GridPane
	 * @param grid the gridPane used on GUI
	 * @param ship one of the concrete Ship class
	 * @return boolean whether Ship can be placed horizontally
	 */
	public boolean hship(int x, int y, Node node, GridPane grid, Ship ship) {
		// The particular ship size is used to determine the legitimacy of the ship placement.
		if (y < 10 - ship.getShipSize()) {
			if (this.middleEmptyH1(x, y, ship))
				for (int i = y; i < y + ship.getShipSize(); i++) {
					b.setBoard1(x, i, 1);
					Node n = getNodeFromGridPane(grid, i, x);

					n.setStyle("-fx-background-color: black;");
					n.setOnMouseClicked(null);
					Tile tile = new Tile(x, i, ship.getShipName());
					System.out.println(x + "," + i);
					ship.addCoord(tile);
					humanAllTiles.add(tile);
				}
			else {

				System.out.println("hship218");
				return false;
			}
		}
		// The particular ship size is used to determine the legitimacy of the ship placement.
		if (y > 10 - ship.getShipSize())
			if (this.middleEmptyH2(x, y, ship))
				for (int i = y; i > y - ship.getShipSize(); i--) {
					b.setBoard1(x, i, 1);
					Node n = getNodeFromGridPane(grid, i, x);
					n.setStyle("-fx-background-color: black;");
					n.setOnMouseClicked(null);
					Tile tile = new Tile(x, i, ship.getShipName());
					System.out.println(x + "," + i);
					ship.addCoord(tile);
					humanAllTiles.add(tile);
				}
			else {

				System.out.println("hship235");
				return false;
			}
		// Both human and computer players' updated Boards are presented.
		b.printBoard();
		return true;
	}
	/**
	 * This method checks if the clicked location on Board GUI can be used to place a ship vertically.
	 * @param x Row of Board
	 * @param y Column of Board
	 * @param node node of GridPane
	 * @param grid the gridPane used on GUI
	 * @param ship one of the concrete Ship class
	 * @return boolean whether Ship can be placed vertically
	 */
	public boolean vship(int x, int y, Node node, GridPane grid, Ship ship) {
		// The particular ship size is used to determine the legitimacy of the ship placement.
		if (x < 10 - ship.getShipSize())
			if (this.middleEmptyV1(x, y, ship))
				for (int i = x; i < x + ship.getShipSize(); i++) {
					b.setBoard1(i, y, 1);
					Node n = getNodeFromGridPane(grid, y, i);
					n.setStyle("-fx-background-color: black;");
					n.setOnMouseClicked(null);
					Tile tile = new Tile(i, y, ship.getShipName());
					System.out.println(i + "," + y);
					ship.addCoord(tile);
					humanAllTiles.add(tile);
				}
			else
				return false;

		else if (this.middleEmptyV2(x, y, ship))
			for (int i = x; i > x - ship.getShipSize(); i--) {
				b.setBoard1(i, y, 1);
				Node n = getNodeFromGridPane(grid, y, i);
				n.setStyle("-fx-background-color: black;");
				n.setOnMouseClicked(null);
				Tile tile = new Tile(i, y, ship.getShipName());
				System.out.println(i + "," + y);
				ship.addCoord(tile);
				humanAllTiles.add(tile);
			}
		else
			return false;
		// Human player's Ship details are printed to the console.
		System.out.println(ship.getCoordList().size());
		System.out.println(ship.getShipName());
		System.out.println(humanAllTiles.size());
		// Both human and computer players' updated Boards are presented.
		b.printBoard();
		return true;
	}

	/**
	 * This method sets the Board GUI's hit Tile colour red.
	 * @param grid JavaFX's gridPane
	 */
	public void humanboard(GridPane grid) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				if (b.getBoard1()[i][j] == 3) {
					Node n = getNodeFromGridPane(grid, j, i);
					n.setStyle("-fx-background-color: red;");
				}
				if (b.getBoard1()[i][j] == 3) {
					Node n = getNodeFromGridPane(grid, j, i);
					n.setStyle("-fx-background-color: red;");
				}
			}
	}

	/**
	 * Getter method for gridPane's individual node.
	 * @param gridPane JavaFX's gridPane
	 * @param col Column of Board
	 * @param row Row of Board
	 * @return node of gridPane
	 */
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren())
			if (GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) != null
					&& GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col)
				return node;
		return null;
	}

	/**
	 * This method prevents user's mouse clicks after all five ships have been placed on Board GUI.
	 * @param grid JavaFX's gridPane
	 */
	public void nullify(GridPane grid) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {

				Node n = getNodeFromGridPane(grid, j, i);
				n.setOnMouseClicked(null);

			}
		System.out.println("Nullify");
	}

	/**
	 * This method checks computer player's status. Based on the status, feedbacks are provided to the user.
	 * @param x Row of Board
	 * @param y Column of Board
	 * @param button Button of gridPane
	 */
	public void ht(int x, int y, Button button) {

		if (b.getBoard2()[x][y] == 0) {
			button.setStyle("-fx-background-color: blue;");
			button.setOnMouseClicked(null);
			System.out.println("You missed!");
			// System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 4);
		} else if (b.getBoard2()[x][y] == 2) {
			button.setStyle("-fx-background-color: red;");
			button.setOnMouseClicked(null);
			System.out.println("You hit the computer's ship!");
			// System.out.println(b.getBoard2()[x][y]);
			b.setBoard2(x, y, 3);
			String tileBelongsTo = tileBelongsTo(x, y, computerAllTiles);
			
			// The following block of code checks which the hit Tile belongs to.
			if (tileBelongsTo.equalsIgnoreCase("Carrier")) {
				computerCarrierHealth -= 1;
				if (computerCarrierHealth == 0) {
					System.out.println("Computer carrier has been sunken!");
					labelString2 = "computer carrier has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				computerCruiserHealth -= 1;
				if (computerCruiserHealth == 0) {
					System.out.println("Computer cruier has been sunken!");
					labelString2 = "computer cruiser has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				computerDestroyerHealth -= 1;
				if (computerDestroyerHealth == 0) {
					System.out.println("Computer destroyer has been sunken!");
					labelString2 = "computer destroyer has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				computerSubmarineHealth -= 1;

				if (computerSubmarineHealth == 0) {
					System.out.println("Computer submarine has been sunken!");
					labelString2 = "computer submarine has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				computerPatrolBoatHealth -= 1;
				if (computerPatrolBoatHealth == 0) {
					System.out.println("Computer patrol boat has been sunken!");
					labelString2 = "computer patrol boat has been sunken!" + "\n";
				}
			}
			
			// When the Ship Tile is hit, Ship loses 1 health among its total health.
			computerShipsRemaining -= 1;
			
			// Ship's status is set to the label, in order to be provided to the user as feedback.
			label2.setText(labelString2);
			label1.setText("computer Carrier health " + computerCarrierHealth + "\n" + "computer Cruiser health "
					+ computerCruiserHealth + "\n" + "computer Destroyer health " + computerDestroyerHealth + "\n"
					+ "computer Submarine health " + computerSubmarineHealth + "\n" + "computer PatrolBoat health "
					+ computerPatrolBoatHealth);
			
			//Ship's status is printed to the console.
			System.out.println("computer Carrier health " + computerCarrierHealth);
			System.out.println("computer Cruiser health " + computerCruiserHealth);
			System.out.println("computer Destroyer health " + computerDestroyerHealth);
			System.out.println("computer Submarine health " + computerSubmarineHealth);
			System.out.println("computer PatrolBoat health " + computerPatrolBoatHealth);
			System.out.println("computerShipsRemaining " + computerShipsRemaining);
		}
	}

	/**
	 * This method provides feedbacks when computer player's Ship has been sunken.
	 */
	public void sinkComputer() {

		if (computerCarrierHealth == 0) {
			System.out.println("Computer carrier has been sunken!");
			labelString2 = "computer carrier has been sunken!" + "\n";
		}
		if (computerCruiserHealth == 0) {
			System.out.println("Computer cruier has been sunken!");
			labelString2 = "computer cruiser has been sunken!" + "\n";
		}
		if (computerDestroyerHealth == 0) {
			System.out.println("Computer destroyer has been sunken!");
			labelString2 = "computer destroyer has been sunken!" + "\n";
		}
		if (computerSubmarineHealth == 0) {
			System.out.println("Computer submarine has been sunken!");
			labelString2 = "computer submarine has been sunken!" + "\n";
		}
		if (computerPatrolBoatHealth == 0) {
			System.out.println("Computer patrol boat has been sunken!");
			labelString2 = "computer patrol boat has been sunken!" + "\n";
		}
		label2.setText(labelString2);
	}

	/**
	 * This method checks human player's status. Based on the status, feedbacks are provided to the user.
	 * @param grid JavaFX's gridPane
	 */
	public void computerTurn(GridPane grid) {

		//Random rand = new Random();
		//int x;
		//int y;
		ArrayList<Integer> numbers1 = new ArrayList<Integer>(0);
		ArrayList<Integer> numbers = new ArrayList<Integer>(0);
		// Utilities turnUtilities = new Utilities();

		for (int i = 0; i < 10; i++) {
			numbers1.add(i);
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		Collections.shuffle(numbers1);
		// x = rand.nextInt(10);
		// y = rand.nextInt(10);
		AIx = numbers1.get(0);
		AIy = numbers.get(1);

		// System.out.println(x);System.out.println(y);
		// Computer's random input for x and y are needed.
		// x=(int)x;
		// y=(int)y;
		// Assuming elements in the 2D array have been marked according to the legend.
		// Compare the element in the array to the coordinate entered to see if it is a
		// hit or miss.
		if (b.getBoard1()[AIx][AIy] == 0) {
			System.out.println("Computer missed!");
			Node n = getNodeFromGridPane(grid, AIy, AIx);
			n.setStyle("-fx-background-color: blue;");
			n.setOnMouseClicked(null);
			// System.out.println(b.getBoard1()[x][y]);
			b.setBoard1(AIx, AIy, 4);
		} else if (b.getBoard1()[AIx][AIy] == 1) {
			System.out.println("Computer hit your ship!");
			Node n = getNodeFromGridPane(grid, AIy, AIx);
			n.setStyle("-fx-background-color: red;");
			n.setOnMouseClicked(null);
			// System.out.println(b.getBoard1()[x][y]);
			b.setBoard1(AIx, AIy, 3);

			String tileBelongsTo = tileBelongsTo(AIx, AIy, humanAllTiles);
			
			// The following block of code checks which the hit Tile belongs to.
			if (tileBelongsTo.equalsIgnoreCase("Carrier")) {
				humanCarrierHealth -= 1;
				if (humanCarrierHealth == 0) {
					System.out.println("human submarine has been sunken!");
					labelString2 = "Human Carrier has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				humanCruiserHealth -= 1;
				if (humanCruiserHealth == 0) {
					System.out.println("human submarine has been sunken!");
					labelString2 = "Human Battleship has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				humanDestroyerHealth -= 1;
				if (humanDestroyerHealth == 0) {
					System.out.println("human submarine has been sunken!");
					labelString2 = "Human Destroyer has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				humanSubmarineHealth -= 1;
				if (humanSubmarineHealth == 0) {
					System.out.println("human submarine has been sunken!");
					labelString2 = "Human submarine has been sunken!" + "\n";
				}
			} else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				humanPatrolBoatHealth -= 1;
				if (humanPatrolBoatHealth == 0) {
					System.out.println("human submarine has been sunken!");
					labelString2 = "Human Patrol Boat has been sunken!" + "\n";
				}
			}
			
			// When the Ship Tile is hit, Ship loses 1 health among its total health.
			humanShipsRemaining -= 1;
			
			//Ship's status is printed to the console.
			System.out.println("human Carrier health " + humanCarrierHealth);
			System.out.println("human Cruiser health " + humanCruiserHealth);
			System.out.println("human Destroyer health " + humanDestroyerHealth);
			System.out.println("human Submarine health " + humanSubmarineHealth);
			System.out.println("human PatrolBoat health " + humanPatrolBoatHealth);
			
			// Ship's status is set to the label, in order to be provided to the user as feedback.
			label3.setText(
					"human Carrier health " + humanCarrierHealth + "\n" + "human Cruiser health " + humanCruiserHealth
							+ "\n" + "human Destroyer health " + humanDestroyerHealth + "\n" + "human Submarine health "
							+ humanSubmarineHealth + "\n" + "human PatrolBoat health " + humanPatrolBoatHealth);
			label4.setText(labelString1);
			System.out.println("humanShipsRemaining " + humanShipsRemaining);
			/*
			 * computerAI(AIx,AIy); AIx=AI.get(0).getX(); AIy=AI.get(0).getY();
			 * System.out.println(AIx+""+AIy); if(b.getBoard1()[AIx][AIy] == 1)
			 * computerAI(AIx,AIy);
			 */

		} else if (b.getBoard1()[AIx][AIy] == 3 || b.getBoard1()[AIx][AIy] == 4) {
			System.out.println("Computer has already shot here");
		}
		// Both human and computer players' updated Boards are presented.
		b.printBoard();
	}

	/**
	 * This AI method checks around the hit target, in order to find the next Ship Tile.
	 * @param i Row of Board
	 * @param j Column of Board
	 * @return boolean 
	 */
	public boolean computerAI(int i, int j) {

		Tile down = new Tile(i + 1, j);
		Tile up = new Tile(i - 1, j);
		Tile left = new Tile(i, j + 1);
		Tile right = new Tile(i, j - 1);
		AI.add(down);
		AI.add(up);
		AI.add(left);
		AI.add(right);
		return true;
	}
}
