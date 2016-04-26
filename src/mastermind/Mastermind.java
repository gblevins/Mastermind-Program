package mastermind;

/*
 * I guess this will be where the main driver of the game will be.
 */

public class Mastermind 
{
	int[] historyArray  = new int[48];
	int[] pegsArray = new int[48];
	int[] secretCode = new int[4];
	
	int currentRow = 0;
	
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
	
	//resets the board when the game is over/when you want to start over
	//WHAT HAPPENS WHEN YOU HIT THE RESET BUTTON
	public void resetBoard()
	{
		initBoard();
		makeSecretCode();
		currentRow = 0;
	}
	
	/*
	 * WHAT HAPPENS WHEN YOU PRESS THE CHECK BUTTON
	 * returns whether or not you have won the game
	 * updates history array (not really)
	 * updates the peg array
	 * updates current row
	 */
	
	public boolean checkInput()
	{	int[] tempSecretCode = secretCode;
		int[] currentGuess = new int[4];
		int[] currentPegs = new int[4];
		int currentPegIndex = 0;
		int blackCount = 0;
		int whiteCount = 0;
		//----nope----step 1: update history--> do we want to do this now or as the person is selecting?
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
			if((currentGuess[i]!=-1)&&contains(currentGuess[i],tempSecretCode))
			{
				currentGuess[i] = -1; //make sure it isn't counted twice
				tempSecretCode[i] = -1;
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
		
		//quick error check
		if(whiteCount+blackCount >4)
		{
			System.err.println("You messed up the pegs processing. See the process input function.");
		}
		//step 3: determine if the guess is completely correct
		if(blackCount==4){
			return true;
		}
		return false;
		
	}
	
	public boolean contains(int value, int[] intArray)
	{
		for(int i = 0; i<intArray.length;i++){
			if(intArray[i] == value)
			{
				return true;
			}
		}
		return false;
	}
}
