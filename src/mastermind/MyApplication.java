package mastermind;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.control.Button;

public class MyApplication extends Application {
	Button blueButton;
	Button greenButton;
	Button orangeButton;
	Button purpleButton;
	Button redButton;
	Button yellowButton;

	// initialize the buttons
	@Override
	public void init() throws Exception {
		blueButton = new Button();
		blueButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #0000ff;"
		);
		blueButton.setLayoutX(290);
		blueButton.setLayoutY(600);
		blueButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Blue Button pressed.");
				// TODO handle how the input will be processed
			}
		});

		greenButton = new Button();
		greenButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #008000;"
		);
		greenButton.setLayoutX(325);
		greenButton.setLayoutY(600);
		greenButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Green Button pressed.");
			}
		});

		orangeButton = new Button();
		orangeButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #ffa500;"
		);
		orangeButton.setLayoutX(360);
		orangeButton.setLayoutY(600);
		orangeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Orange Button pressed.");
			}
		});

		purpleButton = new Button();
		purpleButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #800080;"
		);
		purpleButton.setLayoutX(395);
		purpleButton.setLayoutY(600);
		purpleButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Purple Button pressed.");
			}
		});
		
		redButton = new Button();
		redButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #ff0000;"
		);
		redButton.setLayoutX(430);
		redButton.setLayoutY(600);
		redButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Red Button pressed.");
			}
		});
		
		yellowButton = new Button();
		yellowButton.setStyle(
				"-fx-background-radius: 5em; " +
				"-fx-min-width: 30px; " +
				"-fx-min-height: 30px; " +
				"-fx-max-width: 30px; " +
				"-fx-max-height: 30px;" +
				"-fx-background-color: #ffff00;"
		);
		yellowButton.setLayoutX(465);
		yellowButton.setLayoutY(600);
		yellowButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Yellow Button pressed.");
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// the board
		Rectangle board = new Rectangle(250, 25, 375, 625);
		board.setFill(Color.DEEPPINK);
		Group root = new Group(board);
		// the buttons (have already been initialized
		root.getChildren().add(blueButton);
		root.getChildren().add(greenButton);
		root.getChildren().add(orangeButton);
		root.getChildren().add(purpleButton);
		root.getChildren().add(redButton);
		root.getChildren().add(yellowButton);
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
