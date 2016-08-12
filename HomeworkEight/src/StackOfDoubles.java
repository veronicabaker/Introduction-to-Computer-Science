/*
 * Intro to CS
 * Veronica Baker
 */
public class StackOfDoubles 
{
	private double[] elements;
	private int size;
	
	public StackOfDoubles(int capacity)
	{
		elements = new double[capacity];
	}
	
	public void push(double value)
	{
		if(size >= elements.length)
		{
			double[] temp = new double[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = value;
	}
	public double pop()
	{
		return elements[--size];
	}
	public double peek()
	{
		return elements[size - 1];
	}
	public boolean empty()
	{
		return size == 0;
	}
	public int getSize()
	{
		return size;
	}
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i <= size; i++)
		{
			stringBuilder.append(elements[i] + " ");
		}
		return stringBuilder.toString();
	}
}
