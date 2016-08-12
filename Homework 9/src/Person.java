/*
 * veronica baker
 * Intro to CS
 */
public class Person 
{
	//member variables
	private String first;
	private String middle;
	private String last;
	private static int count = 0;
	
	//no argument constructor
	public Person()
	{
		//count of people increases every time this constructor is called
		count += 1;
		System.out.println("Creating person #" + count);
	}
	//constructor with name
	public Person(String first, String middle, String last)
	{
		//call no arg constructor
		this();
		this.setName(first, middle, last);
	}
	//set name method
	void setName(String first, String middle, String last)
	{
		this.first = first;
		this.middle = middle;
		this.last = last;
	}
	//to string method
	public String toString()
	{
		return first + " " + middle + " " + last;
	}
	//getter methods for all member variables
	public String getFirst()
	{
		return first;
	}
	public String getMiddle()
	{
		return middle;
	}
	public String getLast() 
	{
		return last;
	}
	public int getCount() 
	{
		return count;
	}
}
