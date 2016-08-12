/*
 * Veronica Baker
 * Intro to CS
 */
public class Tree extends Shapes
{
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int y3;
	int speed; 
	
	public Tree()
	{
		
	}
	
	public Tree(int x, int y, int x2, int y2, int x3, int y3, int speed)
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
		_p.fill(5, ((int)(Math.random() * 255 + 50)), 30);
		_p.triangle(x1, y1, x2, y2, x3, y3);
		_p.fill((int)(Math.random() * 179 + 69), (int)(Math.random() * 106 + 36));
	}
}
