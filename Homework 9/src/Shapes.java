/*
 * Vrenica Baker
 * intro to cs
 */
import processing.core.PApplet;

public class Shapes extends PApplet
{
	PApplet _p;
	int x;
	int y;
	int speed;
	public Shapes()
	{
		
	}
	
	public Shapes(int x, int y, int speed)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	public void reset(int width, int newX)
	{
		if(speed > width)
		{
			speed = newX;
		}
	}
	public void render()
	{
		
	}
}
