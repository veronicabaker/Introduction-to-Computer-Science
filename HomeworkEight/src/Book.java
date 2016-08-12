/*
 * Veronica Baker
 * intro to CS
 */
public class Book 
{
	//name and author
	private String bookName;
	private Person author; 
	//member variable
	private Book book;
	
	//constructor
	public Book(String newBookName, Person newAuthor)
	{
		bookName = newBookName;
		author = newAuthor;
	}
	public Person getAuthor()
	{
		return author;
	}
	public String getBookName()
	{
		return bookName;
	}
	//find out if an author wrote the book!!
	public boolean isAuthor(String lastName)
	{
		return book.getAuthor().getLastName() == lastName;
	}
}
