/*
 * Veronica Baker
 * Intro to CS
 */
public class PersonTest 
{
	public static void main(String[] args)
	{
		//create 3 person objects
		Person person = new Person("Iam", "not", "Astudent");
		//two are studetns
		Student alice1 = new Student("Alice", "Apple", "Alvarez");
		Student alice2 = new Student("Alice", "Alma", "Alvarez");
		//print out information
		System.out.printf("person = %s\n", person);
		System.out.printf("alice1 = %s\n", alice1);
		System.out.printf("alice2 = %s\n", alice2);
		//check equality
		System.out.printf("alice1 equals alice2? %s\n", alice1.equals(alice2));
		//reset netId for alice2
		alice2.setNetId("aaa2");
		//print again
		System.out.printf("alice1 = %s\n", alice1);
		System.out.printf("alice2 = %s\n", alice2);
		System.out.printf("alice1 equals alice2? %s\n", alice1.equals(alice2));
		//make an array of people
		Person[] people = {person, alice1, alice2};
		//print each person
		for(int i = 0; i < people.length; i++)
		{
			System.out.println(people[i]);
		}
	}
}
