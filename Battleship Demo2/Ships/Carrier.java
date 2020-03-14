package Ships;

import Game.*;

/**
 * This class is a child class of Ship.
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.21: GUI March 2020
 */
public class Carrier extends Ship {
	private final String SHIP_NAME = "Carrier";
	private final int SHIP_SIZE = 5;
	private final char ID = 'C';
	
	/**
	 * Constructor with no parameter.
	 * @Constructor
	 */
	public Carrier() {
		super();
		shipName = SHIP_NAME;
		shipSize = SHIP_SIZE;
		id = ID;
	}
	
	/**
	 * Constructor with 3 parameters: start and end Tiles and player.
	 * @Constructor
	 */
	public Carrier(Tile a, Tile b, String player) {
		super(a, b, player);
		shipName = SHIP_NAME;
		this.shipSize = SHIP_SIZE;
		this.id = ID;
	}
}
