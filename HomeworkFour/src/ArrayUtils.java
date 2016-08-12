/*
 * Veronica Baker
 * Intro to CS -004
 */
public class ArrayUtils 
{
	public static void main(String[] args)
	{
		// test methods
		int[] noNumbers = {};
		int[] oneNumber = {5};
		int[] evenNumbers = {2, 4, 6, 8, 10};

		System.out.println("Test prettyPrint");
		prettyPrint(noNumbers); // empty array should print out []
		prettyPrint(oneNumber); // one element should print out [5]
		prettyPrint(evenNumbers); // multiple elements should print out [2, 4, 6, 8, 10]

		System.out.println("Test randomInt");
		prettyPrint(randomInts(5, 1, 100)); // should return 5 random numbers from 1 to 100 -> [88, .. 4]
		prettyPrint(randomInts(-1, 1, 100)); // negative size should return empty -> []
		prettyPrint(randomInts(0, 1, 100)); // zero size should return empty -> []
		prettyPrint(randomInts(5, 100, 100)); // same min max should return all the same number -> [100, ... 100]
		prettyPrint(randomInts(5, 100, 1)); // max lower than min should return all 0's -> [0, ... 0]
		prettyPrint(randomInts(20, -5, 5)); // include negative numbers should return mix of numbers in range -> [3, 1, -5 ... 2]

		System.out.println("Test range");
		prettyPrint(range(1, 10, 1)); // start at 1, go up to 9 by 1's -> [1, 2, 3, 4, 5, 6, 7, 8, 9]
		prettyPrint(range(-10, 11, 1)); // start at -10, go up to 10 by 1's -> [-10, -9, ... 10]
		prettyPrint(range(-10, -4, 1)); // start at -10, go up to -5 by 1's -> [-10, -9, -8, -7, -6, -5]
		prettyPrint(range(12, -1, -3)); // start at 12, go down to 0 by 3's -> [12, 9, 6, 3, 0]
		prettyPrint(range(1, 10, 0)); // 0 step should return empty -> []
		prettyPrint(range(1, 10, -1)); // negative step when stop is greater than start should return empty -> []

		prettyPrint(range(5)); // one argument version defaults to start at 0 and step of 1 -> [0, 1, 2, 3, 4]
		prettyPrint(range(5, 10)); // two argument version defaults to step of 1 -> [5, 6, 7, 8, 9]

		System.out.println("Test concat");
		prettyPrint(concat(noNumbers, noNumbers)); // adding two empty -> []
		prettyPrint(concat(noNumbers, oneNumber)); // adding one element to empty -> [5]
		prettyPrint(concat(oneNumber, evenNumbers)); // -> [5, 2, 4, 6, 8, 10]
		prettyPrint(concat(evenNumbers, evenNumbers)); // -> [2, 4, 6, 8, 10, 2, 4, 6, 8, 10]

		System.out.println("Test subArray");
		prettyPrint(subArray(evenNumbers, 0)); // start from beginning gives back entire Array -> [2, 4, 6, 8, 10]
		prettyPrint(subArray(evenNumbers, 2)); // -> [6, 8, 10]
		prettyPrint(subArray(evenNumbers, 8)); // start from index beyond length gives back empty -> []
		prettyPrint(subArray(oneNumber, 0)); // single element from 0 gives back one element Array -> [5]
		prettyPrint(subArray(noNumbers, 1)); // empty returns empty -> []

		System.out.println("Test average");
		System.out.println(average(noNumbers)); // no numbers... average is 0 -> 0
		System.out.println(average(evenNumbers)); // -> 6.0
		System.out.println(average(oneNumber)); // -> 5.0
	}
	public static String toString(int[] arr)
	{
		//empty array
		if(arr.length == 0)
		{
			return "[]";
		}
		//start array
		String stringArray = "[";
		//loop through elements
		for(int i = 0; i < arr.length - 1; i++)
		{
			stringArray += arr[i] + ", ";
		}
		//end array
		stringArray += arr[arr.length - 1] + "]";
		//return
		return stringArray;
	}
	public static void prettyPrint(int[] arr)
	{
		//call toString
		System.out.println(toString(arr));
	}
	public static int[] randomInts(int size, int minVal, int maxVal)
	{
		//return empty array
		if(size <= 0)
		{
			int [] randomIntegers = new int[0];
			return randomIntegers;
		}
		int [] randomIntegers = new int[size];
		int range = maxVal - minVal;
		//add a random int for each element
		if(maxVal >= minVal)
		{
			for(int i = 0; i < size; i++)
			{
				randomIntegers[i] = minVal + (int)(Math.random() *(range + 1));
			}
		}
		return randomIntegers;
	}
	public static int[] range(int start, int stop, int step)
	{
		//when to return an empty array
		if(step == 0 || start < stop && step < 0)
		{
			int [] arithmeticNumbers = new int[0];
			return arithmeticNumbers;
		}
		//how long?
		int length = Math.abs(stop - start);
		//if step is not one this wont be accurate
		//use modulo
		if(Math.abs(step) > 1)
		{
			length = length % Math.abs(step) + start / Math.abs(step);
		}
		int [] arithmeticNumbers = new int[length];
		int index = 0;
		//increasing
		if(start < stop)
		{
			for(int i = start; i < stop; i += step)
			{
				arithmeticNumbers[index] = i;	
				index += 1;
			}
		}
		//decreasing
		else if(start > stop)
		{
			for(int i = start; i > stop; i += step)
			{
				arithmeticNumbers[index] = i;
				index += 1;
			}
		}
		return arithmeticNumbers; 
	}
	public static int[] range(int start, int stop)
	{
		//call range and fill in last arg
		return range(start, stop, 1);
	}
	public static int[] range(int stop)
	{
		//call range and fill in first arg
		return range(0, stop);
	}
	public static int[] concat(int[] arr1, int[] arr2)
	{
		int [] concatArray = new int[arr1.length + arr2.length];
		//add all elements from the first array
		for(int i = 0; i < arr1.length; i++)
		{
			concatArray[i] = arr1[i];
		}
		//add all elements in the second array
		for(int i = arr1.length; i < arr2.length + arr1.length; i++)
		{
			concatArray[i] = arr2[i - arr1.length];
		}
		return concatArray;
	}
	public static int[] subArray(int[] arr, int index)
	{
		//when to return an empty array
		if(arr.length - 1 < index)
		{
			int [] sub = new int[0];
			return sub;
		}
		int [] sub = new int[arr.length - index];
		//variable to index into original 
		int in = index;
		for(int i = 0; i < arr.length - index; i++)
		{
			sub[i] = arr[in];
			in += 1;
		}
		return sub;
	}
	public static double average(int[] arr)
	{
		int sumOfInts = 0;
		//avoid dividing by 0
		if(arr.length == 0)
		{
			int averageOfInts = 0;
			return averageOfInts;
		}
		for(int i = 0; i < arr.length; i++)
		{
			sumOfInts += arr[i];
		}
		int averageOfInts = sumOfInts/(arr.length);
		
		return averageOfInts;
	}
}

