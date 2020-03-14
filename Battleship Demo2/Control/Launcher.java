package Control;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Game.Board;
import Player.*;

/**
 * This class acts as the game launcher. GUI is launched when program is run.
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 2.21: GUI March 2020
 */
public class Launcher extends Application {
	// Two graidPanes are used to create two boards.
	GridPane gridPane1 = new GridPane();
	GridPane gridPane2 = new GridPane();
	HandleButton handler = new HandleButton();
	static Utilities ut = new Utilities();
	Turn turn = new Turn();
	VBox vbox = new VBox(60);
	Scene scene;

	public Launcher() {

	}

	/**
	 * This method creates the GUI.
	 * @param Stage JavaFX stage
	 */
	@Override
	public void start(Stage stage) {

		HBox hbox = new HBox(50);
		HBox score = new HBox(20);
		// Background colours are set.
		String style1 = "-fx-background-color: #000 000;";
		String style2 = "-fx-background-color: #FFF 000;";
		vbox.setStyle(style1);
		score.setStyle(style2);
		hbox.setStyle(style2);

		score.getChildren().addAll(turn.getLabel1(), turn.getLabel2(), turn.getLabel3(), turn.getLabel4());
		vbox.prefWidthProperty().bind(stage.widthProperty().multiply(1));
		// Board#1 is created on the left for the human player to place ships.
		gridPane1.setMinSize(200, 200);
		for (int i = 0; i < 10; i++)
			gridPane1.getColumnConstraints().add(new ColumnConstraints(50));
		// Board#2 is created on the right for the computer player to place ships.
		gridPane2.setMinSize(200, 200);
		for (int i = 0; i < 10; i++)
			gridPane2.getColumnConstraints().add(new ColumnConstraints(50));
		// Both boards are set to be visible.
		gridPane1.setGridLinesVisible(true);
		gridPane2.setGridLinesVisible(true);
		// Setting the Grid alignment
		gridPane1.setAlignment(Pos.CENTER_LEFT);
		gridPane2.setAlignment(Pos.CENTER_RIGHT);
		//Paddings are set.
		hbox.setPadding(new Insets(30, 30, 30, 70));
		turn.getComputerShips();
		// Nested for loops are used to populate two 10x10 boards with 100 buttons.
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				Button button = new Button();

				button.setMinHeight(50);
				button.setMinWidth(50);

				button.setOnMouseClicked(handler);
				gridPane1.add(button, i, j);
			}
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				Button button = new Button();
				button.setMinHeight(50);
				button.setMinWidth(50);
				gridPane2.add(button, i, j);
				// Mouse click event.
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					/**
					 * This method lets the logic code receive the location of the clicked button.
					 * @param MouseEvent
					 */
					@Override
					public void handle(MouseEvent e) {
						int x = GridPane.getRowIndex(button);
						int y = GridPane.getColumnIndex(button);
						// Logic code is connected with GUI code, so location can be passed.
						turn.ht(x, y, button);
						turn.computerTurn(gridPane1);
						if (turn.getHumanShipsRemaining() == 0 || turn.getComputerShipsRemaining() == 0) {
							turn.nullify(gridPane2);
							ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(), gridPane2, turn);
						}
					}
				});
			}
		// Both boards are added to the hbox, and the hbox is added to the vbox.
		hbox.getChildren().addAll(gridPane1, gridPane2);
		vbox.getChildren().addAll(hbox, score);

		// scene.setFill(null);
		
		scene = new Scene(vbox, 1200, 700);
		// Setting title to the Stage
		stage.setTitle("Battleship1");
		// Adding scene to the stage
		stage.setScene(scene);
		// Displaying the contents of the stage
		stage.show();

	}

	/**
	 * Getter method for Pane.
	 * @return vbox
	 */
	public VBox getPane() {
		return vbox;
	}
	/**
	 * Getter method for Scene.
	 * @return scene
	 */
	public Scene getScene() {
		return scene;
	}
	/**
	 * This class returns the nodes of the gridPane.
	 * @param gridPane JavaFX's gridPane
	 * @param col gridPane's column
	 * @param row gridPane's row
	 * @return node node of gridPane
	 */
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren())
			if (GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) != null
					&& GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col)
				return node;
		return null;
	}
	/**
	 * This is the main of the program and starts the GUI.
	 * @param args
	 */
	public static void main(String args[]) {

		// turn.getUserShips();
		// ut.intro();
		launch(args);
		// turn.switchTurns();
	}
	/**
	 * This is an event handler class for GUI.
	 * When buttons are clicked, ships are placed on the board.
	 */
	private class HandleButton implements EventHandler<MouseEvent> {
		int ctr = 0;
		boolean increment;

		/**
		 * This method enables the left click for horizontal ship placement and right click for vertical ship placement.
		 * @param event JavaFX event.
		 */
		@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x = GridPane.getRowIndex(btn);
			int y = GridPane.getColumnIndex(btn);
			// Left button click is handled as the horizontal ship placement.
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				System.out.println("" + x + y + ctr);
				increment = turn.hship(x, y, btn, gridPane1, turn.getShipArray()[ctr]);
				if (increment)
					ctr++;
			}
			// Right button click is handled as the vertical ship placement.
			if (event.getButton().equals(MouseButton.SECONDARY)) {
				System.out.println("" + x + y + ctr);
				increment = turn.vship(x, y, btn, gridPane1, turn.getShipArray()[ctr]);
				if (increment)
					ctr++;
			}
			// Once all five ships are placed on board, user cannot continue placing ships.
			if (ctr == 5)
				turn.nullify(gridPane1);
		}
	}
}
