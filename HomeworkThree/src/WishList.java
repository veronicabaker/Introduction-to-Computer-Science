/*
 * Veronica Baker
 * Intro to CS - 004
 */
import java.util.Scanner;
public class WishList 
{
	//this program stores information about wish list items in arrays
	//it allows the user to determine their 2 most expensive wish list items
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//ask for number of items
		System.out.println("How many items do you want in your wish list?");
		int numberOfItems = input.nextInt();
		//default to 2 items if the person doesn't want more than 1
		if(numberOfItems < 2)
		{
			numberOfItems = 2;
		}
		//we are going to use arrays to store values!
		String [] items = new String[numberOfItems];
		int [] costs = new int[numberOfItems];
		//let's add values to our arrays!!
		for(int i = 0; i < numberOfItems; i++)
		{
			System.out.println("What is item " + (i + 1));
			items[i] = input.next();
			System.out.println("What is the cost of item " + (i + 1));
			costs[i] = input.nextInt();
		}
		//find most expensive cost by using the new method that we created!!
		int mostExpensiveCost = maxValue(costs);
		//now use another new method to find the index of that cost!!
		int mostExpensiveCostIndex = maxValueIndex(costs);
		//the indices match!! now we can find the item
		String mostExpensiveItem = items[mostExpensiveCostIndex];
		//now we are going to get rid of the most expensive item so we can reuse our methods
		//new arrays!
		String [] newItems = new String[numberOfItems - 1];
		int [] newCosts = new int[numberOfItems - 1];
		int counter = 0;
		//determine what should go in the new arrays
		for(int i = 0; i < numberOfItems; i++)
		{		
			if(costs[i] != mostExpensiveCost)
			{
				newItems[counter] = items[i];
				newCosts[counter] = costs[i];
			}
			counter += 1;
		}
		//complete the same process as above
		int secondMostExpensiveCost = maxValue(newCosts);
		int secondMostExpensiveCostIndex = maxValueIndex(newCosts);
		String secondMostExpensiveItem = newItems[secondMostExpensiveCostIndex];
		//tell the user
		System.out.println("The most expensive items were:");
		System.out.println(mostExpensiveItem + " - $" + mostExpensiveCost);
		System.out.println(secondMostExpensiveItem + " - $" + secondMostExpensiveCost);
		//lets close our Scanner!!
		//yES!!
		input.close();
	}
	public static int maxValue(int array[])
	//finds max value in an array of integers!!
	{	
		int max = 0;
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] > max)
			{
				max = array[i];
			}
		}
		return max;
	}
	public static int maxValueIndex(int array[])
	// finds the index of the max value in  an array of integers!!!
	{
		int max = 0;
		int maxIndex = 0;
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] > max)
			{
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;

	}
}
