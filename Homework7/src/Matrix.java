/*
 * Veronica Baker
 * Intro to CS
 */
public class Matrix 
{
	//member variable
	int[][] matrix;
	//default constructor
	public Matrix()
	{
		//ten rows and ten columns
		matrix = new int[10][10];
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				//fill each element with a random number between 0 and 10
				matrix[i][j] = (int)(Math.random() * 11);
			}
		}
	}
	//makes a matrix with specified rows and columns and filled with zeros
	public Matrix(int rows, int cols)
	{
		matrix = new int[rows][cols];
	}
	//makes a matrix given a two dimensional array
	public Matrix(int[][] arr)
	{
		matrix = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				matrix[i][j] = arr[i][j];
			}
		}
	}
	//makes a matrix with rows columns and a fill value
	public Matrix(int rows, int cols, int fillNumber)
	{
		matrix = new int [rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				matrix[i][j] = fillNumber;
			}
		}
	}
	//fills a matrix with a specified value
	public void fill(int n)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = n;
			}
		}
	}
	//fills a matrix with random values of a specified range
	public void generateRandomElements(int rows, int cols, int min, int max)
	{
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				matrix[i][j] = (int)(Math.random() * (max - min + 1) + min);
			}
		}
	}
	//finds teh largest int in a matrix
	public int getMaxInt()
	{
		int max = matrix[0][0];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(matrix[i][j] > max)
				{
					max = matrix[i][j];
				}
			}
		}
		return max;
	}
	//finds the smallest int in a matrix
	public int getMinInt()
	{
		int min = matrix[0][0];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(matrix[i][j] < min)
				{
					min = matrix[i][j];
				}
			}
		}
		return min;
	}
	//returns the number of columns in a matrix
	public int getNumCols()
	{
		//matrix is a rectangle so we can use the lenngth of the first row
		return matrix[0].length;
	}
	//returns the number of rows in a matrix
	public int getNumRows()
	{
		return matrix.length;
	}
	//finds a specific element in the matrix
	public int getElement(int row, int col)
	{
		return matrix[row][col];
	}
	//returns the matrix as a string
	public String toString()
	{
		String array = "";
		for(int i = 0; i < matrix.length; i++)
		{
			array += "[";
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(j == matrix[i].length - 1)
				{
					array += matrix[i][j];
				}
				else
				{
					array += matrix[i][j] + ", ";
				}
			}
			array += "]\n";
		}
		return array;
	}
	//flip rows and columns
	public void transpose()
	{
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				newMatrix[j][i] = matrix[i][j];
			}
		}
		matrix = newMatrix;
	}
	//flip rows
	public void horizontalFlip()
	{
		for(int i = 0; i < matrix.length; i++)
		{
			int [] rowToFlip = new int[matrix[i].length];
			for(int x = 0; x < matrix[i].length; x++)
			{
				rowToFlip[x] = matrix[i][x];
			}
			int count = 0;
			for(int j = rowToFlip.length - 1; j >= 0; j--)
			{
				matrix[i][count] = rowToFlip[j];
				count += 1;
			}
		}
	}
	//flip columns
	public void verticalFlip()
	{
		int [][] columnsToFlip = new int [matrix.length][matrix[0].length];
		for(int x = 0; x < matrix.length; x++)
		{
			columnsToFlip[x] = matrix[x];
		}
		int count = 0;
		for(int i = columnsToFlip.length - 1; i >= 0; i--)
		{
			matrix[count] = columnsToFlip[i];
			count += 1;
		}
	}
	//add the elemnets of two matrices
	public boolean add(Matrix m)
	{
		if(m.getNumRows() != matrix.length && m.getNumCols() != matrix[0].length)
		{
			return false;
		}
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] += m.getElement(i, j);
			}
		}
		return true;
	}
	//multiply elements of a matrix by an int
	public void multiply(int n)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] *= n;
			}
		}
	}
}
