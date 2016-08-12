
/*
 * Veronica Baker
 * Intro to CS - 004
 */
import java.util.Scanner;
public class BinHexDec 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//ask for number
		System.out.println("Please enter a number in binary or hex");
		String number = input.next();
		//figure out the prefix
		String prefix = number.substring(0, 2);
		//make sure the number is valid in hex or binary
		if((!prefix.equalsIgnoreCase("0X") || !prefix.equalsIgnoreCase("0B")) && number.length() == 2)
		{
			System.out.println("I don't know how to convert that number");
		}
		else if(prefix.equalsIgnoreCase("0x"))
		{
			System.out.println(hexToDec(number));
		}
		else if(prefix.equalsIgnoreCase("0b"))
		{
		System.out.println(binToDec(number));
		}
		else
		{
			System.out.println("I don't know how to convert that number");
		}
		input.close();
	}
	// convert hex to dec
	public static int hexToDec(String hexidecimal)
	{
		int sum = 0;
		int multiplier = 0;
		for(int i = 0; i < hexidecimal.length() - 2; i++)
		{
			char c = hexidecimal.charAt(hexidecimal.length() - 1 - i);
			if(c == 'A' || c == 'a')
			{
				multiplier = 10;
			}
			else if(c == 'B' || c == 'b')
			{
				multiplier = 11;
			}
			else if(c == 'C' || c == 'c')
			{
				multiplier = 12;
			}
			else if(c == 'D' || c == 'd')
			{
				multiplier = 13;
			}
			else if(c == 'E' || c == 'e')
			{
				multiplier = 14;
			}
			else if(c == 'F' || c == 'f')
			{
				multiplier = 15; 
			}
			else if(Character.isDigit(c))
			{
				multiplier = Character.getNumericValue(c);
			}
			else
			{
				System.out.println("Error parsing base-16 number");
				System.exit(0);
			}
			sum += multiplier * Math.pow(16, i);
		}
		System.out.println("Converting from base-16 to base-10!(:");
		return sum;
	}
	public static int binToDec(String binary)
	{
		//convert binary to dec
		int sum = 0;
		int counter = 0;
		for(int i = 0; i < binary.length() - 2; i++)
		{
			char c = binary.charAt(binary.length() - 1 - i);
			if(c == '1')
			{
				sum += Math.pow(2, counter);
			}
			else if(c == '0')
			{
				counter++;
				continue; 
			}
			else
			{
				System.out.println("Error parsing base-2 number");
				System.exit(0);
			}
			counter += 1;
		}
		System.out.println("Converting from base-2 to base-10");
		return sum;
	}
}
