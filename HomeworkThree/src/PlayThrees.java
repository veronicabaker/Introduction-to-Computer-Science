
import java.util.Scanner;
public class PlayThrees 
{
	public static void main(String[] args)
	{
		//initialize score, current & previous number of pins
		int score = 0;
		int numberPinned = 0;
		int oldNumberPinned = 0;
		//string to hold player's choices
		String dicePinned = "";
		//array to hold player's choices as ints
		int[] pinnedDice = new int[5];
		Scanner input = new Scanner(System.in);
		//we are going to call the dice roll method until 5 numbers are pinned
		while(numberPinned < 5)
		{
			int [] results = rollDie(numberPinned);
			//if there are less than 4 pins,
			//it's the players choice to pin
			if(numberPinned < 4)
			{
				System.out.println("Enter numbers of dice to pin... "
					+ "for example, to pin the die 1 and 2, enter 12):");
				dicePinned += input.next();
			}
			//otherwise, the last number is pinned automatically
			else if(numberPinned == 4)
			{
				System.out.println("Automatically pin last die");
				dicePinned += "1";
			}
			//put integers into our array!
			for(int i = 0; i < dicePinned.length(); i++)
			{
				char c = dicePinned.charAt(i);
				pinnedDice[i] = Character.getNumericValue(c);
			}
			//increment how many pins were done
			//hold onto the old value for reference
			oldNumberPinned = numberPinned;
			numberPinned = dicePinned.length();
			//compute the score
			for(int i = oldNumberPinned; i < dicePinned.length(); i++)
			{
				score += results[pinnedDice[i] - 1];
			}
		}
		System.out.println("your score is " + score);
		input.close();
		
	}
	//rolls dice based on how many still need to be pinned
	//prints dice rolls
	//returns the actual face results of the dice
	public static int[] rollDie(int numberPinned)
	{
		int[] rollResults = new int[5 - numberPinned];
		char [] dieFaces = {'\u2680', '\u2681', '\u2682', 
				'\u2683', '\u2684', '\u2685'};
		for(int i = 1; i <= (5 - numberPinned); i++)
		{
			int dieRoll = (int)(Math.random() * 6 + 1);
			System.out.println("Die Roll " + i + "- " 
					+ (char)dieFaces[(dieRoll - 1)] + "(" + dieRoll + ")");
			rollResults[i - 1] = dieRoll;
		}
		return rollResults;
	}
}
