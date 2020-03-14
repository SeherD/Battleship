import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class, Main extends from Application and implements Event Handler
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 */

public class Main extends Application implements EventHandler<ActionEvent>{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		
		stage.setTitle("BATTLESHIP");
		
		// Set the background for the scene
		Image background = new Image("file:1200x700 MainMenu.png");
		ImageView imBackground = new ImageView(background);
		
        Button startButton = new Button();
        startButton.setTranslateX(100);
        startButton.setTranslateY(485);
        startButton.setGraphic(new ImageView("file:StartButton.png"));
        startButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        startButton.setStyle("-fx-background-color: transparent;");
       
        Button musicButton = new Button();
        musicButton.setTranslateX(1127);
        musicButton.setTranslateY(3);
        musicButton.setGraphic(new ImageView("file:MusicON.png"));
        musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        musicButton.setStyle("-fx-background-color: transparent;");
        	
        Button helpButton = new Button();
        helpButton.setTranslateX(435);
        helpButton.setTranslateY(557);
        helpButton.setGraphic(new ImageView("file:HelpButton.png"));
        helpButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        helpButton.setStyle("-fx-background-color: transparent;");
        
        // This button should be a combo box, it is button right now to show it's placement of scene
        Button modeButton = new Button();
        modeButton.setTranslateX(435);
        modeButton.setTranslateY(485);
        modeButton.setGraphic(new ImageView("file:ModeButton.png"));
        modeButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        modeButton.setStyle("-fx-background-color: transparent;");
         
		Group root = new Group();
		root.getChildren().addAll(imBackground);
		root.getChildren().addAll(startButton);
		root.getChildren().addAll(musicButton);
		root.getChildren().addAll(helpButton);
		root.getChildren().addAll(modeButton);
		
		Scene scene = new Scene(root, 1200, 700);
		stage.setScene(scene);
		// Set to false if you don't want resize your scene
		stage.setResizable(false);
		stage.show();
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		// This button will take us to the game play scene
        public void handle(ActionEvent event) {
			if (event.getSource() == startButton) {
				startButton.setGraphic(new ImageView("file:StartButtonClicked.png"));
				startButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
			    startButton.setStyle("-fx-background-color: transparent;");
				System.out.println("Start Button Clicked");
				}
			}
		});
		// Not sure how to make this button change from Music ON and Music OFF yet
		musicButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				if (event.getSource() == musicButton) {
					musicButton.setGraphic(new ImageView("file:MusicOFF.png"));
					musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Music OFF");
				}
			}
		});
		// This button will take us to a new scene for more help options
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				if (event.getSource() == helpButton) {
					helpButton.setGraphic(new ImageView("file:HelpButtonClicked.png"));
					helpButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					helpButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Help Button Clicked");
				}
			}
		});
		// Mode button should be a combo box
		modeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				if (event.getSource() == modeButton) {
					System.out.println("Mode Button Clicked");
				}
			}
		});	
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
