/*
 * Veronica Baker
 * Intro to CS -004
 */
import java.util.Scanner;

public class AboutACharacter 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a unicode code point, and I'll print out a report:");
		//receive a unicode code point from user as an int
		int response = input.nextInt();
		//create a new variable to hold the actual character
		char character = (char) response;
		//see if the code point falls within numbers 0-9
		if (response >= 48 && response <= 57)
		{
			System.out.println("The character is a number");
		}
		//see the code point falls withing the upper or lowercase alphabet 
		else if(response >= 65 && response <= 90 || response >= 97 && response <= 122)
		{
			System.out.println("The character is a letter.");
		}
		//if the first two fail, then we know it is not alphanumeric
		else
		{
			System.out.println("The character is not alphanumeric");
		}	
		//give the report to the user
		System.out.println(response + " represents the character: " + character);
		System.out.println("The next character is: " + ++character);
		--character; 
		System.out.println("The previous character is: " + --character);
	}
}
