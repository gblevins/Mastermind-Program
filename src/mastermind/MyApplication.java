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
	Button redButton;
	Button blueButton;
	Button blackButton;
	Button greenButton;
	
	// initialize the buttons
	@Override
	public void init() throws Exception {
		redButton = new Button();
		redButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #FF0000;"
		);
		redButton.setLayoutX(290);
		redButton.setLayoutY(600);

		blueButton = new Button();
		blueButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #0000ff;"
		);
		blueButton.setLayoutX(325);
		blueButton.setLayoutY(600);

		blackButton = new Button();
		blackButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #000000;"
		);
		blackButton.setLayoutX(360);
		blackButton.setLayoutY(600);

		greenButton = new Button();
		greenButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #008000;"
		);
		greenButton.setLayoutX(395);
		greenButton.setLayoutY(600);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// the board
		Rectangle board = new Rectangle(250, 25, 375, 625);
		board.setFill(Color.DEEPPINK);
		Group root = new Group(board);
		// the buttons (have already been initialized
		root.getChildren().add(redButton);
		root.getChildren().add(blueButton);
		root.getChildren().add(blackButton);
		root.getChildren().add(greenButton);
		// the slots
		for (int k = 0; k < 12; k ++) {
			for (int j = 0; j < 4; j++) {
				Circle circle = new Circle(300 + (j * 40), 575 - (k * 40), 15, Color.DARKGREY);
				root.getChildren().add(circle);
			}
		}
		// the info slots
		for (int k = 0; k < 12; k ++) {
			for (int j = 0; j < 4; j++) {
				Circle circle = new Circle(450 + (j * 25), 575 - (k * 40), 10, Color.LIGHTGREY);
				root.getChildren().add(circle);
			}
		}
		// the hidden code slots
		for (int x = 0; x < 4; x++) {
			Circle circle = new Circle(300 + (x * 40), 95, 15, Color.ANTIQUEWHITE);
			root.getChildren().add(circle);
		}
		// hidden code labels
		for (int y = 0; y < 4; y++) {
			Text t = new Text(295 + (y * 40), 104, "?");
			t.setFont(new Font(25));
			root.getChildren().add(t);
		}
		// the attempt labels
		for (int i = 0; i < 12; i++) {
			Integer num = i + 1;
			Text t = new Text(550, 585 - (40 * i), num.toString());
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
