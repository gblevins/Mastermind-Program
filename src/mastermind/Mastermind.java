package mastermind;

/*
 * Garret Blevins and Malvika Gupta
 * 
 * This all of the actual game logic,
 * keeps track of the board
 * makes secret code
 * checks if game over
 */

import java.util.Arrays;

public class Mastermind 
{
	// guesses that have been entered
	private int[] historyArray  = new int[48];
	// info on the guesses
	private int[] pegsArray = new int[48];
	// the current secret code
	private int[] secretCode = new int[4];

	// 12 rows, so this ranges from 0 to 11
	private int currentRow = 0;
	// 4 columns, so this ranges from 0 to 3
	private int currentColumn = 0;

	// board constructor
	Mastermind () {
		initBoard();
		makeSecretCode();
		System.out.println(Arrays.toString(secretCode));
	}

	// initializes both the history and pegs
	public void initBoard()
	{
		for(int i = 0; i< 48; i++)
		{
			historyArray[i] = -1;	//setting it to -1 sets it to the default color
			pegsArray[i] = -1;
		}
	}

	// generates the secret code
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

	//resets the board when the game is over/when you want to start over
	//WHAT HAPPENS WHEN YOU HIT THE RESET BUTTON
	public void resetBoard()
	{
		initBoard();
		makeSecretCode();
		currentRow = 0;
	}
	
	// get the current row
	public int getRow() {
		return currentRow;
	}
	
	// get the current column
	public int getCol() {
		return currentColumn;
	}
	
	// returns true if a guess is successfully entered, false otherwise
	public boolean setInput(int input)
	{
		// check if 4 guesses have already been made
		if (currentColumn == 4)
			return false;
		historyArray[(currentRow * 4) + currentColumn] = input;
		currentColumn++;
		return true;
	}
	
	// remove the most recent input from the board
	public boolean removeLastInput() {
		// not any input on current column yet
		if (currentColumn == 0) {
			return false;
		}
		historyArray[(currentRow * 4) + currentColumn] = -1;
		currentColumn--;
		return true;
	}

	/*
	 * WHAT HAPPENS WHEN YOU PRESS THE CHECK BUTTON
	 * returns number of black pegs and white pegs as an array [black, white]
	 * updates the peg array
	 * updates current row
	 */
	public int[] checkInput()
	{
		if (currentColumn != 4) {
			int[] result = new int[2];
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		int[] tempSecretCode = secretCode.clone();
		int[] currentGuess = new int[4];
		int[] currentPegs = new int[4];
		int currentPegIndex = 0;
		int blackCount = 0;
		int whiteCount = 0;
		int[] blackWhiteCount = new int[2];

		//step 1: grab input from history
		currentGuess[0] = historyArray[currentRow*4];
		currentGuess[1] = historyArray[currentRow*4+1];
		currentGuess[2] = historyArray[currentRow*4+2];
		currentGuess[3] = historyArray[currentRow*4+3];

		//step 2: update pegs
		//find the black pegs
		for(int i = 0; i<4; i++)
		{
			if(currentGuess[i]==tempSecretCode[i])
			{
				currentGuess[i] = -1; //make sure it isn't counted twice
				tempSecretCode[i] = -1;
				blackCount++;
				currentPegs[currentPegIndex]= 7; //black
				currentPegIndex++;
			}
		}

		//find the white pegs
		for(int i = 0; i<4; i++)
		{
			if((currentGuess[i]!=-1)&&((contains(currentGuess[i],tempSecretCode))!=-1))
			{
				tempSecretCode[contains(currentGuess[i],tempSecretCode)] = -1;
				currentGuess[i] = -1; //make sure it isn't counted twice
				whiteCount++;
				currentPegs[currentPegIndex]= 6; //white
				currentPegIndex++;

			}
		}

		pegsArray[currentRow*4] = currentPegs[0];
		pegsArray[currentRow*4+1] = currentPegs[1];
		pegsArray[currentRow*4+2] = currentPegs[2];
		pegsArray[currentRow*4+3] = currentPegs[3];

		currentRow++;
		currentColumn = 0;

		//quick error check
		if(whiteCount+blackCount >4)
		{
			System.err.println("You messed up the pegs processing. See the process input function.");
		}
		
		blackWhiteCount[0] = blackCount;
		blackWhiteCount[1] = whiteCount;
		
		return blackWhiteCount;
	}
		
	/*helper method for check win
	 * Returns index of value within an array
	 * if the value is not found, it returns -1
	 */

	// returns the current secret code
	public int[] getSecretCode() {
		return secretCode;
	}
	
	// does the array contain the value
	public int contains(int value, int[] intArray)
	{
		for(int i = 0; i < intArray.length;i++){
			if(intArray[i] == value)
			{
				return i;
			}
		}
		return -1;
	}
}
