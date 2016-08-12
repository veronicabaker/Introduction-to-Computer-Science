/*
 * Veronica Baker
 * Intro to CS -0004
 */
public class Cards 
{
	public static void main(String[] args)
	{
		System.out.println("Shuffling the Deck!");
		// find a random number between 0 and 12, this will determine the face
		int card = (int)(Math.random() * 12);
		//create an empty string to hold the final card
		String yourCard = "";
		//Account for Aces, Jacks, Queens, and Kings
		if(card == 0)
		{
			yourCard += "A";
		}
		else if(card == 10)
		{
			yourCard += "J";
		}
		else if(card == 11)
		{
			yourCard += "Q";
		}
		else if(card == 12)
		{
			yourCard += "K";
		}
		else
		{
			//since random starts 0 not 1, we add 1
			yourCard += card + 1;
		}
		//Now find a random number between 0 and 3 this will determine the suit
		//randomizing the suit separately from the face does not change anything
		// the simualtion will behave like a  deck of cards still
		//1/52 = 1/4 *1/13
		int suit = (int)(Math.random() *4);
		if(suit == 3)
		{
			yourCard += (char)'\u2663';
		}
		else if(suit == 2)
		{
			yourCard += (char)'\u2666';
		}
		else if(suit == 1)
		{
			yourCard += (char)'\u2665';
		}
		else
		{
			yourCard += (char)'\u2660';
		}
		//Give feedback to the user
		System.out.println("Your card is: " + yourCard);
	}
}
