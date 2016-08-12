
public class Bar 
{
	//the bar will continuously move until user flips velocity
	
	//member variables
	//bar's x position
	int x;
	//bar's y position
	int y;
	//the bar's x velocity
	int vx;
	//the width of the bar
	int barWidth;
	//the height of the bar
	int barHeight;
	//the width of the window
	int boardWidth;
	
	//constructor
	public Bar(int newX, int newY, int newVX, int newBarWidth, int newBarHeight, int newBoardWidth)
	{
		x = newX;
		y = newY;
		vx = newVX;
		barWidth = newBarWidth;
		barHeight = newBarHeight;
		boardWidth = newBoardWidth;
	}
	
	//move method
	public void move()
	{
		//add velocity to x position
		x += vx;
		//if the bar  goes beyond the left or right bounds
		//set the position to the furthest left or firght it can go
		if(x < 0)
		{
			x = 0;
			vx *= -1;
		}
		else if(x + barWidth > boardWidth)
		{
			x = boardWidth - barWidth;
			vx *= -1;
		}
	}
	public void goLeft()
	{
		if(vx > 0)
		{
			vx *= -1;
		}
	}
	public void goRight()
	{
		if(vx < 0)
		{
			vx *= -1;
		}
	}
}
