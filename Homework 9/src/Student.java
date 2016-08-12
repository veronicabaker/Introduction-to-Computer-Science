/*
 * Veronica baker 
 * intro to CS
 */
public class Student extends Person
{
	//member variables
	private String netId;
	private String major = "Undeclared";
	
	//constructor
	public Student(String first, String middle, String last)
	{
		//calls setName from person class
		super.setName(first, middle, last);
		//generates a netId
		this.generateNetId();
	}
	private void generateNetId()
	{
		//first initial of each first middle and last plus count
		this.netId = this.getFirst().substring(0, 1).toLowerCase()
				+ this.getMiddle().substring(0, 1).toLowerCase()
				+ this.getLast().substring(0, 1).toLowerCase()
				+ this.getCount();
	}
	public void setNetId(String netId)
	{
		this.netId = netId;
	}
	@Override 
	public boolean equals(Object obj)
	{
		Student other = (Student) obj;
		return this.netId.equals(other.netId);
	}
	@Override
	public String toString()
	{
		return super.toString() + " " + this.netId + " " + this.major;
	}
}
