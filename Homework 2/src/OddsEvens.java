/*
 * Veronica Baker
 * Intro to CS - 004
 */
import java.util.Scanner;
public class OddsEvens 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//Banner
		System.out.println("Let's play a game of odds and evens!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
		//ask player if they want a cheating opponent
		System.out.println("Would you like to play against an honest or cheating opponent?");
		System.out.println("(H)onest Olivia or (C)heating Chelsea? (input H or C)");
		String computer = input.next();
		//ask the player to choose odd or even
		System.out.println("Choose even or odd (type the number corresponding to your choice) \n 1- Odd \n 2- Even");
		int playerChoice = input.nextInt();
		//tell the player whether they chose odd or even
		if(playerChoice == 1)
		{
			System.out.println("You chose odds");
		}
		else if(playerChoice == 2)
		{
			System.out.println("You chose evens");
		}
		//if the player doesnt choose 1 or 2, the game ends
		else
		{
			System.out.println("Oops, you have to choose odd (1) or even (2)");
			System.exit(0);
		}
		//ask the player to reveal their number
		System.out.println("1...2...3...Shoot! \nHow many fingers? (1 or 2)");
		int playerFingers = input.nextInt();
		//if the player doesn't type one or 2, the game ends immediately
		if(playerFingers != 1 && playerFingers != 2)
		{
			System.out.println("Opps, only 1 or 2 allowed");
			System.exit(0);
		}
		int computerFingers = 0;
		//if the computer is a cheater, always let it win
		if(computer.equalsIgnoreCase("c") && playerChoice == 1)
		{
			System.out.println("The cheating computer cheats");
			if(playerFingers == 1)
			{
				computerFingers += 1;
			}
			else if(playerFingers == 2)
			{
				computerFingers += 2;
			}
		}
		else if(computer.equals("c") || computer.equals("C") && playerChoice == 2)
		{
			System.out.println("The cheating computer cheats");
			if(playerFingers == 1)
			{
				computerFingers += 2;
			}
			else if(playerFingers == 2)
			{
				computerFingers += 1;
			}
		}
		//if the computer is not a cheater, randomly choose 1 or 2
		else if(computer.equalsIgnoreCase("h"))
		{
			computerFingers += (int)(Math.random() * 2);
		}
		//calculate total
		int total = playerFingers + computerFingers;
		//print report with total
		System.out.println("The player puts out " + playerFingers);
		System.out.println("The computer puts out " + computerFingers);			
		System.out.println("The total is " + total);
		//figure out who won and tell the player
		if(playerChoice == 1 && total % 2 != 0 || playerChoice == 2 && total % 2 == 0)
		{
			System.out.println("YOU WON!");			
		}
		else
		{
			System.out.println("YOU LOST!");
		}
	}
}
