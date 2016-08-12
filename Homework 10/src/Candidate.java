/*
 * Veronica Baker
 * intro to CS - 004
 */
public class Candidate 
{
	String first;
	String last;
	double totalContributions;
	double averagePerContribution;
	int contributionCount;
	
	public Candidate(String first, String last, Double amount)
	{
		this.first = first;
		this.last = last;
		this.totalContributions = amount;
		contributionCount = 1;
	}
	
	public String getFirst() 
	{
		return first;
	}
	public String getLast() 
	{
		return last;
	}
	public String getFullName()
	{
		return first + " " + last;
	}
	public double getTotalContributions() 
	{
		return totalContributions;
	}
	public double getAveragePerContribution() 
	{
		return totalContributions / contributionCount;
	}
}
