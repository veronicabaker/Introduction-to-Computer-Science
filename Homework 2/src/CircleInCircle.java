/*
 * Veronica Baker
 * Intro to CS -004
 */
import java.util.Scanner;
public class CircleInCircle 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//get input for circle 1
		System.out.println("Enter Circle 1's center coordinates (x, y) and radius");
		double x1 = input.nextDouble();
		double y1 = input.nextDouble();
		double r1 = input.nextDouble();
		//get input for circle 2
		System.out.println("Enter Circle 2's center coordinates (x, y) and radius");
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double r2 = input.nextDouble();
		//use the distance formula
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		//first find if they are inside of each other
		if(distance <= Math.abs(r2 - r1))
		{
			if(r1 > r2)
			{
				System.out.println("Circle 2 is inside Circle 1");
			}
			else if(r2 > r1)
			{
				System.out.println("Circle 1 is inside Circle 2");
			}
			//if these dont work they are the same
			else
			{
				System.out.println("Circle 1 and Circle 2 are the same circle");
			}
		}
		//if they are not inside of each other find if they do or don't overlap
		else if(distance < r2 + r1)
		{
			System.out.println("Circle 2 overlaps Circle 1");
		}
		else if(distance > r2 + r1)
		{
			System.out.println("The circles do not overlap");
		}
	}
}
