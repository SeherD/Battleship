package Control;

import java.io.File;

import Player.Turn;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * This class acts as the game launcher and GUI hub. GUI is launched when
 * program is run.
 * 
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 * @version 4.2: Final GUI version. April 2020.
 */
public class Launcher extends Application implements EventHandler<ActionEvent> {
	// Two graidPanes are used to create two boards.
	GridPane gridPane1 = new GridPane();
	GridPane gridPane2 = new GridPane();
	Button backButton = new Button("Clear Ships"), resetButton=new Button("Reset"),exit=new Button("Menu"),helper=new Button("Help");
	HandleButton handler = new HandleButton();
	Handle handle = new Handle();
	HandleTimed handle1 = new HandleTimed();
	static Utilities ut = new Utilities();
	Turn turn = new Turn();
	private static final Integer STARTTIME = 360;
	private Timeline timeline;
	private Label timerLabel = new Label();
	private Integer timeSeconds = STARTTIME;
	Scene menu, limited, help, normal, timed = null;;
	Stage stage;

	public Launcher() {
		resetButton.setStyle("-fx-text-fill: white;" + 
				"    -fx-font-family: Arial Narrow;" + 
				"    -fx-font-weight: bold;" + 
				"    -fx-background-color: linear-gradient(#61a2b1, #2A5058);"+
				"-fx-font-size: 22px;");
		exit.setStyle("-fx-text-fill: white;" + 
				"    -fx-font-family: Arial Narrow;" + 
				"    -fx-font-weight: bold;" + 
				"    -fx-background-color: linear-gradient(#ff5400, #be1d00);"+
				"-fx-font-size: 22px;");
		helper.setStyle("-fx-text-fill: black;" + 
				"    -fx-font-family: Arial Narrow;" + 
				"    -fx-font-weight: bold;" + 
				"    -fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);" + 
				"-fx-font-size: 22px;");
		backButton.setStyle("-fx-text-fill: white;" + 
				"    -fx-font-family: Arial Narrow;" + 
				"    -fx-font-weight: bold;" + 
				"    -fx-background-color: linear-gradient(#61a2b1, #2A5058);"+
				"-fx-font-size: 22px;");
		gridPane1.setPrefSize(500, 500);
		for (int i = 0; i < 10; i++)
			gridPane1.getColumnConstraints().add(new ColumnConstraints(50));
	
		// Board#2 is created on the right for the computer player to place ships.
		gridPane2.setPrefSize(500, 500);
		for (int i = 0; i < 10; i++)
			gridPane2.getColumnConstraints().add(new ColumnConstraints(50));
		
		// Both boards are set to be visible.
		gridPane1.setGridLinesVisible(true);
		gridPane2.setGridLinesVisible(true);
		gridPane1.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 4;" +
                "-fx-border-radius:1;" + 
                "-fx-border-color: red;");
		gridPane2.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 4;" +
                "-fx-border-radius:1;" + 
                "-fx-border-color: red;");
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
				button.setOnMouseClicked(null);}
	}

	/**
	 * This method creates the GUI.
	 * 
	 * @param Stage JavaFX stage
	 */
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		MainMenu(stage);
	}

	/**
	 * This method sets up a new game mode: Regular Mode.
	 */
	private void normalBattleship() {
		HBox hbox = new HBox(100);
		HBox score = new HBox(40);
		VBox vbox = new VBox(60);
		String style1 = "-fx-background-color: #000 000;";
		vbox.setStyle(style1);
		
		score.setStyle(style1);
		hbox.setStyle(style1);
		handler.check(true,"Normal");
		turn.newBoard();
		unnullify(gridPane1,"2");
		
		turn.cleanboard(gridPane1);
		turn.cleanboard(gridPane2);
		turn.nullify(gridPane2);
		
		vbox.prefWidthProperty().bind(stage.widthProperty().multiply(1));
		
		gridPane1.setTranslateX(30);
	
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				MainMenu(stage);
				
				}});
		
		
		helper.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				helper(stage, "Normal");
				}});	
		backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handler=new HandleButton();
				turn.newBoard();
				unnullify(gridPane1,"2");
			;
				turn.cleanboard(gridPane1);
				turn.cleanboard(gridPane2);
				turn.getComputerShips();
				
			}
		});
		
		resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handler=new HandleButton();
				turn.newBoard();
				unnullify(gridPane1,"2");
				
				turn.cleanboard(gridPane1);
				turn.cleanboard(gridPane2);
				turn.getComputerShips();
				backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						handler=new HandleButton();
						turn.newBoard();
						unnullify(gridPane1,"2");
						
						turn.cleanboard(gridPane1);
						turn.cleanboard(gridPane2);
						turn.getComputerShips();
						
					}
				});
				
			}
		});
		score.getChildren().addAll(turn.getLabel1(),helper,backButton,resetButton,exit, turn.getLabel2());
		// Nested for loops are used to populate two 10x10 boards with 100 buttons.
		turn.getComputerShips();
		
		hbox.getChildren().addAll(gridPane1, gridPane2);
		vbox.getChildren().addAll(hbox, score);
		normal = new Scene(vbox, 1200, 700);
		stage.setScene(normal);
		// scene.setFill(null);

	}

	/**
	 * This method sets up a help screen with game instruction.
	 * 
	 * @param stage JavaFx's stage
	 * @return VBox JavaFx's VBox
	 */
	private void helper(Stage stage, String mode) {
		// Secondary scene layout
		Button backButton = new Button("BACK");
		
		backButton.setStyle("-fx-text-fill: black;" + 
				"    -fx-font-family: Arial Narrow;" + 
				"    -fx-font-weight: bold;" + 
				"    -fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);" + 
				"-fx-font-size: 22px;");
		
		backButton.setTranslateX(525);
		backButton.setTranslateY(60);
		
		if(mode=="Normal")
		backButton.setOnAction(e -> stage.setScene(normal));
		if(mode=="Timed")
			backButton.setOnAction(e -> stage.setScene(timed));
		if(mode=="Menu")
			backButton.setOnAction(e -> stage.setScene(menu));
		
		// Help screen title and message.
		String helpTitle = "\n" + "\t\t\t\t\t\t" + "GAME INSTRUCTION";
		String helpMessage = "\n" +
				"\t\tBattleship is a classic board game that brings back lots of childhood and family memory, as well as the moments of surprise! \n"
				+ "\n"
				+ "\t\tSteps: \n"
				+ "\n"
				+ "\t\t1. The user will be able place their ships on the left-hand side board. \n"
				+ "\t\t    Left mouse clicks will place ships horizontally and right mouse clicks will place ships vertically. \n"
				+ "\n"
				+ "\t\t2. Computer's ships will be placed on the right-hand side board once all the user's ships have been placed \n"
				+ "\t\t    Computer's ships are hidden to ensure the game rules and fairness are followed.\n" 
				+ "\n"
				+ "\t\t3. Click on the tile of the right-hand side board to attack computer's ships. \n"
				+ "\t\t    Once a ship is hit, the tile turns red. The tiles would turn grey once a ship is sunken. \n"
				+ "\n"
				+ "\t\t4. The game ends when one side's ships are all sunken. \n"
				+ "\n"
				+ "\t\tTimed mode: Please ensure to click on the start button to start the timer once you have placed all five ships.\n"
				+ "\n"
				+ "\t\tThank you for playing our Battleship game!";

		// Adjust scene, title and message's styles - font, size and background colour.	
		Label labelHelpScene = new Label(helpMessage);
		Label labelHelpTitle = new Label(helpTitle);
		
		labelHelpScene.setTextFill(Color.web("WHITE"));
		labelHelpScene.setFont(new Font("Arial", 18));
		
		labelHelpTitle.setTextFill(Color.web("WHITE"));
		labelHelpTitle.setFont(new Font("Arial", 30));
		
		String styleHelp = "-fx-background-color: #000 000;";
		VBox helpSceneLayout = new VBox(20);
		helpSceneLayout.setStyle(styleHelp);
		
		helpSceneLayout.getChildren().addAll(labelHelpTitle, labelHelpScene, backButton);
		Scene helper= new Scene(helpSceneLayout,1200,700);
		stage.setScene(helper) ;

	}

	/**
	 * This method sets up a new game mode: Timed Mode.
	 */
	private void timedBattleship() {
		VBox vbox = new VBox(20);
		HBox hbox = new HBox(100);
		HBox score = new HBox(40);
		HBox time = new HBox(40);
		gridPane1.setTranslateX(30);
		handler.check(true,"Timed");
		turn.newBoard();
		turn.cleanboard(gridPane1);
		turn.nullify(gridPane2);
		timeSeconds = STARTTIME;
		timerLabel.setText(timeSeconds.toString());
		unnullify(gridPane1,"2");
		
		
		turn.cleanboard(gridPane2);
		
		
		String style1 = "-fx-background-color: #000 000;";
		vbox.setStyle(style1);
		score.setStyle(style1);
		hbox.setStyle(style1);
		time.setStyle(style1);
		
		vbox.prefWidthProperty().bind(stage.widthProperty().multiply(1));

		turn.humanboard(gridPane1);
	
		
		score.setPadding(new Insets(0, 200, 0, 400));
	
		backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handler=new HandleButton();
				turn.newBoard();
				unnullify(gridPane1,"2");
				
				turn.cleanboard(gridPane1);
				
				
			}
		});
		
		exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				
				MainMenu(stage);
			}});
		helper.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				helper(stage, "Timed");
				}});	
		Button button = new Button();
		button.setText("Press after setting ships");
		button.setStyle("-fx-text-fill: black;" + 
				"    -fx-font-family: Arial Narrow;" + 
				"    -fx-font-weight: bold;" + 
				"    -fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);" + 
				
				"-fx-font-size:18px;");
		resetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				handler=new HandleButton();
				turn.newBoard();
				unnullify(gridPane1,"2");
				
				turn.cleanboard(gridPane1);
				turn.cleanboard(gridPane2);
				
				
				
				timeline.stop();
				timeSeconds = STARTTIME;
				timerLabel.setText(timeSeconds.toString());
				backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						handler=new HandleButton();
						turn.newBoard();
						unnullify(gridPane1,"2");
						
						turn.cleanboard(gridPane1);
						
						
					}
				});
				
			
			}
		});
		
		// Configure the Label
		timerLabel.setText(timeSeconds.toString());
		timerLabel.setTextFill(Color.RED);
		timerLabel.setStyle("-fx-font-size: 4em;");

		// Create and configure the Button
		
		
		button.setOnAction(new EventHandler<ActionEvent>() { // Button event handler
			@Override
			public void handle(ActionEvent event) {
				turn.getComputerShips();
				unnullify(gridPane2, "Timed");
				timeSeconds = STARTTIME;

				// update timerLabel
				timerLabel.setText(timeSeconds.toString());
				timeline = new Timeline();
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
					// KeyFrame event handler
					public void handle(ActionEvent event) {
						timeSeconds--;
						// update timerLabel
						timerLabel.setText(timeSeconds.toString());
						if (timeSeconds <= 0) {
							{
								timeline.stop();
								turn.nullify(gridPane2);
								ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(), gridPane2,
										turn);
							}
						}
					}
				}));
				timeline.playFromStart();
			}
		});
	
		time.getChildren().addAll(turn.getLabel1(),helper, backButton, resetButton,exit, turn.getLabel2());
		score.getChildren().addAll(timerLabel, button);
		hbox.getChildren().addAll(gridPane1, gridPane2);
		vbox.getChildren().addAll(hbox, time, score);
		timed = new Scene(vbox, 1200, 700);
		stage.setScene(timed);
		// scene.setFill(null);

	}

	/**
	 * @MAIN This is the main that launches the GUI.
	 */
	public static void main(String args[]) {

		launch(args);

	}

	/**
	 * This is an event handler class for GUI. When left button is clicked, Ships
	 * are placed horizontally. When right button is clicked, Ships are placed
	 * vertically.
	 */
	private class HandleButton implements EventHandler<MouseEvent> {
		int ctr = 0;
		boolean increment;
		String mode;
		public void check(boolean a, String m)
		{
			if (a)
				ctr=0;
			mode=m;
		}
		@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x = GridPane.getRowIndex(btn);
			int y = GridPane.getColumnIndex(btn);
			turn.humanboard(gridPane1);
			if (event.getButton().equals(MouseButton.PRIMARY)) {

				increment = turn.hship(x, y, btn, gridPane1, turn.getShipArray()[ctr]);
				if (increment)
					ctr++;

			}
			if (event.getButton().equals(MouseButton.SECONDARY)) {

				increment = turn.vship(x, y, btn, gridPane1, turn.getShipArray()[ctr]);
				if (increment)
					ctr++;

			}
			if (ctr == 5) {
				turn.nullify(gridPane1);
				if(mode!="Timed")
				unnullify(gridPane2, "Normal");
				
			}
		}

	}

	/**
	 * This is an event handler class for GUI in Regular Mode.
	 */
	private class Handle implements EventHandler<MouseEvent> {
		int ctr = 0;

		@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x = GridPane.getRowIndex(btn);
			int y = GridPane.getColumnIndex(btn);
			
				
			turn.ht(x, y, btn, gridPane2);
			// turn.sinkComputer();
			
			backButton.setOnMouseClicked(null);
			turn.computerTurn(gridPane1, ctr);
			ctr++;
			
			
			if (turn.getHumanShipsRemaining() <= 0 || turn.getComputerShipsRemaining() <= 0) {
				turn.nullify(gridPane2);
				ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(), gridPane2, turn);
				resetButton.setText("Play Again");
			}

		}

	}

	/**
	 * This is an event handler class for GUI in Timed Mode.
	 */
	private class HandleTimed implements EventHandler<MouseEvent> {
		int ctr = 0;

		@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x = GridPane.getRowIndex(btn);
			int y = GridPane.getColumnIndex(btn);
			turn.ht(x, y, btn, gridPane2);
			// turn.sinkComputer();
			backButton.setOnMouseClicked(null);
			turn.computerTurn(gridPane1, ctr);
			ctr++;

			if (turn.getHumanShipsRemaining() == 0 || turn.getComputerShipsRemaining() == 0) {
				turn.nullify(gridPane2);
				ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(), gridPane2, turn);
				timeline.stop();
				resetButton.setText("Play Again");
			}

		}

	}

	/**
	 * This method determines how button click is handled based on the game mode
	 * being either Regular or Timed.
	 * 
	 * @param grid JavaFx's gridPane
	 * @param type Game mode: Regular or Timed.
	 */
	public void unnullify(GridPane grid, String type) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {

				Node n = turn.getNodeFromGridPane(grid, j, i);
				if (type == "Normal")
					n.setOnMouseClicked(handle);
				if (type == "Timed")
					n.setOnMouseClicked(handle1);
				if(type=="2")
					n.setOnMouseClicked(handler);
			}
	}

	/**
	 * @param stage
	 * @param normal
	 * @param timed
	 * @return
	 */
	private void MainMenu(Stage stage) {
		Image background = new Image("file:1200x700 MainMenu.png");
		ImageView imBackground = new ImageView(background);

		
		Button exitButton = new Button();
		exitButton.setTranslateX(1127);
		exitButton.setTranslateY(3);
		exitButton.setGraphic(new ImageView("file:ExitButton.png"));
		exitButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
		exitButton.setStyle("-fx-background-color: transparent;");

		Button musicButton = new Button();
		musicButton.setTranslateX(1050);
		musicButton.setTranslateY(3);
		musicButton.setGraphic(new ImageView("file:MusicON.png"));
		musicButton
				.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
		musicButton.setStyle("-fx-background-color: transparent;");

		Button helpButton = new Button();
		helpButton.setTranslateX(435);
		helpButton.setTranslateY(557);
		helpButton.setGraphic(new ImageView("file:HelpButton.png"));
		helpButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
		helpButton.setStyle("-fx-background-color: transparent;");

		Button regularButton = new Button();
		regularButton.setTranslateX(100);
		regularButton.setTranslateY(485);
		regularButton.setGraphic(new ImageView("file:Regular.png"));
		regularButton
				.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
		regularButton.setStyle("-fx-background-color: transparent;");

		Button timedButton = new Button();
		timedButton.setTranslateX(100);
		timedButton.setTranslateY(555);
		timedButton.setGraphic(new ImageView("file:Timed.png"));
		timedButton
				.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
		timedButton.setStyle("-fx-background-color: transparent;");

		Group root = new Group();
		root.getChildren().addAll(imBackground);
		root.getChildren().addAll(regularButton);
		root.getChildren().addAll(timedButton);
		root.getChildren().addAll(exitButton);
		root.getChildren().addAll(musicButton);
		root.getChildren().addAll(helpButton);

		regularButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				normalBattleship();

			}
		});

		timedButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				timedBattleship();

			}
		});
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
					stage.close();
				
			}
		});
		
		
		//MUSIC CODE

		Media sound = new Media(new File("battleshipMusic.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

		// This button changes between Music ON and Music OFF through user interaction
		musicButton.setOnAction(new EventHandler<ActionEvent>() {

			private boolean musicFlag = true;

			@Override
			public void handle(ActionEvent event) {
				if (musicFlag == true) {
					musicButton.setGraphic(new ImageView("file:MusicOFF.png"));
					musicButton.setStyle(
							"  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");

					mediaPlayer.play();
					musicFlag = false;
				} else if (musicFlag == false) {
					musicButton.setGraphic(new ImageView("file:MusicON.png"));
					musicButton.setStyle(
							"  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");

					mediaPlayer.stop();
					musicFlag = true;
				}
			}
		});

		//END OF MUSIC CODE
		
		// This button will take us to a new scene for more help options
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (event.getSource() == helpButton) {
				helper(stage,"Menu");
				}
			}
		});
		menu=new Scene(root,1200,700);
		stage.setScene(menu);
		stage.setTitle("Battleship");
		stage.setResizable(false);

		stage.show();
	}

	@Override
	public void handle(ActionEvent arg0) {
		
	}
}
