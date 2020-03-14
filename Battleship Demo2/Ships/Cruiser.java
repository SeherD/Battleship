package Ships;

import Game.*;

public class Cruiser extends Ship {
	private final String SHIP_NAME = "Battleship";
	private final int SHIP_SIZE = 4;
	private final char ID = 'B';
	
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
