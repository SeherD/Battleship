package Ships;

import Game.*;

public class Carrier extends Ship {
	private final String SHIP_NAME = "Carrier";
	private final int SHIP_SIZE = 5;
	private final char ID = 'C';
	
	public Carrier() {
		super();
		shipName = SHIP_NAME;
		shipSize = SHIP_SIZE;
		id = ID;
	}
	
	public Carrier(Tile a, Tile b, String player) {
		super(a, b, player);
		shipName = SHIP_NAME;
		this.shipSize = SHIP_SIZE;
		this.id = ID;
	}
}
