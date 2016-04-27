package mastermind;

import java.util.Arrays;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MyApplication extends Application {
	// the color buttons
	private Button blueButton, greenButton, orangeButton, purpleButton, redButton, yellowButton,
	// the operation buttons
	startButton, checkButton, backButton, resetButton, quitButton, restartButton;

	// the game board and operations
	private Mastermind game;
	// three roots make 3 scenes, start, play, game over 
	private Group root1, root2, root3;
	private Scene scene1, scene2, scene3;
	// the current stage being displayed
	private Stage stage;

	// initialize
	@Override
	public void init() throws Exception {
		// initialize the game
		game = new Mastermind();
		
		// initialize scenes
		scene1Init();
		scene2Init();
		scene3Init();
	}

	// initialize the first scene, the start screen
	private void scene1Init() {
		Image pic = new Image("http://venturachamber.com/wp-content/uploads/2015/01/mastermind.jpg");
		ImageView iv1 = new ImageView();
        iv1.setImage(pic);
        
        root1 = new Group();
        scene1 = new Scene(root1);
        
        root1.getChildren().add(iv1);
        
		startButton = new Button("Start");
		startButton.setLayoutX(50);
		startButton.setLayoutY(100);
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Start Button Pressed.");
				stage.setScene(scene2);
			}
		});
		root1.getChildren().add(startButton);
		
	}

	// initialize the second scene, the game screen
	private void scene2Init() {
		// the game board
		Rectangle board = new Rectangle(250, 25, 375, 625);
		board.setFill(Color.ALICEBLUE);
		root2 = new Group(board);
		scene2 = new Scene(root2);

		// initialize the color buttons
		colorButtonsInit();
		menuButtonsInit();
		slotsAndLabelsInit();
	}

	// initialize the third screen, game over
	private void scene3Init() {
		restartButton = new Button("Restart");
		restartButton.setLayoutX(20);
		restartButton.setLayoutY(300);
		restartButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Restart Button Pressed.");
			}
		});
		root3 = new Group(restartButton);
		scene3 = new Scene(root3);
	}

	// initialize the color buttons for the game board
	private void colorButtonsInit() {
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
				if (game.setInput(0)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.BLUE);
					root2.getChildren().add(circle);
				}
				else {
					System.out.println("Max code size reached");
				}
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
				if (game.setInput(1)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.GREEN);
					root2.getChildren().add(circle);
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
				if (game.setInput(2)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.ORANGE);
					root2.getChildren().add(circle);
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
				if (game.setInput(3)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.PURPLE);
					root2.getChildren().add(circle);
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
				if (game.setInput(4)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.RED);
					root2.getChildren().add(circle);
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
				if (game.setInput(5)) {
					Circle circle = new Circle(300 + ((game.getCol() - 1) * 40), 575 - (game.getRow() * 40), 15, Color.YELLOW);
					root2.getChildren().add(circle);
				}
				else {
					System.out.println("Max code size reached");
				}
			}
		});

		root2.getChildren().add(blueButton);
		root2.getChildren().add(greenButton);
		root2.getChildren().add(orangeButton);
		root2.getChildren().add(purpleButton);
		root2.getChildren().add(redButton);
		root2.getChildren().add(yellowButton);
	}

	// initialize the menu buttons for the game board
	private void menuButtonsInit() {
		checkButton = new Button("Check");
		checkButton.setLayoutX(20);
		checkButton.setLayoutY(330);
		checkButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Check Button Pressed.");
				int[] result = game.checkInput();
				System.out.println(Arrays.toString(result));
				if (result[0] == 4) {
					stage.setScene(scene3);
				}
				else {
					int y;
					for (y = 0; y < result[0]; y++){
						Circle circle = new Circle(450 + (y * 25), 575 - ((game.getRow()-1) * 40), 10, Color.BLACK);
						root2.getChildren().add(circle);
					}
					for (int g = 0; g < result[1]; g++){
						Circle circle = new Circle(450 + ((g+y) * 25), 575 - ((game.getRow()-1) * 40), 10, Color.WHITE);
						root2.getChildren().add(circle);
					}
				}
			}
		});

		backButton = new Button("Back");
		backButton.setLayoutX(20);
		backButton.setLayoutY(360);
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Back Button Pressed.");
				if (game.removeLastInput()) {
					root2.getChildren().remove(root2.getChildren().size() - 1);
				}
			}
		});

		resetButton = new Button("Reset");
		resetButton.setLayoutX(20);
		resetButton.setLayoutY(390);
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				System.out.println("Reset Button Pressed.");
				game = new Mastermind();
				scene2Init();
				try {
					start(stage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
		
		root2.getChildren().add(checkButton);
		root2.getChildren().add(backButton);
		root2.getChildren().add(resetButton);
		root2.getChildren().add(quitButton);
	}

	// initialize the slots and labels
	private void slotsAndLabelsInit() {
		// the code slots
		for (int k = 0; k < 12; k ++) {
			for (int j = 0; j < 4; j++) {
				Circle circle = new Circle(300 + (j * 40), 575 - (k * 40), 15, Color.DARKGREY);
				root2.getChildren().add(circle);
			}
		}
		// the code info slots
		for (int k = 0; k < 12; k ++) {
			for (int j = 0; j < 4; j++) {
				Circle circle = new Circle(450 + (j * 25), 575 - (k * 40), 10, Color.LIGHTGREY);
				root2.getChildren().add(circle);
			}
		}
		// the hidden code slots
		for (int x = 0; x < 4; x++) {
			Circle circle = new Circle(300 + (x * 40), 95, 15, Color.ANTIQUEWHITE);
			root2.getChildren().add(circle);
		}
		// hidden code labels
		for (int y = 0; y < 4; y++) {
			Text t = new Text(295 + (y * 40), 104, "?");
			t.setFont(new Font(25));
			root2.getChildren().add(t);
		}
		// the attempt labels
		for (int i = 0; i < 12; i++) {
			Integer num = i + 1;
			Text t = new Text(550, 585 - (40 * i), num.toString());
			t.setFont(new Font(20));
			root2.getChildren().add(t);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setWidth(1000);
		primaryStage.setHeight(700);
		primaryStage.setTitle("Mastermind Application");
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
}
