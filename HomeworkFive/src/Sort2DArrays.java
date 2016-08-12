/*
 * Veronica Baker
 * Intro to CS - 004
 */
public class Sort2DArrays 
{
	public static void main(String[] args)
	{
		//create three test arrays
		int[][] unsorted = {{7,7},{7,1},{1,2,3},{1,5},{1,2},{3,8},{3,8,1},{5}};
		int[][] alreadySorted = {{1,1},{1,2},{2},{2,4}};
		int[][] singleElement = {{7}};
		//test one: unsorted
		System.out.println("Original: " + arrayToString(unsorted));
		sort(unsorted);
		System.out.println("Sorted: " + arrayToString(unsorted));
		//test two: alreadySorted
		System.out.println("Original: " + arrayToString(alreadySorted));
		sort(alreadySorted);
		System.out.println("Sorted: " + arrayToString(alreadySorted));
		//test three: singleElement
		System.out.println("Original: " + arrayToString(singleElement));
		sort(singleElement);
		System.out.println("Sorted: " + arrayToString(singleElement));
	}
	//convert a 2D array to string
	public static String arrayToString(int[][] arr)
	{
		//open outer array
		String stringArray = "{";
		for(int i = 0; i < arr.length; i++)
		{
			//open inner array
			stringArray += "{";
			//loop over  inner array
			for(int j = 0; j < arr[i].length; j++)
			{
				//use a space and comma if another number will follow
				if(j != arr[i].length -1)
				{
					stringArray += arr[i][j] + ", ";
				}
				else
				{
					stringArray += arr[i][j];
				}
			}
			//close inner array
			//use a space and comma if another array will follow
			if(i != arr.length - 1)
			{
				stringArray += "}, ";
			}
			else
			{	
				stringArray += "}";
			}
		}
		//close outer array
		stringArray += "}";
		//return
		return stringArray;
	}
	//selection sort that takes a 2D array as an argument
	public static void sort(int[][] arr)
	{
		//loop over elements in array
		for(int i = 0; i< arr.length - 1; i++)
		{
			//set i as current min
			int[] currentMin = arr[i];
			int currentMinIndex = i;
			//loop over all the i + n elements
			for(int j = i + 1; j < arr.length; j++)
			{
				//call our compare method
				//carry out selection sort algorithm 
				if(arrayCompare(currentMin, arr[j]) == 1)
				{
					currentMin = arr[j];
					currentMinIndex = j;
				}
			}
			if(currentMinIndex != i)
			{
				arr[currentMinIndex] = arr[i];
				arr[i] = currentMin;
			}
		}
	}
	//compare two arrays based on first differing element
	public static int arrayCompare(int[] arr1, int[] arr2)
	{
		//what is the range of the loop?
		//the shorter array
		int length;
		if(arr1.length < arr2.length || arr1.length == arr2.length)
		{
			length = arr1.length;
		}
		else
		{
			length = arr2.length;
		}
		//loop over elements and compare each element 
		for(int i = 0; i < length; i++)
		{
			if(arr1[i] > arr2[i])
			{
				System.out.println("1");
				return 1;				
			}
			else if (arr1[i] < arr2[i])
			{
				System.out.println("-1");
				return -1;
			}
		}
		//if all elements are equal return the longer array
		if(arr1.length > arr2.length)
		{
			System.out.println("1");
			return 1;
		}
		else if(arr2.length > arr1.length)
		{
			System.out.println("-1");
			return -1;
		}
		System.out.println("0");
		return 0;
	}
}

