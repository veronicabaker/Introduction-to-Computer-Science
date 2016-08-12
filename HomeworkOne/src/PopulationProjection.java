/*
 * Veronica Baker
 * Intro to CS-004 Spring 2016
 */
public class PopulationProjection 
{
	public static void main(String[] args)
	{
		//Display the current population and the predictions for the next five years rounded to the nearest whole number
		double seconds = 60 * 60 * 24 * 365;
		double deaths = seconds / 13, births = seconds / 13, immigrants = seconds / 13;
		double population = 312032486;
		System.out.println("The current population is " + Math.round(population) + " people.");
		for(int i = 1; i < 6; i++)
		{
			population = population + (births + immigrants - deaths);
			if (i == 1)		
			{
				System.out.println("Next year, the population will be " + Math.round(population) + " people.");
			}
			else
			{
				System.out.println("In " + i + " years, the population will be " + Math.round(population) + " people.");
			}
		}
		
	}

}
