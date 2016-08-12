/*
 * Veroncia Baker
 * intro to cs 
 */
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class MyLibrary 
{
	public static void main(String[] args)
	{
		//create new library
		Library library = new Library();
		Scanner input = new Scanner(System.in);
		//find teh date
		java.util.Date date = new java.util.Date();
		//print out welcome
		System.out.println("Welcome to Veronica's Library!");
		System.out.println("Today is " + date);
		//initialize response
		String response = " ";
		//while loop to use library
		while(response != "q")
		{
			//commands
			System.out.println("Please enter a command: "
					+ "(d)isplay all books \n"
					+ "(f)ind books by author \n"
					+ "get (r)andom book \n"
					+ "(a)dd book \n"
					+ "(l)oad data \n"
					+ "(s)ort books \n"
					+ "(q)uit");
			response = input.next();
			//quit!
			if(response.equals("q"))
			{
				System.out.println("Bye");
				input.close();
				System.exit(0);
			}
			//display all books
			if(response.equals("d"))
			{
				for(int i = 0; i < library.size; i++)
				{
					Book book = library.getElement(i);
					Person author = book.getAuthor();
					System.out.println(book.getBookName() + " by " + author.getLastName() + ", " + author.getFirstName());
				}
			}
			//find a book by author
			if(response.equals("f"))
			{
				System.out.println("What is the author's last name?");
				String lastName = input.nextLine();
				for(int i = 0; i < library.size; i++)
				{
					if(library.getElement(i).isAuthor(lastName))
					{
						System.out.println(library.getElement(i) + " by " + library.getElement(i).getAuthor().getLastName() + ", " 
					+ library.getElement(i).getAuthor().getFirstName());
					}
					else
					{
						System.out.println("Book not found :(");
					}
				}
			}
			//find a random book!!
			if(response.equals("r"))
			{
				Random random = new Random();
				int index = random.nextInt(library.size);
				System.out.println(library.getElement(index).getBookName() + " by " + library.getElement(index).getAuthor().getLastName() + ", " 
						+ library.getElement(index).getAuthor().getFirstName());
			}
			if(response.equals("a"))
			{
				System.out.println("Please enter a title: \n");
				String title = input.nextLine();
				System.out.println("Please enter an author: \n");
				String author = input.nextLine();
				String [] firstLast = author.split(" ");
				Person newAuthor = new Person(firstLast[0], firstLast[1]);
				Book book = new Book(title, newAuthor);
				library.addToLibrary(book);
			}
			//hardcode a library of five books and display
			if(response.equals("l"))
			{
				Person author1 = new Person("Mary", "Shelley");
				Person author2 = new Person("Neal", "Stephenson");
				Person author3 = new Person("Susan", "Collins");
				Person author4 = new Person("William", "Gibson");
				Book book1 = new Book("Frankenstein", author1);
				Book book2 = new Book("Cryptonomicon", author2);
				Book book3 = new Book("The Hunger Games", author3);
				Book book4 = new Book("Neuromancer", author4);
				Book book5 = new Book("Snow Crash", author2);
				library.addToLibrary(book1);
				library.addToLibrary(book2);
				library.addToLibrary(book3);
				library.addToLibrary(book4);
				library.addToLibrary(book5);
				for(int i = 0; i < library.size; i++)
				{
					Book book = library.getElement(i);
					Person author = book.getAuthor();
					System.out.println(book.getBookName() + " by " + author.getLastName() + ", " + author.getFirstName());
				}
				System.out.println();
			}
			//sort books by titile or author
			if(response.equals("s"))
			{
				System.out.println("Sort by (t)itle or (a)uthor?\n");
				String sortType = input.next();
				int numberOfBooks = library.size;
				if(sortType.equals("a"))
				{
					library.authorSort(numberOfBooks);
					System.out.println("Sorted by author");
				}
				else
				{
					library.titleSort(numberOfBooks);
					System.out.println("Sorted by title");
				}
			}	
		}
	}
}
