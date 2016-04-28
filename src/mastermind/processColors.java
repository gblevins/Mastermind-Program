package mastermind;

/*
 * Garret Blevins and Malvika Gupta
 * 
 * Used to simplify the use of different colors,
 * converts integers to colors
 */

import javafx.scene.paint.Color;

public class processColors {

	// turns the integer into a color
	public static Color processHistory(int colorInt) {
		if(colorInt == 0)
		{
			return Color.BLUE;
		}
		if(colorInt == 1)
		{
			return Color.GREEN;
		}
		if(colorInt == 2)
		{
			return Color.ORANGE;
		}
		if(colorInt == 3)
		{
			return Color.PURPLE;
		}
		if(colorInt == 4)
		{
			return Color.RED;
		}
		if(colorInt == 5)
		{
			return Color.YELLOW;
		}
		return Color.DARKGREY;
	}

	// turns the integer into a color
	public static Color processPegs(int colorInt)
	{
		if(colorInt == 6)
		{
			return Color.WHITE; 	//correct color, not the right place
		}
		if(colorInt == 7)
		{
			return Color.BLACK;		//correct color, correct place
		}
		return Color.DARKGRAY;
	}

	// turns the integer into a color
	public static int randToColor(int rand)
	{
		if(rand<100)
		{
			return 0;
		}
		if(rand<200)
		{
			return 1;
		}
		if(rand<300)
		{
			return 2;
		}
		if(rand<400)
		{
			return 3;
		}
		if(rand<500)
		{
			return 4;
		}
		if(rand<600)
		{
			return 5;
		}
		else
		{
			System.err.println("You have an issue with randToColor");
			return 6;
		}
	}	
}
