/*
 * Intro to CS 
 * Veronica Baker
 */
import java.util.Scanner;
public class RPNCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a mathematical expression in RPN: \n");
		String expression = input.nextLine();
		//make an array of numbers and operations
		String[] expressionArray = expression.split(" ");
		//make a stack!!
		StackOfDoubles stack = new StackOfDoubles(expressionArray.length);
		//make a result variable
		double result = 0;
		//iterate through the string input
		for(int i = 0; i < expressionArray.length; i++)
		{
			//if its not an operation, assume its a number
			//if its an operation, then do the operation by taking the last 2 numbers off of the stack
			if(expressionArray[i].contains("+")
					|| expressionArray[i].contains("-")
					|| expressionArray[i].contains("*")
					|| expressionArray[i].contains("/")
					|| expressionArray[i].contains("^"))
			{
				if(expressionArray[i].equals("+"))
				{
					double num1 = stack.pop();
					double num2 = stack.pop();
					result = (num2 + num1);
					stack.push(result);
					if(i == expressionArray.length - 1)
					{
						System.out.println("The result of the calculation is " + result);
					}
				}
				else if(expressionArray[i].equals("*"))
				{
					double num1 = stack.pop();
					double num2 = stack.pop();
					result = (num2 * num1);
					stack.push(result);
					if(i == expressionArray.length - 1)
					{
						System.out.println("The result of the calculation is " + result);
					}
				}
				else if(expressionArray[i].equals("/"))
				{
					double num1 = stack.pop();
					double num2 = stack.pop();
					result = (num2 / num1);
					stack.push(result);
					if(i == expressionArray.length - 1)
					{
						System.out.println("The result of the calculation is " + result);
					}
				}
				else if(expressionArray[i].equals("^"))
				{
					double num1 = stack.pop();
					double num2 = stack.pop();
					result = Math.pow(num2, num1);
					stack.push(result);
					if(i == expressionArray.length - 1)
					{
						System.out.println("The result of the calculation is " + result);
					}
				}
				else if(expressionArray[i].equals("-"))
				{
					double num1 = stack.pop();
					double num2 = stack.pop();
					result = (num2 - num1);
					stack.push(result);
					if(i == expressionArray.length - 1)
					{
						System.out.println("The result of the calculation is " + result);
					}
				}
			}
			else
			{
				double value = Double.parseDouble(expressionArray[i]);
				stack.push(value);
			}
		}
		input.close();
	}
}
