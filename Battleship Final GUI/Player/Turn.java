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
import javafx.scene.text.Font;


/**
 * This class is the main logic class to process players' SShip placement and attack.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 4.2: Final GUI version. April 2020.
 */
public class Turn {

	private Board b = new Board();
	// private Scanner kb= new Scanner(System.in);
	private Tile t = new Tile();
	Ship ship1 = new Carrier();
	Ship ship2 = new Cruiser();
	Ship ship3 = new Destroyer();
	Ship ship4 = new Submarine();
	Ship ship5 = new PatrolBoat();
	Ship ships[] = { ship1, ship2, ship3, ship4, ship5 };
	private int computerShipsRemaining = 5;
	private int humanShipsRemaining = 5;
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
	private Label label1 = new Label("Human Ships: 5");
	private Label label2 = new Label("Computer Ships: 5");

	private String labelString1 = "";
	private String labelString2 = "";

	int parity = 2;
	ArrayList<Tile> predicted = new ArrayList();
	ArrayList<Tile> potential = new ArrayList();
	ArrayList<Tile> nextShot = new ArrayList();

	/**
	 * This methods changes the Ship Tiles' colour to grey when Ships are sunken.
	 * 
	 * @param grid JavaFX's gridPane
	 * @param name Ship's name
	 * @param a    Specific Ship's ArrayList that contains all the Tiles
	 */
	public void changeColor(GridPane grid, String name, ArrayList<Tile> a) {
		for (Tile t : a)
			if (tileBelongsTo(t.getX(), t.getY(), a) == name) {
				Node n = getNodeFromGridPane(grid, t.getY(), t.getX());
				n.setStyle("-fx-background-color: grey;");
			}
	}

	/**
	 * This method checks if the target Tile has been hit.
	 * 
	 * @param t Tile
	 * @return whether the Tile is hit
	 */
	public boolean sink(Tile t) {
		// A hit Tile's 2D array element is marked as 1 when hit.
		if (b.getBoard1()[t.getX()][t.getY()] == 1)
			return true;
		return false;
	}

	/**
	 * Getter methods to get labels
	 * 
	 * @return labels
	 */
		public Label getLabel2() {
		
		label2.setStyle("-fx-font-size: 32px;"+ "-fx-font-weight: bold;"+"-fx-text-fill: #FFF FFF;"+"-fx-font-family:Cambria");
	
		return label2;
	}




	public Label getLabel1() {
		label1.setStyle("-fx-font-size: 32px;"+ "-fx-font-weight: bold;"+"-fx-text-fill: #FFF FFF;"+"-fx-font-family:Cambria");
		return label1;
	}
	 public void newBoard() {
		 for(int i=0;i<10;i++)
			 for(int j=0;j<10;j++)
		 {b.setBoard1(i, j, 0);
		 b.setBoard2(i, j, 0);}
		 
		 this.humanAllTiles.removeAll(humanAllTiles);
		 this.computerAllTiles.removeAll(computerAllTiles);
		 computerCarrierHealth = 5;
		 computerCruiserHealth = 4;
			computerDestroyerHealth = 3;
			  computerSubmarineHealth = 3;
			  computerPatrolBoatHealth = 2;
			
			  humanCarrierHealth = 5;
			  humanCruiserHealth = 4;
			  humanDestroyerHealth = 3;
			  humanSubmarineHealth = 3;
			  humanPatrolBoatHealth = 2;	
			  computerShipsRemaining = 5;
				humanShipsRemaining = 5;
				labelString1="Human Ships: 5";
				 labelString2="Computer Ships: 5";
				 label1.setText(labelString1);
				 label2.setText(labelString2);
	 }
	public void cleanboard(GridPane grid ) {
		for (int i=0;i<10;i++)
			for (int j=0;j<10;j++) {
			
					Node n=getNodeFromGridPane(grid , j, i);
					if(n!=null)
					n.setStyle(null);
			}
	}

	/**
	 * This method determines which Ship the Tile belongs to.
	 * 
	 * @param x        Row of the Board
	 * @param y        Column of the Board
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
	 * 
	 * @return array of Ships
	 */
	public Ship[] getShipArray() {
		return ships.clone();
	}

	/**
	 * Getter method for the remaining number of Tiles for human or computer.
	 * 
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
	 * 
	 * @param x    Row of Board
	 * @param y    Column of Board
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

	// Checks the vertical ship placement.
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

		getInputComputer(tile1, tile2, player);
	}

	/**
	 * This method generates random coordinates that are legitimate for the computer player.
	 * 
	 * @param tile1  Start Tile
	 * @param tile2  End Tile
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

					computerShips[i].addCoord(tile);
					computerAllTiles.add(tile);
				}
			} else if (tile3.getY() == tile4.getY()) {
				for (int ix = tile3.getX(); ix < tile4.getX(); ix++) {
					Tile tile = new Tile(ix, tile3.getY(), computerShips[i].getShipName());

					computerShips[i].addCoord(tile);
					computerAllTiles.add(tile);
				}
			}

		}
		// Both human and computer players' updated Boards are presented.
		b.printBoard();
	}

	/**
	 * This method checks if the clicked location on Board GUI can be used to place a ship horizontally.
	 * 
	 * @param x    Row of Board
	 * @param y    Column of Board
	 * @param node node of GridPane
	 * @param grid the gridPane used on GUI
	 * @param ship one of the concrete Ship class
	 * @return boolean whether Ship can be placed horizontally
	 */
	public boolean hship(int x, int y, Node node, GridPane grid, Ship ship) {
		// The particular ship size is used to determine the legitimacy of the ship
		// placement.
		if (y < 10 - ship.getShipSize()) {
			if (this.middleEmptyH1(x, y, ship))
				for (int i = y; i < y + ship.getShipSize(); i++) {
					b.setBoard1(x, i, 1);
					Node n = getNodeFromGridPane(grid, i, x);

					n.setStyle("-fx-background-color: black;");
					n.setOnMouseClicked(null);
					Tile tile = new Tile(x, i, ship.getShipName());

					ship.addCoord(tile);
					humanAllTiles.add(tile);
				}
			else {

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

					ship.addCoord(tile);
					humanAllTiles.add(tile);
				}
			else {

				return false;
			}
		// Both human and computer players' updated Boards are presented.
		b.printBoard();
		return true;
	}

	/**
	 * This method checks if the clicked location on Board GUI can be used to place a ship vertically.
	 * 
	 * @param x    Row of Board
	 * @param y    Column of Board
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

				ship.addCoord(tile);
				humanAllTiles.add(tile);
			}
		else
			return false;

		b.printBoard();
		return true;
	}

	/**
	 * This method sets the Board GUI's hit Tile colour red.
	 * 
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
	 * 
	 * @param gridPane JavaFX's gridPane
	 * @param col      Column of Board
	 * @param row      Row of Board
	 * @return node of gridPane
	 */
	public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren())
			if (GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) != null
					&& GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col)
				return node;
		return null;
	}

	/**
	 * This method prevents user's mouse clicks after all five ships have been placed on Board GUI.
	 * 
	 * @param grid JavaFX's gridPane
	 */
	public void nullify(GridPane grid) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {

				Node n = getNodeFromGridPane(grid, j, i);
				n.setOnMouseClicked(null);

			}
	}

	/**
	 * This method checks computer player's status. 
	 * Based on the status, feedbacks are provided to the user.
	 * 
	 * @param x      Row of Board
	 * @param y      Column of Board
	 * @param button Button of gridPane
	 */
	public void ht(int x, int y, Button button, GridPane grid) {

		if (b.getBoard2()[x][y] == 0) {
			button.setStyle("-fx-background-color: blue;");
			button.setOnMouseClicked(null);

			b.setBoard2(x, y, 4);
		} else if (b.getBoard2()[x][y] == 2) {
			button.setStyle("-fx-background-color: red;");
			button.setOnMouseClicked(null);

			b.setBoard2(x, y, 3);
			String tileBelongsTo = tileBelongsTo(x, y, computerAllTiles);
			if (tileBelongsTo.equalsIgnoreCase("Carrier")) {
				computerCarrierHealth -= 1;
				if (computerCarrierHealth == 0) {
					changeColor(grid, "Carrier", computerAllTiles);
					computerShipsRemaining -= 1;

				}
			} else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				computerCruiserHealth -= 1;
				if (computerCruiserHealth == 0) {
					changeColor(grid, "Battleship", computerAllTiles);
					computerShipsRemaining -= 1;

				}
			} else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				computerDestroyerHealth -= 1;
				if (computerDestroyerHealth == 0) {
					changeColor(grid, "Destroyer", computerAllTiles);
					computerShipsRemaining -= 1;

				}
			} else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				computerSubmarineHealth -= 1;

				if (computerSubmarineHealth == 0) {
					changeColor(grid, "Submarine", computerAllTiles);
					computerShipsRemaining -= 1;

				}
			} else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				computerPatrolBoatHealth -= 1;
				if (computerPatrolBoatHealth == 0) {
					changeColor(grid, "PatrolBoat", computerAllTiles);
					computerShipsRemaining -= 1;

				}
			}

			labelString2 = "Computer Ships: " + computerShipsRemaining;
			label2.setText(labelString2);

		}
	}

	/**
	 * This method checks if all the ships are sunken.
	 * 
	 * @return whether all the ships are sunken.
	 */
	public boolean allSink() {
		if (this.humanCarrierHealth == 0 && this.humanCruiserHealth == 0 && this.humanPatrolBoatHealth == 0
				&& this.humanDestroyerHealth == 0 && this.humanSubmarineHealth == 0)
			return true;
		return false;
	}

	/**
	 *  The rest of the class is the implementation of game AI.
	 *  Step 1: AI checks the board and determines whether the top or bottom half has more Ship Tiles placed.
	 *  Step 2: Based on Step 1, AI starts from (0,0) or (9,9) to check every second Tile.
	 *  Step 3: If the Tile checked is a Ship Tile, then AI attacks Tile and Tile is marked as hit.
	 *  Step 4: AI checks around the hit Tile and see if there is another Ship Tile.
	 *  Step 5: Based on the direction of the two Ship Tiles, AI continues to check.
	 *  Step 6: When there is no Ship Tile around, AI would move on to the next Tile.
	 */
	public void checksShips() {
		int top = 0, down = 0;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 10; j++)
				if (b.getBoard1()[i][j] == 1)
					top++;
		for (int i = 5; i < 10; i++)
			for (int j = 0; j < 10; j++)
				if (b.getBoard1()[i][j] == 1)
					down++;

		if (top > down) {
			if (this.humanPatrolBoatHealth > 0) {
				for (int i = 0; i < 10; i++)
					for (int j = 0; j < 10; j++)
						if ((i + j) % parity == 1 && b.getBoard1()[i][j] != 3 && b.getBoard1()[i][j] != 4) {
							Tile tile = new Tile(i, j);
							predicted.add(tile);
						}
			}
		}

		if (down > top) {
			if (this.humanPatrolBoatHealth > 0) {
				for (int i = 9; i >= 0; i--)
					for (int j = 9; j >= 0; j--)
						if ((i + j) % parity == 1 && b.getBoard1()[i][j] != 3 && b.getBoard1()[i][j] != 4) {
							Tile tile = new Tile(i, j);
							predicted.add(tile);

						}
			}
		}
	}

	public void checkParity() {

		if (this.humanPatrolBoatHealth > 0) {
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					if ((i + j) % parity == 1 && b.getBoard1()[i][j] != 3 && b.getBoard1()[i][j] != 4) {
						Tile tile = new Tile(i, j);
						predicted.add(tile);
					}
		}

		if (humanPatrolBoatHealth == 0) {
			parity = 3;
			predicted.removeAll(predicted);
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					if ((i + j) % parity == 1 && b.getBoard1()[i][j] != 3 && b.getBoard1()[i][j] != 4) {

						Tile tile = new Tile(i, j);
						predicted.add(tile);
					}
		}

		if (humanSubmarineHealth == 0 && humanDestroyerHealth == 0 && humanPatrolBoatHealth == 0) {
			parity = 4;
			predicted.removeAll(predicted);
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					if ((i + j) % parity == 1 && b.getBoard1()[i][j] != 3 && b.getBoard1()[i][j] != 4) {

						Tile tile = new Tile(i, j);
						predicted.add(tile);

					}
		}
		if (humanCruiserHealth == 0 && humanSubmarineHealth == 0 && humanDestroyerHealth == 0
				&& humanPatrolBoatHealth == 0) {
			parity = 5;
			predicted.removeAll(predicted);
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					if ((i + j) % parity == 1 && b.getBoard1()[i][j] != 3 && b.getBoard1()[i][j] != 4) {

						Tile tile = new Tile(i, j);
						predicted.add(tile);
					}
		}
	}

	public void makeList(Tile t) {
		if (t.getX() < 9) {
			Tile t1 = new Tile(t.getX() + 1, t.getY());
			potential.add(t1);
		}
		if (t.getX() > 0) {
			Tile t1 = new Tile(t.getX() - 1, t.getY());
			potential.add(t1);
		}
		if (t.getY() < 9) {
			Tile t1 = new Tile(t.getX(), t.getY() + 1);
			potential.add(t1);
		}

		if (t.getY() > 0) {
			Tile t1 = new Tile(t.getX(), t.getY() - 1);
			potential.add(t1);
		}
	}

	/**
	 * This AI method checks around the hit target, in order to find the next Ship Tile.
	 * 
	 * @param grid JavaFx's gridPane
	 * @param ctr
	 */
	public int computerTurn(GridPane grid, int ctr) {

		Tile shoot = null;
		if(ctr==0)
			checksShips();
		else
			this.checkParity();
		if(nextShot.size()!=0)
		{
			shoot=nextShot.get(0);
			AIx=shoot.getX();
			AIy=shoot.getY();
			nextShot.remove(0);
		}
		else if (potential.size()!=0) {
			computerAI(grid, ctr);
			if(nextShot.size()!=0)
			{
				shoot=nextShot.get(0);
				AIx=shoot.getX();
				AIy=shoot.getY();
				nextShot.remove(0);
			}
			else {
				if(ctr<predicted.size())
				{shoot=predicted.get(ctr);
				AIx=shoot.getX();
				AIy=shoot.getY();
				}
			}


		}
		else {
			if(ctr<predicted.size())
			{shoot=predicted.get(ctr);
			AIx=shoot.getX();
			AIy=shoot.getY();}

		}

		if (b.getBoard1()[AIx][AIy] == 0) 
		{
			Node n=getNodeFromGridPane(grid , AIy, AIx);
			n.setStyle("-fx-background-color: blue;");
			n.setOnMouseClicked(null);

			b.setBoard1(AIx, AIy, 4);



		} 
		else if (b.getBoard1()[AIx][AIy] == 1)
		{	

			Node n=getNodeFromGridPane(grid , AIy, AIx);
			n.setStyle("-fx-background-color: red;");
			n.setOnMouseClicked(null);

			b.setBoard1(AIx, AIy, 3);
			this.makeList(shoot);

			if(!humanSink(shoot,grid,ctr))
				computerAI(grid,ctr);
			else {
				if(!allSink())
				{this.checkParity();
				if(ctr<predicted.size()&&ctr-6>=0)
					{shoot=predicted.get(ctr-6);
					ctr-=6;
					}
				AIx=shoot.getX();
				AIy=shoot.getY();}

			}

		}
		else if (b.getBoard1()[AIx][AIy] == 3||b.getBoard1()[AIx][AIy] == 4)
		{

			this.computerAI(grid, ctr);
			if(predicted.size()>ctr+1)
				{computerTurn(grid, ctr+1);
				ctr++;
				}
			else
				{computerTurn(grid, ctr-1);
				ctr--;
				}


		}

		labelString1="Human Ships: "+humanShipsRemaining;
		label1.setText(labelString1);

		b.printBoard();
		return ctr;

	}

	public boolean humanSink(Tile shoot, GridPane grid, int ctr) {
		makeList(shoot);
		String tileBelongsTo = tileBelongsTo(AIx, AIy, humanAllTiles);
		if (tileBelongsTo.equalsIgnoreCase("Carrier")) {
			humanCarrierHealth -= 1;

			if (humanCarrierHealth == 0) {
				humanShipsRemaining -= 1;
				changeColor(grid, "Carrier", humanAllTiles);

				return true;
			}
		} else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
			humanCruiserHealth -= 1;

			if (humanCruiserHealth == 0) {
				humanShipsRemaining -= 1;
				changeColor(grid, "Battleship", humanAllTiles);

				return true;
			}
		} else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
			humanDestroyerHealth -= 1;

			if (humanDestroyerHealth == 0) {
				humanShipsRemaining -= 1;
				changeColor(grid, "Destroyer", humanAllTiles);

				return true;
			}
		} else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
			humanSubmarineHealth -= 1;

			if (humanSubmarineHealth == 0) {
				humanShipsRemaining -= 1;
				changeColor(grid, "Submarine", humanAllTiles);

				return true;
			}
		} else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
			humanPatrolBoatHealth -= 1;

			if (humanPatrolBoatHealth == 0) {
				humanShipsRemaining -= 1;
				changeColor(grid, "PatrolBoat", humanAllTiles);

				return true;
			}
		}

		labelString1 = "Human Ships: " + humanShipsRemaining;
		label1.setText(labelString1);
		return false;
	}

	/**
	 * This AI method checks around the hit target, in order to find the next Ship
	 * Tile.
	 * 
	 * @param i Row of Board
	 * @param j Column of Board
	 * @return boolean
	 */
	public void computerAI(GridPane grid, int ctr) {
		Tile sinker = null;
		int x, y;
		for (int i = 0; i < potential.size(); i++) {
			sinker = potential.get(i);
			potential.remove(i);
			x = sinker.getX();
			y = sinker.getY();
			if (b.getBoard1()[x][y] == 1) {
				nextShot.add(sinker);
			}
		}
	}
}
