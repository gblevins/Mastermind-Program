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

	Button startButton;
	Button checkButton;
	Button backButton;
	Button resetButton;
	Button quitButton;
	
	Mastermind game;
	Group root;
	Stage stage;

	// initialize the buttons
	@Override
	public void init() throws Exception {
		game = new Mastermind();
		Rectangle board = new Rectangle(250, 25, 375, 625);
		board.setFill(Color.DEEPPINK);
		root = new Group(board);

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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.BLUE);
					root.getChildren().add(circle);
					stage.show();
				}
				else {
					System.out.println("Max code size reached");
				}
				// draw on the board
				// change the arrays
				// see if a complete guess
				// check if correct guess
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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.GREEN);
					root.getChildren().add(circle);
					stage.show();
				}
				else {
					System.out.println("Max code size reached");
				}
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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.ORANGE);
					root.getChildren().add(circle);
					stage.show();
				}
				else {
					System.out.println("Max code size reached");
				}
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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.PURPLE);
					root.getChildren().add(circle);
					stage.show();
				}
				else {
					System.out.println("Max code size reached");
				}
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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.RED);
					root.getChildren().add(circle);
					stage.show();
				}
				else {
					System.out.println("Max code size reached");
				}
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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.YELLOW);
					root.getChildren().add(circle);
					stage.show();
				}
				else {
					System.out.println("Max code size reached");
				}
			}
		});

		startButton = new Button("Start");
		startButton.setLayoutX(20);
		startButton.setLayoutY(300);
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Start Button Pressed.");
			}
		});

		checkButton = new Button("Check");
		checkButton.setLayoutX(20);
		checkButton.setLayoutY(330);
		checkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Check Button Pressed.");
			}
		});
		
		backButton = new Button("Back");
		backButton.setLayoutX(20);
		backButton.setLayoutY(360);
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Back Button Pressed.");
			}
		});

		resetButton = new Button("Reset");
		resetButton.setLayoutX(20);
		resetButton.setLayoutY(390);
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Reset Button Pressed.");
			}
		});

		quitButton = new Button("Quit");
		quitButton.setLayoutX(20);
		quitButton.setLayoutY(420);
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Quit Button Pressed.");
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// the board
		//Rectangle board = new Rectangle(250, 25, 375, 625);
		//board.setFill(Color.DEEPPINK);
		//Group root = new Group(board);
		//root = new Group(board);
		// the buttons (have already been initialized
		root.getChildren().add(blueButton);
		root.getChildren().add(greenButton);
		root.getChildren().add(orangeButton);
		root.getChildren().add(purpleButton);
		root.getChildren().add(redButton);
		root.getChildren().add(yellowButton);
		root.getChildren().add(startButton);
		root.getChildren().add(checkButton);
		root.getChildren().add(backButton);
		root.getChildren().add(resetButton);
		root.getChildren().add(quitButton);
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
		stage = primaryStage;
	}
}
