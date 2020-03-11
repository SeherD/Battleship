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
public class Launcher extends Application { 
	GridPane gridPane1 = new GridPane(); 
	   GridPane gridPane2 = new GridPane(); 
	   HandleButton handler=new HandleButton();
	   static Utilities ut=new Utilities();
	  Turn turn = new Turn();
	  VBox vbox=new VBox(60);
	 Scene scene ;
	 public Launcher(){
		   
	   }
   @Override 
   public void start(Stage stage) {      
	  
	   HBox hbox=new HBox(50);
	   HBox score=new HBox(20);
	   
	   String style1 = "-fx-background-color: #000 000;";
	   vbox.setStyle(style1);
	   String style2 = "-fx-background-color: #FFF 000;";
	   score.setStyle(style2);
	   hbox.setStyle(style2);
	  
	   score.getChildren().addAll(turn.getLabel1(),turn.getLabel2(),turn.getLabel3(),turn.getLabel4());
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
				 button.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							int x=GridPane.getRowIndex(button);
							int y=GridPane.getColumnIndex(button);
							
								
								turn.ht(x, y, button);
						       
						       
								turn.computerTurn(gridPane1);
								
						    
						     
							if(turn.getHumanShipsRemaining()==0 || turn.getComputerShipsRemaining()==0 ) {turn.nullify(gridPane2);
							ut.end(turn.getHumanShipsRemaining(), turn.getComputerShipsRemaining(),gridPane2,turn);}
							
							
						}
					
				 });
			 }
		
		
		hbox.getChildren().addAll(gridPane1,gridPane2);
		   vbox.getChildren().addAll(hbox,score);
		   
	        //scene.setFill(null);
		  
		  scene = new Scene(vbox,1200, 700);
	     //Setting title to the Stage 
	     stage.setTitle("Battleship1"); 
	        
	     //Adding scene to the stage 
	     stage.setScene(scene); 
	        
	     //Displaying the contents of the stage 
	     stage.show(); 
	     
	      		}
   public VBox getPane()
   {return vbox;}
	        
   public Scene getScene()
   {return scene;}
	    

	    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	        for (Node node : gridPane.getChildren())
	            if (GridPane.getColumnIndex(node) != null
	                    && GridPane.getColumnIndex(node) != null
	                    && GridPane.getRowIndex(node) == row
	                    && GridPane.getColumnIndex(node) == col)
	                return node;
	        return null;
	    }
	

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
			var btn = (Button) event.getSource();
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
			  		turn.nullify(gridPane1);
   }
	  	
   }
}