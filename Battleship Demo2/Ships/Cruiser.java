package Ships;

import Game.*;

/**
 * This class is a child class of Ship.
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.21: GUI March 2020
 */
public class Cruiser extends Ship {
	private final String SHIP_NAME = "Battleship";
	private final int SHIP_SIZE = 4;
	private final char ID = 'B';
	
	/**
	 * Constructor with no parameter.
	 * @Constructor
	 */
	public Cruiser() {
		super();
		shipName = SHIP_NAME;
		shipSize = SHIP_SIZE;
		id = ID;
	}
	
	public Cruiser(Tile a, Tile b, String player) {
		super(a, b, player);
		shipName = SHIP_NAME;
		this.shipSize = SHIP_SIZE;
		this.id = ID;
	}
}
