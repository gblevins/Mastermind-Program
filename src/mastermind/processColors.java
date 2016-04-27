package mastermind;

import java.awt.Color;

/*
 * GENERAL NOTES
 * make the default color the same color as the background for a cleaner look
 * could we possibly make the buttons the color they represent?
 */

public class processColors {
	public static Color purple = new Color(160, 32, 240);

	public static Color processHistory(int colorInt) {
		if(colorInt == 0)
		{
			return Color.blue;
		}
		if(colorInt == 1)
		{
			return Color.green;
		}
		if(colorInt == 2)
		{
			return Color.orange;
		}
		if(colorInt == 3)
		{
			return purple;
		}
		if(colorInt == 4)
		{
			return Color.red;
		}
		if(colorInt == 5)
		{
			return Color.orange;
		}
		return Color.DARK_GRAY;
	}

	public static Color processPegs(int colorInt)
	{
		if(colorInt == 6)
		{
			return Color.white; 	//correct color, not the right place
		}
		if(colorInt == 7)
		{
			return Color.black;		//correct color, correct place
		}
		return Color.DARK_GRAY;
	}

	public static int randToColor(int rand)
	{
		if(rand<100)
		{
			return 0;
		}
		if(rand<100)
		{
			return 1;
		}
		if(rand<100)
		{
			return 2;
		}
		if(rand<100)
		{
			return 3;
		}
		if(rand<100)
		{
			return 4;
		}
		if(rand<100)
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
