/*
 * Veronica Baker
 * Intro to CS
 */
public class MatrixTest 
{
	public static void main(String[] args)
	{
		//new 2d array
		int[][] m = {
			    {4, 1, -2, 129},
			    {395, 7, 4, 0},
			    {5, -100, 8, 55}
			};
		//new matrix using m
		Matrix matrix1 = new Matrix(m);
		System.out.println(matrix1);
		//new matrix with default constructor
		Matrix matrix2 = new Matrix();
		System.out.println(matrix2);
		//reset matrix2 to have 5x5 with random elements
		matrix2 = new Matrix(5, 5);
		matrix2.generateRandomElements(5, 5,  -100, 100);
		System.out.println(matrix2);
		//find rows, cols, and max and min int
		System.out.println(matrix1.getNumRows());
		System.out.println();
		System.out.println(matrix1.getNumCols());
		System.out.println();
		System.out.println(matrix1.getMaxInt());
		System.out.println();
		System.out.println(matrix1.getMinInt());
		System.out.println();
		//transpose
		matrix1.transpose();
		System.out.println(matrix1);
		//horizontal flip
		matrix1.horizontalFlip();
		System.out.println(matrix1);
		//vertical flip
		matrix1.verticalFlip();
		System.out.println(matrix1);
		//new matrix with 1s to fill
		Matrix matrix3 = new Matrix(4, 3, 1);
		//add matrix 3 to matrix 1
		matrix1.add(matrix3);
		System.out.println(matrix1);
		//multiply elements of matrix 1 by 2
		matrix1.multiply(2);
		System.out.println(matrix1);
	}
}
