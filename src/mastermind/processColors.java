package mastermind;

import java.awt.Color;

public class processColors {
	Color purple = new Color(160, 32, 240);
	public Color process(int colorInt){
		if(colorInt == 0)
		{
			return Color.blue;
		}
		if(colorInt == 0)
		{
			return Color.green;
		}
		if(colorInt == 0)
		{
			return Color.orange;
		}
		if(colorInt == 0)
		{
			return purple;
		}
		if(colorInt == 0)
		{
			return Color.red;
		}
		if(colorInt == 0)
		{
			return Color.orange;
		}
		return Color.DARK_GRAY;
	}
}
