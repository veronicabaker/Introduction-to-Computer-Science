
/*
 * Veronica baker
 * Intro to cS
 */
public class Mountain extends Shapes
{
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int y3;
	
	public Mountain()
	{
		
	}
	public Mountain(int x, int y, int x2, int y2, int x3, int y3, int speed)
	{
		super(x, y, speed);
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	@Override
	public void render()
	{
		fill((int)(200 * Math.random() + 50));
		triangle(x1, y1, x2, y2, x3, y3);
	}
}
