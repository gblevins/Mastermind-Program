package mastermind;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.control.Button;

public class MyApplication extends Application {
 
   @Override
   public void init() throws Exception {
      // Do some heavy lifting
   }
 
   @Override
   public void start(Stage primaryStage) throws Exception {
	   Rectangle board = new Rectangle(250, 25, 500, 625);
	   board.setFill(Color.DEEPPINK);

	   Group root = new Group(board);

	   Button button1 = new Button();
	   button1.setStyle(
               "-fx-background-radius: 5em; " +
               "-fx-min-width: 30px; " +
               "-fx-min-height: 30px; " +
               "-fx-max-width: 30px; " +
               "-fx-max-height: 30px;" +
               "-fx-background-color: #FF0000;"
       );
	   button1.setLayoutX(290);
	   button1.setLayoutY(590);
	   root.getChildren().add(button1);
	   Button button2 = new Button();
	   button2.setStyle(
               "-fx-background-radius: 5em; " +
               "-fx-min-width: 30px; " +
               "-fx-min-height: 30px; " +
               "-fx-max-width: 30px; " +
               "-fx-max-height: 30px;" +
               "-fx-background-color: #0000ff;"
       );
	   button2.setLayoutX(325);
	   button2.setLayoutY(590);
	   root.getChildren().add(button2);
	   Button button3 = new Button();
	   button3.setStyle(
               "-fx-background-radius: 5em; " +
               "-fx-min-width: 30px; " +
               "-fx-min-height: 30px; " +
               "-fx-max-width: 30px; " +
               "-fx-max-height: 30px;" +
               "-fx-background-color: #000000;"
       );
	   button3.setLayoutX(360);
	   button3.setLayoutY(590);
	   root.getChildren().add(button3);
	   Button button4 = new Button();
	   button4.setStyle(
               "-fx-background-radius: 5em; " +
               "-fx-min-width: 30px; " +
               "-fx-min-height: 30px; " +
               "-fx-max-width: 30px; " +
               "-fx-max-height: 30px;" +
               "-fx-background-color: #008000;"
       );
	   button4.setLayoutX(395);
	   button4.setLayoutY(590);
	   root.getChildren().add(button4);
	   
	   //Circle circle = new Circle(300, 600, 20, Color.RED);
	   //root.getChildren().add(circle);
	   //Circle circle1 = new Circle(350, 600, 20, Color.BLACK);
	   //root.getChildren().add(circle1);
	   //Circle circle2 = new Circle(400, 600, 20, Color.BLUE);
	   //root.getChildren().add(circle2);
	   //Circle circle3 = new Circle(450, 600, 20, Color.GREEN);
	   //root.getChildren().add(circle3);
	   
	   for (int i = 0; i < 12; i++) {
		   Integer num = i + 1;
		   Text t = new Text(550, 550 - (25 * i), num.toString());
		   t.setFont(new Font(20));
		   root.getChildren().add(t);
	   }
	   
	   Scene scene = new Scene(root);
	   primaryStage.setWidth(1000);
	   primaryStage.setHeight(700);
	   primaryStage.setTitle("Mastermind Application");
	   primaryStage.setScene(scene);
	   primaryStage.show();
   }
}
