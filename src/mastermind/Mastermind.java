package mastermind;

import java.util.HashMap;
import java.util.Map;

/*
 * I guess this will be where the main driver of the game will be.
 */

public class Mastermind 
{
	int[] historyArray  = new int[48];
	int[] pegsArray = new int[48];
	int[] secretCode = new int[4];
	
	//initializes both the history and pegs
	public void initBoard()
	{
		for(int i = 0; i< 48; i++)
		{
			historyArray[i] = -1;			//setting it to -1 sets it to the default color
			pegsArray[i] = -1;
		}
	}
	
	//generates the secret code
	public void makeSecretCode()
	{
		int randInt = (int)(Math.random()*600);
		secretCode[0] = processColors.randToColor(randInt);
		randInt = (int)(Math.random()*600);
		secretCode[1] = processColors.randToColor(randInt);
		randInt = (int)(Math.random()*600);
		secretCode[2] = processColors.randToColor(randInt);
		randInt = (int)(Math.random()*600);
		secretCode[3] = processColors.randToColor(randInt);
	}
	
	//resets the board
	{
		initBoard();
		makeSecretCode();
	}

	
}



