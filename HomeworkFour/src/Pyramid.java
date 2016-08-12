/*
 * Veronica Baker
 * Intro to CS -004
 * 
 * Comments include information about intended functionality as well as testing methods
 */
import java.util.Scanner;
public class Pyramid 
{
	public static void main(String[] args)
	{
		//create scanner object
		Scanner input = new Scanner(System.in);
		//get input
		System.out.println("Please enter the height of your pyramid");
		int height = input.nextInt();
		//loop over each row that will be printed
		//i keeps track of row #
		for(int i = 0; i < height; i++)
		{
			//figure out the difference between the length of height and the length of i
			//we want one extra space for each time there is a new 0 place
			//ie if height is < 100 we want on extra space for i < 11
			//if height is > 100 we want an extra space in the tens and ones and an extra space in the ones
			//we will use this variable in our method
			//this is named for the way the method works and was tested
			int numberOfYSpaces = (height + "").length() - (i + 1 + "").length();
			//initialize line as a string
			String pyramidLine = "";
			//loop over the part of the string that is just spaces and determine how many spaces there will be
			//x is the
			for(int x = 1; x <= (height - 1 - i); x++)
			{
				//call our method to add spaces
				pyramidLine += howManySpaces(x, height, i, numberOfYSpaces);
				//de-incriment the number of y spaces
				numberOfYSpaces -= 1;
			}
			//loop over the characters that are counting down
			for(int ch = i + 1; ch  > 0; ch--)
			{
				pyramidLine += (ch + " ");
			}
			//loop over the upward counting characters
			for(int ch2 = 1; ch2 <= i + 1; ch2 ++)
			{
				//dont double the amount of 1s
				if(ch2 == 1)
				{
					continue;
				}
				pyramidLine += (ch2 + " ");
			}
			//print each line
			System.out.println(pyramidLine);
		}
		//close scanner object
		input.close();
	}
	//create a method to determine the amount of spaces needed based on where in the string we are
	//will be called for each # in range(1, height)
	public static String howManySpaces(int x, int height, int i, int y)
	{
		//find out the relation between height and where we are in the line
		int num = height - x;
		//create a height variable that we can increment
		int newHeight = height;
		//initialize spaces
		String spaces = "";
		//make num into string so we can find length
		String numString = "" + num;
		int length = numString.length();
		//loop over the number of characters in the number so we know how many spaces to add per number below
		//z is length of number
		for(int z = 0; z < length; z++)
		{
			//test program by changing " " to "z" to make sure z is printing where we want
			spaces += " ";
		}
		//we want a space for every space between numbers
		if((i + 1 + "").length() != (height + "").length())
		{
			//test program by changing " " to x
			spaces += " ";
		}
		//this happens when there are no more y spaces
		if((i + 1 + "").length() ==  (height + "").length() && !(spaces.length() == (height + "").length() + 1) && !((i + 1 + "").length() == (height + "").length()-1))
		{
			//test code by changing " " to "k"
			spaces += " ";
		}
		//this prints the y spaces
		//methodology is covered above in previous comments
		else if(x < (newHeight + "").length() && y > 0)
		{
			spaces += " ";
			newHeight -= 1;
		}
		//return
		return spaces;
	}
}
