/*
 * Vernica Baker 
 * Intro to cS
 */
public class Road extends Shapes
{
	int width;
	
	public Road(int x, int y, int speed, int width)
	{
		super(x, y, speed);
		this.width = width;
	}
	@Override
	public void reset(int xValue, int newX)
	{
		if(speed > xValue)
		{
			speed = newX;
		}
	}
	public void render()
	{
		for(int i = 0; i <= width * 3; i++)
		{
			if(i % 20 == 0)
			{
				fill(250, 242, 22);
				rect(speed + i, 335, 10, 3);
			}
		}
	}
}
