/*
 * Veronica Baker
 * Intro to CS -004
 */
import java.util.Scanner;
public class CreditCard 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//ask for credit card number
		System.out.println("Enter a credit card number as a long integer");
		long number = input.nextLong();
		//call isValid
		if(isValid(number) == true)
		{
			System.out.println(number + " is valid");
		}
		else
		{
			System.out.println(number + " is invalid");
		}
		input.close();
	}
	//call everything we need to decide if it is valid
	public static boolean isValid(long number)
	{
		int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		if((total % 10 == 0 && prefixMatched(number, 1) 
				&& getSize(number) >= 13 && getSize(number) <= 16))
		{
			return true;
		}
		return false;
	}
	//sum the 2 * the even places
	public static int sumOfDoubleEvenPlace(long number)
	{
		int sum = 0;
		//keep track of even places
		int evenPlace = 0;
		while(number > 0)
		{
			evenPlace = (int) (number % 100);
			sum += getDigit((evenPlace / 10) * 2);
			number /= 100; 
		}
		System.out.println("even sum is" + sum);
		return sum;
	}
	//returns a single digit number or returns the sum of each digit of a two digit number
	public static int getDigit(int number)
	{
		if(number < 10)
		{
			System.out.println(number);
			return number;
		}
		else
		{
			//ones place
			int firstDigit = number % 10;
			//tens place
			int secondDigit = number / 10;
			System.out.println("first and second is" + (firstDigit + secondDigit));
			return firstDigit + secondDigit;
		}
	}
	//sum the odd places
	public static int sumOfOddPlace(long number)
	{
		int sum = 0;
		while(number > 0)
			
		{
			sum += number % 10;
			number /= 100;
		}
		System.out.println("odd sum is" + sum);
		return sum;
	}
	//see if the prefix is valid for a credit card
	public static boolean prefixMatched(long number, int d)
	{
		if(getPrefix(number, d) == 4 || getPrefix(number, d) == 5)
		{
			return true;
		}
		else if(getPrefix(number, d) == 3)
		{
			if(getPrefix(number, d + 1) == 37)
			{
				return true;
			}
		}
		return false; 
	}
	//find the size of a number
	public static int getSize(long d)
	{
		int size = (d + "").length();
		System.out.println("size is" +size);
		return size;	
	}
	//finds the first k digits of a number
	public static long getPrefix(long number, int k)
	{
		String stringNumber = number + "";
		String stringPrefix = stringNumber.substring(0, k);
		long prefix = Long.parseLong(stringPrefix);
		System.out.println("prefix is" +prefix);
		return prefix;
	}
}

