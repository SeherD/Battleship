import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{
	
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		
		stage.setTitle("Battleship");
		
		// Code to add background image
		Image background = new Image("file:Battleship MainScreen.png");
		ImageView imBackground = new ImageView(background);
		
        Button startButton = new Button();
        startButton.setTranslateX(115);
        startButton.setTranslateY(490);
        startButton.setGraphic(new ImageView("file:StartButton.png"));
        startButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        startButton.setStyle("-fx-background-color: transparent;");
       
        Button exitButton = new Button();
        exitButton.setTranslateX(925);
        exitButton.setTranslateY(3);
        exitButton.setGraphic(new ImageView("file:ExitButton.png"));
        exitButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
        exitButton.setStyle("-fx-background-color: transparent;");
        
		Group root = new Group();
		root.getChildren().addAll(imBackground);
		root.getChildren().addAll(startButton);
		root.getChildren().addAll(exitButton);
		
		Scene scene = new Scene(root, 1000, 700);
		stage.setScene(scene);
		//false if you don't want to resize your form
		stage.setResizable(false);
		stage.show();
		
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
        public void handle(ActionEvent event) {
			if (event.getSource() == startButton) {
				startButton.setGraphic(new ImageView("file:StartButtonClicked.png"));
				startButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
			    startButton.setStyle("-fx-background-color: transparent;");
				System.out.println("Start Button Clicked");
				}
			}
		});
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				if (event.getSource() == exitButton) {
					stage.close();
				}
			}
		}); 
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
