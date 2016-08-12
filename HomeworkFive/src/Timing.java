
/*
 * Veronica Baker
 * Intro to CS - 004
 */
public class Timing 
{
	public static void main(String[] args)
	{
		//create a random array
		int[] randomArray = new int[10000];
		for(int i = 0; i < randomArray.length; i++)
		{
			randomArray[i] = (int)(Math.random() * 10000);
		}
		//create a random key
		int key = (int)(Math.random() * 10000);
		//sort the array so that binary search will work
		selectionSort(randomArray);
		//find the start time for linear search
		long startTime = System.nanoTime();
		//linear search
		int i = linearSearch(randomArray, key);
		//find the total time for linear search
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("Linear Search: " + executionTime + "ns");
		//start time for binary search
		startTime = System.nanoTime();
		i = binarySearch(randomArray, key);
		//total time for binary search
		endTime = System.nanoTime();
		executionTime = endTime - startTime;
		System.out.println("Binary Search: " + executionTime + "ns");
	}
	//selection sort method so that binary search will work
	public static void selectionSort(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			int currentMin = arr[i];
			int currentMinIndex = i;
			for(int j = i + 1; j < arr.length; j++)
			{
				if(currentMin > arr[j])
				{
					currentMin = arr[j];
					currentMinIndex = j;
				}
				if(currentMinIndex != i)
				{
					arr[currentMinIndex] = arr[i];
					arr[i] = currentMin;
				} 
			}
		}
	}
	//linear search method
	public static int linearSearch(int[] arr, int key)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(key == arr[i])
			{
				return i;
			}
		}
		return -1;
	}
	//binary search method
	public static int binarySearch(int[] arr, int key)
	{
		int low = 0;
		int high = arr.length - 1;
		while(high >= low)
		{
			int mid = (low + high) / 2;
			if(key < arr[mid])
			{
				high = mid - 1;
			}
			else if(key == arr[mid])
			{
				return mid;
			}
			else
			{
				low = mid + 1;
			}
		}
		return - low - 1;
	}
}
