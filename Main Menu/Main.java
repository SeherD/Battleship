package battleshipMusic;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * This class, Main extends from Application and implements Event Handler
 * @author T2G6: Seher Dawar, Tian Xia, Jessica Tran and Spencer Luong.
 */

public class music extends Application implements EventHandler<ActionEvent>{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		
		stage.setTitle("BATTLESHIP");
		
		// Set the background for the scene
		Image background = new Image("file:1200x700 MainMenu.png");
		ImageView imBackground = new ImageView(background);
		
        Button regularButton = new Button();
        regularButton.setTranslateX(100);
        regularButton.setTranslateY(485);
        regularButton.setGraphic(new ImageView("file:Regular.png"));
        regularButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        regularButton.setStyle("-fx-background-color: transparent;");
        
        Button timedButton = new Button();
        timedButton.setTranslateX(100);
        timedButton.setTranslateY(555);
        timedButton.setGraphic(new ImageView("file:Timed.png"));
        timedButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        timedButton.setStyle("-fx-background-color: transparent;");
       
        Button musicButton = new Button();
        musicButton.setTranslateX(1127);
        musicButton.setTranslateY(3);
        musicButton.setGraphic(new ImageView("file:MusicON.png"));
        musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        musicButton.setStyle("-fx-background-color: transparent;");
        	
        Button helpButton = new Button();
        helpButton.setTranslateX(415);
        helpButton.setTranslateY(555);
        helpButton.setGraphic(new ImageView("file:HelpButton.png"));
        helpButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        helpButton.setStyle("-fx-background-color: transparent;");
         
		Group root = new Group();
		root.getChildren().addAll(imBackground);
		root.getChildren().addAll(regularButton);
		root.getChildren().addAll(musicButton);
		root.getChildren().addAll(helpButton);
		root.getChildren().addAll(timedButton);
		
		Scene scene = new Scene(root, 1200, 700);
		stage.setScene(scene);
		// Set to false if you don't want resize your scene
		stage.setResizable(false);
		stage.show();
		
		regularButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		// Regular Game Mode
        public void handle(ActionEvent event) {
			if (event.getSource() == regularButton) {
				System.out.println("Regular Game Button Clicked");
				}
			}
		});
		// Timed Game Mode
				timedButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
			        public void handle(ActionEvent event) {
						if (event.getSource() == timedButton) {
							System.out.println("Timed Game Button Clicked");
						}
					}
				});	
		
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
					musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Music ON");
					mediaPlayer.play();
					musicFlag = false;
				} else if (musicFlag == false) {
					musicButton.setGraphic(new ImageView("file:MusicON.png"));
					musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Music OFF");
					mediaPlayer.stop();
					musicFlag = true;
				}
			}
		});
		// This button will probably take us to a new scene for more help options
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				if (event.getSource() == helpButton) {
					System.out.println("Help Button Clicked");
				}
			}
		});
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}