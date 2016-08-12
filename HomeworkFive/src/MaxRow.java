/*
 * Veronica Baker
 * Intro to CS - 004
 */
public class MaxRow 
{
	public static void main(String[] args)
	{
		//initialize variables for sum and index of max 
		int maxSum = 0;
		int indexOfMaxRow = 1;
		//generate a random 3x3 matrix
		int [][] matrix = matrixGenerator(3, 3);
		//print matrix
		printMatrix(matrix);
		//set these variables to the first row
		//the rest of the rows will compare to this
		for(int x = 0; x < matrix[0].length; x++)
		{
			maxSum += matrix[0][x];
		}
		//compare the sums of the rest of the rows
		for(int i = 1; i < matrix.length; i++)
		{
			int rowSum = 0;
			for(int j = 0; j < matrix[i].length; j++)
			{
				rowSum += matrix[i][j];
			}
			//reassign if greater
			if(rowSum > maxSum)
			{
				maxSum = rowSum;
				indexOfMaxRow = i + 1;
			}
			//if sums are equal choose the lower down row
			if(rowSum == maxSum)
			{
				indexOfMaxRow = i + 1; 
			}
		}
		//display results
		System.out.println("Row " +  indexOfMaxRow + " has the largest sum: " + maxSum);
	}
	/**
	 * Generate a two dimensional array of random numbers 0 to 9 of given dimensions
	 * 
	 * @param height number of rows in the matrix
	 * @param width number of columns in the matrix
	 * @return a two dimensional array of random numbers
	 */
	public static int[][] matrixGenerator(int height, int width)
	{
		int[][] matrix = new int[height][width];
		for(int i = 0; i < height; i ++)
		{
			for(int j = 0; j < width; j++)
			{
				matrix[i][j] = (int)(Math.random() * 10);
			}
		}
		return matrix;
	}
	/**
	 * print a two dimensional array
	 * @param matrix a two dimensional array to print
	 */
	public static void printMatrix(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++) 
		{
		    for(int j = 0; j < matrix[i].length; j++) 
		    {
		      System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		  }
	}
}
