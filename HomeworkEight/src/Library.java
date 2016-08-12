/*
 * veronica bake 
 * intro to cs
 */
public class Library 
{
	//member variable
	private Book [] library; 
	//capacity 
	private int capacity = 8;
	//how many books?
	public int size = 0;
	
	
	//constructor
	public Library()
	{
		library = new Book[capacity];
	}
	//add a book method!!
	public void addToLibrary(Book book)
	{
		if(size < capacity - 1)
		{
			library[size++] = book;
		}
		else
		{
			System.out.println("Cannot add book");
		}
	}
	public int getCapacity()
	{
		return capacity;
	}
	public Book getElement(int index)
	{
		return library[index];
	}
	//selection sort by author!
	public void authorSort(int numberOfBooks)
	{
		for(int i = 0; i < size - 1; i++)
		{
			int minIndex = i;
			for(int j = i + 1; j < size; ++j)
			{
				if(library[i].getAuthor().getLastName().compareTo(library[minIndex].getAuthor().getLastName()) < 0)
				{
					minIndex = j;
				}
			}
			Book temp = library[i];
			library[i] = library[minIndex];
			library[minIndex] = temp;
		}
	}
	//selection sor t by title
	public void titleSort(int size)
	{
		for(int i = 0; i < size - 1; i++)
		{
			int minIndex = i;
			for(int j = i + 1; j < size; ++j)
			{
				if(library[i].getBookName().compareTo(library[minIndex].getBookName()) < 0)
				{
					minIndex = j;
				}
			}
			Book temp = library[i];
			library[i] = library[minIndex];
			library[minIndex] = temp;
		}
	}
}
