package Control;
import java.io.File;


import Player.Turn;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import com.sun.glass.utils.*;
public class Launcher extends Application implements EventHandler<ActionEvent> { 
	GridPane gridPane1 = new GridPane(); 
	   GridPane gridPane2 = new GridPane(); 
	   HandleButton handler=new HandleButton();
	   Handle handle=new Handle();
	   HandleTimed handle1=new HandleTimed();
	   static Utilities ut=new Utilities();
	  Turn turn = new Turn();
	  private static final Integer STARTTIME = 360;
	    private Timeline timeline;
	    private Label timerLabel = new Label();
	    private Integer timeSeconds = STARTTIME;
	 Scene menu,limited,help,normal,timed = null;	 ;
	 Stage stage;
	 public Launcher(){
		   
	   }
   @Override 
   public void start(Stage stage) {      
	   this.stage=stage;
	   	help=new Scene(helpScene(stage),1200,700);
	    
		
		  //normal = new Scene(normalBattleship(stage),1200, 700);
		// timed=  new Scene(timedBattleship(stage),1200, 700);
			menu = new Scene(MainMenu(stage,normal,timed), 1200, 700);
			stage.setScene(menu);
	     stage.setTitle("Battleship"); 
	     stage.setResizable(false);
			
	     stage.show(); 
	     
	      		}
  
	    

	private void normalBattleship() {
		 HBox hbox=new HBox(50);
		  // HBox score=new HBox(20);
		   VBox vbox=new VBox(60);
		   String style1 = "-fx-background-color: #000 000;";
		   vbox.setStyle(style1);
		   String style2 = "-fx-background-color: #FFF 000;";
		   //score.setStyle(style2);
		   hbox.setStyle(style2);
		  
		 //  score.getChildren().addAll(turn.getLabel1(),turn.getLabel2(),turn.getLabel3(),turn.getLabel4());
		   vbox.prefWidthProperty().bind(stage.widthProperty().multiply(1));
		  
		  
		   
			 
			 gridPane1.setPrefSize(500,500); 
			 for(int i=0;i<10;i++)
			 gridPane1.getColumnConstraints().add(new ColumnConstraints(50));
			 gridPane1.setTranslateX(30);
			 gridPane1.setTranslateY(0);
			 gridPane2.setPrefSize(500,500); 
			 for(int i=0;i<10;i++)
				 gridPane2.getColumnConstraints().add(new ColumnConstraints(50));
			 
			 gridPane2.setTranslateX(120);
			 gridPane2.setTranslateY(0);   
		     gridPane1.setGridLinesVisible(true);
		     gridPane2.setGridLinesVisible(true);
		     //Setting the Grid alignment 
		   //  gridPane1.setAlignment(Pos.CENTER_LEFT);
		    // gridPane2.setAlignment(Pos.CENTER_RIGHT);
		     
		    // hbox.setPadding(new Insets(30,30,30,70));
		    
		     
		     turn.getComputerShips();
			for (int i=0;i<10;i++)
				 for(int j=0;j<10;j++)
				 { Button button=new Button();
				 	
				 	button.setMinHeight(50);
				 	button.setMinWidth(50);
					
				 	button.setOnMouseClicked(handler);
					 gridPane1.add(button, i, j);
				 }
			
			
			
		 
			for (int i=0;i<10;i++)
				 for(int j=0;j<10;j++)
				 { Button button =new Button();
				 	button.setMinHeight(50);
				 	button.setMinWidth(50);
					 gridPane2.add(button, i, j);
					 button.setOnMouseClicked(null);
				 }
			
			
			hbox.getChildren().addAll(gridPane1,gridPane2);
			   vbox.getChildren().addAll(hbox);
			normal=new Scene(vbox,1200,700);
			stage.setScene(normal);   
		        //scene.setFill(null);
			  
	}
		private VBox helpScene(Stage stage) {

		
		
			// Secondary scene layout
			Button backButton = new Button("BACK");
			backButton.setOnAction(e -> stage.setScene(menu));
			String helpMessage = "Battleship is played on a board size of 10x10. The input is expected in the following forms to \n" + 
					"where the user want to place their battleships and where they want to attack:\n" + 
					"\n" + 
					"User input is binded with left and right mouse clicks.\n" + 
					"The user will be able place their ships on the left-hand side grid. \n" + 
					"Left mouse clicks will place ships horizontally and right mouse clicks will place ships vertically. \n" + 
					"Users will not be able to overlap ships nor place ships outside of the board. \n" + 
					"Computer's ship placement is randomized and adheres to the same rules as the user.\n" + 
					"\n" + 
					"Once all ships are placed on the board, users will be able to attack their opponent using the right-hand side grid.\n" + 
					"Users can click anywhere on the 10x10 grid, to target and attack their opponent users will left click where they would like the attack. \n" + 
					"The goal of the user is to hit all locations of the opponents ships without losing their ships first. \n" + 
					"If all ships of one player have been destroyed, the game will end and the player with surviving ships wins and a pop up message will \n" + 
					"appear declaring the winner.";

			Label labelSecondaryScene = new Label(helpMessage);
			VBox secondaryLayout = new VBox(20);
			secondaryLayout.getChildren().addAll(labelSecondaryScene, backButton);
			return secondaryLayout;
		
		}
	/*private void timedBattleship() {
		VBox vbox=new VBox();
		HBox hbox=new HBox(50);
		   HBox score=new HBox(20);
		   HBox time=new HBox();
		   int ctr=0;
		   String style1 = "-fx-background-color: #000 000;";
		   vbox.setStyle(style1);
		   String style2 = "-fx-background-color: #FFF 000;";
		   score.setStyle(style2);
		   hbox.setStyle(style2);
		  time.setStyle("-fx-background-color: #000 000;");
		   score.getChildren().addAll(turn.getLabel1(),turn.getLabel2());
		   vbox.prefWidthProperty().bind(stage.widthProperty().multiply(1));
		  
		  
		   
			 
			 gridPane1.setMinSize(200, 200); 
			 for(int i=0;i<10;i++)
			 gridPane1.getColumnConstraints().add(new ColumnConstraints(50));
			 
			 gridPane2.setMinSize(200, 200);
			 for(int i=0;i<10;i++)
				 gridPane2.getColumnConstraints().add(new ColumnConstraints(50));
			 
		         
		     gridPane1.setGridLinesVisible(true);
		     gridPane2.setGridLinesVisible(true);
		     //Setting the Grid alignment 
		     gridPane1.setAlignment(Pos.CENTER_LEFT);
		     gridPane2.setAlignment(Pos.CENTER_RIGHT);
		     
		     hbox.setPadding(new Insets(30,30,30,70));
		    
		     
		    
			for (int i=0;i<10;i++)
				 for(int j=0;j<10;j++)
				 { Button button=new Button();
				 	
				 	button.setMinHeight(50);
				 	button.setMinWidth(50);
					
				 	button.setOnMouseClicked(handler);
					 gridPane1.add(button, i, j);
				 }
			
			
			
		 
			for (int i=0;i<10;i++)
				 for(int j=0;j<10;j++)
				 { Button button =new Button();
				 	button.setMinHeight(50);
				 	button.setMinWidth(50);
					 gridPane2.add(button, i, j);
					 button.setOnMouseClicked(null);}
		 
		        // Configure the Label
		        timerLabel.setText(timeSeconds.toString());
		        timerLabel.setTextFill(Color.RED);
		        timerLabel.setStyle("-fx-font-size: 4em;");
		 
		        // Create and configure the Button
		        Button button = new Button();
		        button.setText("Press after you are done setting ships");
		        button.setOnAction(new EventHandler<ActionEvent>() {  //Button event handler
		        	 @Override
		            public void handle(ActionEvent event) {
		        		 turn.getComputerShips();
		        		 unnullify(gridPane2,"Timed");
		                timeSeconds = STARTTIME;
		         
		                // update timerLabel
		                timerLabel.setText(timeSeconds.toString());
		                timeline = new Timeline();
		                timeline.setCycleCount(Timeline.INDEFINITE);
		                timeline.getKeyFrames().add(
		                        new KeyFrame(Duration.seconds(1),
		                          new EventHandler<ActionEvent>() {
		                            // KeyFrame event handler
		                            public void handle(ActionEvent event) {
		                                timeSeconds--;
		                                // update timerLabel
		                                timerLabel.setText(
		                                      timeSeconds.toString());
		                                if (timeSeconds <= 0) {
		                                    {timeline.stop();
		                                    turn.nullify(gridPane2);
		    								ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(),gridPane2,turn);
		                                    }
		                                }
		                              }
		                        }));
		                timeline.playFromStart();
		            }
		        });
		        time.getChildren().addAll(timerLabel,button);
			
			hbox.getChildren().addAll(gridPane1,gridPane2);
			   vbox.getChildren().addAll(hbox,time,score);
			  timed=new Scene(vbox,1200,700);
			  stage.setScene(timed);   
		        //scene.setFill(null);
			  
	}
*/
   public static void main(String args[]){ 
	   
      
     
      //turn.getUserShips();
		//ut.intro();
		launch(args);
		//turn.switchTurns();
      
   } 
   
   private class HandleButton implements EventHandler<MouseEvent> {
	   int ctr=0;
	   boolean increment;  
	   
	  	@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x=GridPane.getRowIndex(btn);
			  int y=GridPane.getColumnIndex(btn);
			  if(event.getButton().equals(MouseButton.PRIMARY)){
		    		 
					 System.out.println(""+x+y+ctr);
					 increment=turn.hship(x, y,btn,gridPane1,turn.getShipArray()[ctr]);
					 if(increment)
						 ctr++;
		    		
						
		}
			  if(event.getButton().equals(MouseButton.SECONDARY)){
		    		 
					 System.out.println(""+x+y+ctr);
					increment=turn.vship(x, y,btn,gridPane1,turn.getShipArray()[ctr]);
					 if(increment)
						 ctr++;
					
			  }	
			  if (ctr==5)
			  		{turn.nullify(gridPane1);
			  		unnullify(gridPane2,"Normal");}
   }
	  
	  	
   }
   
   
   private class Handle implements EventHandler<MouseEvent> {
	   int ctr=0;  
	   
	  	@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x=GridPane.getRowIndex(btn);
			  int y=GridPane.getColumnIndex(btn);
			  turn.ht(x, y, btn,gridPane2);
				//turn.sinkComputer();
		       
		       
				turn.computerTurn(gridPane1,ctr);
				ctr++;
		    
		     
			if(turn.getHumanShipsRemaining()<=0 || turn.getComputerShipsRemaining()<=0 ) {turn.nullify(gridPane2);
			ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(),gridPane2,turn);}
			
			
		}
			  
 
	  	
   }
   private class HandleTimed implements EventHandler<MouseEvent> {
	   int ctr=0;  
	   
	  	@Override
		public void handle(MouseEvent event) {
			Button btn = (Button) event.getSource();
			int x=GridPane.getRowIndex(btn);
			  int y=GridPane.getColumnIndex(btn);
			  turn.ht(x, y, btn,gridPane2);
				//turn.sinkComputer();
		       
		       
				turn.computerTurn(gridPane1,ctr);
				ctr++;
		    
		     
			if(turn.getHumanShipsRemaining()==0 || turn.getComputerShipsRemaining()==0 ) {turn.nullify(gridPane2);
			ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(),gridPane2,turn);
			timeline.stop();}
			
			
		}
			  
 
	  	
   }
   public void unnullify(GridPane grid,String type) {
		for (int i=0;i<10;i++)
			for (int j=0;j<10;j++) {
				
					Node n=turn.getNodeFromGridPane(grid , j, i);
					if(type=="Normal")
					n.setOnMouseClicked(handle);
					if(type=="Timed")
					n.setOnMouseClicked(handle1);
			}
	}
   
  
private Group MainMenu(Stage stage, Scene normal,Scene timed) {
	   Image background = new Image("file:1200x700 MainMenu.png");
		ImageView imBackground = new ImageView(background);
		
     /* Button startButton = new Button();
      startButton.setTranslateX(115);
      startButton.setTranslateY(490);
      startButton.setGraphic(new ImageView("file:StartButton.png"));
      startButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
      startButton.setStyle("-fx-background-color: transparent;");
   
     */
      Button exitButton = new Button();
      exitButton.setTranslateX(925);
      exitButton.setTranslateY(3);
      exitButton.setGraphic(new ImageView("file:ExitButton.png"));
      exitButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
      exitButton.setStyle("-fx-background-color: transparent;");
      
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
			
				//startButton.setGraphic(new ImageView("file:StartButtonClicked.png"));
				//startButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
			    //startButton.setStyle("-fx-background-color: transparent;");
				System.out.println("Timed Button Clicked");
				//timedBattleship();
				
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
		try {
			/*Media sound = new Media(new File("battleshipMusic.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		*/
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
					//mediaPlayer.play();
					musicFlag = false;
				} else if (musicFlag == false) {
					musicButton.setGraphic(new ImageView("file:MusicON.png"));
					musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Music OFF");
					//mediaPlayer.stop();
					musicFlag = true;
				}
			}
		});}
		catch(Exception e)
		{
			System.out.print(e);
		}
		/*musicButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		  public void handle(ActionEvent event) {
				if (event.getSource() == musicButton) {
					musicButton.setGraphic(new ImageView("file:MusicOFF.png"));
					musicButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					musicButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Music OFF");
				}
			}
		});*/
		// This button will take us to a new scene for more help options
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				if (event.getSource() == helpButton) {
					helpButton.setGraphic(new ImageView("file:HelpButtonClicked.png"));
					helpButton.setStyle("  -fx-border-style: none; -fx-border-width: 2px; -fx-border-insets: 0; -fx-font-size:4px");
					helpButton.setStyle("-fx-background-color: transparent;");
					System.out.println("Help Button Clicked");
					stage.setScene(help);
				}
			}
		});
		return root;
   }
@Override
public void handle(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}