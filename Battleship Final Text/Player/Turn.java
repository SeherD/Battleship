package Player;

import Game.*;

import java.util.*;

import Ships.*;

/**
 * This class is the main logic class to process players' Ship placement and attack.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.2: Final Text-based Version
 */
public class Turn {

	// Instance variables
	private Board b = new Board();
	private Scanner kb = new Scanner(System.in);
	private Tile t = new Tile();

	// All the Ship objects of both sides are stored in arrays.
	Ship humanCarrier = new Carrier();
	Ship humanCruiser = new Cruiser();
	Ship humanDestroyer = new Destroyer();
	Ship humanSubmarine = new Submarine();
	Ship humanPatrolBoat = new PatrolBoat();
	Ship ships[] = { humanCarrier, humanCruiser, humanDestroyer, humanSubmarine, humanPatrolBoat };
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

	private int humanShipsRemaining = 17;
	private int computerShipsRemaining = 17;

	// All the coordinates of the ships are collected in an ArrayList.
	private ArrayList<Tile> humanAllTiles = new ArrayList<Tile>(17);
	private ArrayList<Tile> computerAllTiles = new ArrayList<Tile>(17);

	/**
	 * This method determines which Ship the Tile belongs to.
	 * 
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
	 * Getter methods for the remaining numbers of Tiles for human and computer.
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
	 * This method checks if the given Tile is empty.
	 * 
	 * @param t Tile
	 * @return boolean whether the given Tile is empty
	 */
	public boolean isTileEmpty(Tile t) {
		return b.getBoard1()[t.getX()][t.getY()] == 0;
	}

	/**
	 * This method checks if the middle of given start and end Tile is empty.
	 * 
	 * @param t1 Start Tile
	 * @param t2 End Tile
	 * @return boolean whether the middle of the start and end is empty
	 */
	public boolean isMiddleEmpty(Tile t1, Tile t2) {

		if (t1.getX() == t2.getX())
			for (int i = t1.getY(); i < t2.getY(); i++)
				if (b.getBoard1()[t1.getX()][i] != 0) {
					System.out.println(b.getBoard1()[t1.getX()][i] != 0);
					return false;
				}

		if (t1.getY() == t2.getY())
			for (int j = t1.getX(); j < t2.getX(); j++)
				if (b.getBoard1()[j][t1.getY()] != 0)
					return false;
		return true;
	}

	/**
	 * This method checks if the coordinates entered by the user are spaced
	 * correctly.
	 * 
	 * @param tile1 Start Tile
	 * @param tile2 End Tile
	 * @param ship  Ship to which Tiles belong
	 * @return boolean whether the length between Tiles are correct.
	 */
	public boolean checkLength(Tile tile1, Tile tile2, Ship ship) {
		if (Math.abs(tile1.getX() - tile2.getX()) == ship.getShipSize() && Math.abs(tile1.getY() - tile2.getY()) == 0) {
			return true;
		}
		else if ((Math.abs(tile1.getX() - tile2.getX()) == 0 && Math.abs(tile1.getY() - tile2.getY()) == ship.getShipSize())) {
			return true;
		}
		return false;
	}

	/**
	 * This method gets user's ships from input prompts.
	 * (not getter method)
	 */
	public void getUserShips() {
		Tile tile1 = new Tile();
		Tile tile2 = new Tile();
		String player = "Human";

		for (int i = 0; i < 5; i++) {
			getInputShips(tile1, tile2, player, ships[i]);
		}
	}

	/**
	 * This method prompts the user for start and end coordinates of the ships.
	 * (not getter method)
	 * 
	 * @param tile1  Start Tile
	 * @param tile2  End Tile
	 * @param player Side of player
	 * @param ship   Ship to which Tiles belong
	 */
	public void getInputShips(Tile tile1, Tile tile2, String player, Ship ship) {
		do {
			try {
				do {
					System.out.println("");
					System.out.println("Please enter the start cordinates of the " + ship.getShipName() + ". Length: "
							+ ship.getShipSize());
					System.out.println("(Ensure coordinates are in the format of row,column For example: 1,1)");
					String input1 = kb.nextLine();
					tile1 = t.createLocation(input1);
					if (!b.inBounds(tile1))
						System.out.println("Location not on board,try again");
					if (!isTileEmpty(tile1))
						System.out.println("Location not empty,try again");
				} while (!b.inBounds(tile1) || !isTileEmpty(tile1));

				do {
					System.out.println("");
					System.out.println("Please enter the end cordinates of the " + ship.getShipName() + ". Length: "
							+ ship.getShipSize());
					System.out.println("(Ensure coordinates are in the format of row,column For example: 1,1)");
					System.out.println("Please calculate the end coordinate based on the ship's length.");
					String input2 = kb.nextLine();
					tile2 = t.createLocation(input2);
					if (!b.inBounds(tile2))
						System.out.println("Location not on board,try again");
					if (!isTileEmpty(tile2))
						System.out.println("Location not empty,try again");
				} while (!b.inBounds(tile2) || !isTileEmpty(tile2));

				if (checkLength(tile1, tile2, ship)) {
					b.setBoardHuman(tile1, tile2);
					b.printBoard();
					if (tile1.getX() == tile2.getX()) {
						if (tile1.getY() < tile2.getY()) {
							for (int i = tile1.getY(); i < tile2.getY(); i++) {
								Tile tile = new Tile(tile1.getX(), i, ship.getShipName());
								System.out.println(tile1.getX() + "," + i);
								ship.addCoord(tile);
								humanAllTiles.add(tile);
							}
						} else if (tile1.getY() > tile2.getY()) {
							for (int i = tile2.getY() + 1; i < tile1.getY(); i++) {
								Tile tile = new Tile(tile1.getX(), i, ship.getShipName());
								System.out.println(tile1.getX() + "," + i);
								ship.addCoord(tile);
								humanAllTiles.add(tile);
							}
						}
					}

					if (tile1.getY() == tile2.getY()) {
						if (tile1.getX() < tile2.getX()) {
							for (int i = tile1.getX(); i < tile2.getX(); i++) {
								Tile tile = new Tile(i, tile1.getY(), ship.getShipName());
								System.out.println(i + "," + tile1.getX());
								ship.addCoord(tile);
								humanAllTiles.add(tile);
							}
						} else if (tile1.getX() > tile2.getX()) {
							for (int i = tile2.getX(); i < tile1.getX(); i++) {
								Tile tile = new Tile(i, tile1.getY(), ship.getShipName());
								System.out.println(i + "," + tile1.getX());
								ship.addCoord(tile);
								humanAllTiles.add(tile);
							}
						}
					}

					System.out.println(ship.getCoordList().size());
					System.out.println(ship.getShipName());
					System.out.println(humanAllTiles.size());

				} else
					System.out.println("Invalid , try again");
			} catch (Exception e) {
				System.out.println("Please ensure coordinates are entered in the correct form.");
			}
		} while (!checkLength(tile1, tile2, ship));

	}

	/**
	 * This method gets the computer's input based on the next method, a randomizer.
	 * (not getter method)
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
	 * (not getter method)
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
			// Between the start and end Tiles, new Tile objects are created and collected
			// in an arrayList.
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
	 * This method prompts the user for coordinates to shoot at. Each side has 5
	 * times of fires.
	 */
	public void humanTurn() {
		// Each side has 5 times of fires.
		Tile tile1 = new Tile();
		do {
			System.out.println("Enter cordinates to shoot at:");
			System.out.println("(In the format of **row,column** For example: 1,1)");
			String input = kb.nextLine();
			tile1 = t.createLocation(input);
			if (!b.inBounds(tile1))
				System.out.println("Location not on board,try again");

		} while (!b.inBounds(tile1));
		// User's input for x and y are needed.
		int x = tile1.getX();
		int y = tile1.getY();

		// Assuming elements in the 2D array have been marked according to the legend.
		// Compare the element in the array to the coordinate entered to see if it is a
		// hit or miss.
		if (b.getBoard2()[x][y] == 0) {
			System.out.println("You missed!");

			b.setBoard2(x, y, 4);
		} else if (b.getBoard2()[x][y] == 2) {
			System.out.println("You hit the computer's ship!");

			b.setBoard2(x, y, 3);

			String tileBelongsTo = tileBelongsTo(x, y, computerAllTiles);
			if (tileBelongsTo.equalsIgnoreCase("Carrier")) {
				computerCarrierHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				computerCruiserHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				computerDestroyerHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				computerSubmarineHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				computerPatrolBoatHealth -= 1;
			}

			computerShipsRemaining -= 1;

			System.out.println("computer Carrier health " + computerCarrierHealth);
			System.out.println("computer Cruiser health " + computerCruiserHealth);
			System.out.println("computer Destroyer health " + computerDestroyerHealth);
			System.out.println("computer Submarine health " + computerSubmarineHealth);
			System.out.println("computer PatrolBoat health " + computerPatrolBoatHealth);

			if (computerCarrierHealth == 0) {
				System.out.println("Computer carrier has been sunken!");
			}

			if (computerCruiserHealth == 0) {
				System.out.println("Computer cruier has been sunken!");
			}

			if (computerDestroyerHealth == 0) {
				System.out.println("Computer destroyer has been sunken!");
			}

			if (computerSubmarineHealth == 0) {
				System.out.println("Computer submarine has been sunken!");
			}

			if (computerPatrolBoatHealth == 0) {
				System.out.println("Computer patrol boat has been sunken!");
			}

			System.out.println("computerShipsRemaining " + computerShipsRemaining);

		} else if (b.getBoard2()[x][y] == 3 || b.getBoard2()[x][y] == 4) {
			System.out.println("You have already shot here");
		}
		b.printBoard();
	}

	/**
	 * This method prompts the computer for coordinates to shoot at. 
	 * Each side has 5 times of fires.
	 */
	public void computerTurn() {

		int x;
		int y;
		ArrayList<Integer> numbers = new ArrayList<Integer>(0);

		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);

		x = numbers.get(0);
		y = numbers.get(1);

		if (b.getBoard1()[x][y] == 0) {
			System.out.println("Computer missed!");

			b.setBoard1(x, y, 4);
		} else if (b.getBoard1()[x][y] == 1) {

			System.out.println("Computer hit your ship!");

			b.setBoard1(x, y, 3);

			String tileBelongsTo = tileBelongsTo(x, y, humanAllTiles);
			if (tileBelongsTo.equalsIgnoreCase("Carrier")) {
				humanCarrierHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("Battleship")) {
				humanCruiserHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("Destroyer")) {
				humanDestroyerHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("Submarine")) {
				humanSubmarineHealth -= 1;
			} else if (tileBelongsTo.equalsIgnoreCase("PatrolBoat")) {
				humanPatrolBoatHealth -= 1;
			}

			humanShipsRemaining -= 1;

			System.out.println("human Carrier health " + humanCarrierHealth);
			System.out.println("human Cruiser health " + humanCruiserHealth);
			System.out.println("human Destroyer health " + humanDestroyerHealth);
			System.out.println("human Submarine health " + humanSubmarineHealth);
			System.out.println("human PatrolBoat health " + humanPatrolBoatHealth);

			if (humanCarrierHealth == 0) {
				System.out.println("human carrier has been sunken!");
			}

			if (humanCruiserHealth == 0) {
				System.out.println("Human cruier has been sunken!");
			}

			if (humanDestroyerHealth == 0) {
				System.out.println("Human destroyer has been sunken!");
			}

			if (humanSubmarineHealth == 0) {
				System.out.println("Human submarine has been sunken!");
			}

			if (humanPatrolBoatHealth == 0) {
				System.out.println("Human patrol boat has been sunken!");
			}

			System.out.println("humanShipsRemaining " + humanShipsRemaining);

		} else if (b.getBoard1()[x][y] == 3 || b.getBoard1()[x][y] == 4) {
			System.out.println("Computer has already shot here");
		}
		b.printBoard();
	}

	/**
	 * This is the core method to switch turns if not all the ships on one side have been sunken.
	 * This method keeps alternating turns between user and computer till all ships are sunk.
	 */
	public void switchTurns() {
		while ((computerShipsRemaining != 0) && (humanShipsRemaining != 0)) {
			System.out.println("Your turn");
			humanTurn();

			System.out.println("Computer's turn");
			computerTurn();
		}
	}
}
