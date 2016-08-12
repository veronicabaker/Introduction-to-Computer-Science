/*
 * veronica Baker
 * intro to CS
 */
public class Person 
{
	//has first and last name
	private String firstName;
	private String lastName;
	
	//constructor
	public Person(String newFirstName, String newLastName)
	{
		firstName = newFirstName;
		lastName = newLastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
}
