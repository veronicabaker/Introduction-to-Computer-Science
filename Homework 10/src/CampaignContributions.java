/*
 * Veronica Baker
 * Intro to CS - 004
 */

import java.util.ArrayList;
import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CampaignContributions 
{	
	public static void main(String[] args) throws IOException
	{
		//use the data to create file objets and store in
		//an array list
		
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		
		try
		{
			loadCandidates(args[0], candidates);
			writeCandidates(args[1], candidates);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Input and/or output file not specified");
		}
	}
	public static void loadCandidates(String file, ArrayList<Candidate> candidates)
	{
		//read in the file specified at args[0] using a File
		//object and Scanner object
			
		File f = new File(file);
		try
		{
			Scanner input = new Scanner(f);
		
			//extract data from each line
			//but skip headers
			
			int count = 0;
			while(input.hasNext())
			{
				//search your array list for a candidate
				//or create a new Candidate if it doesn't exist yet
				if(count > 1)
				{
					String[] data = input.nextLine().split(",");
					if( !isCandidate(candidates, data))
					{
						Double x = Double.valueOf(data[7]);
						candidates.add(new Candidate(data[5], data[4], x));
					}
					count += 1;
				}
				else
				{
					String data = input.nextLine();
					count += 1;
					continue;
				}
			}

			//sort the data by descending order of average contribution
			for(int i = candidates.size() - 1; i >= 0; i--)
			{
				for(int j = 0; j < i; j++)
				{
					if(candidates.get(j).getAveragePerContribution() >
					candidates.get(j + 1).getAveragePerContribution())
					{
						Candidate temp = candidates.get(j);
						candidates.set(j, candidates.get(j + 1));
						candidates.set(j + 1, temp);
					}
				}
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not read from file");
		}
	}
	
	public static void writeCandidates(String file, ArrayList<Candidate> candidates)
	{
		//Use a File object and a PrintWriter object
		//to write out data to the file specified in args[1]
		
		File a = new File(file);
		
		try
		{
			PrintWriter out = new PrintWriter(a);
			
			//each file should contain:
			//candidate's first and last name
			//total contributions
			//average per contribution
			
			for(int i = candidates.size() - 1; i >= 0; i--)
			{
				out.write(candidates.get(i).getFullName() + ", "
						+ "total: $" + String.format("%.2f", candidates.get(i).getTotalContributions())
						+ ", average: $" + String.format("%.2f", candidates.get(i).getAveragePerContribution())
						+ "\n");
			}
			
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Could not write to file");
		}
	}
	public static boolean isCandidate(ArrayList<Candidate> candidates, String[] data)
	{
		for(int i = 0; i < candidates.size(); i++)
		{
			if(candidates.get(i).first.equals(data[5])
					&& candidates.get(i).last.equals(data[4]))
			{
				Double x = Double.valueOf(data[7]);
				candidates.get(i).totalContributions += x;
				candidates.get(i).contributionCount += 1;
				return true;
			}
		}
		return false;
	}
}

	