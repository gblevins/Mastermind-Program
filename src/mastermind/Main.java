package mastermind;

/*
 * Garret Blevins and Malvika Gupta
 * 
 * This is the main file that launches the application
 */

import com.sun.javafx.application.LauncherImpl;

public class Main {
	public static void main(String[] args) {
		LauncherImpl.launchApplication(MyApplication.class, MyPreloader.class, args);
	}
}
