
public class Ball 
{
	//x position
	int x;
	//y position
	int y;
	//balll's horizontal velocity
	int vx;
	//ball's vertical velocity
	int vy;
	//width of window 
	int boardWidth;
	//height of window
	int boardHeight;
	//diameter of ball
	int diameter;
	
	//constructor to set all variables
	public Ball(int newX, int newY, int newVX, int newVY, int newBoardWidth,
			int newBoardHeight, int newDiameter)
	{
		x = newX;
		y = newY;
		vx = newVX;
		vy = newVY;
		boardWidth = newBoardWidth;
		boardHeight = newBoardHeight;
		diameter = newDiameter;
	}
	//move method
	public void move()
	{
		//add x and y velocity to position
		x += vx;
		y += vy;
		//if the ball goes off screen in the x direction
		//flip sign of x velocity
		//reposition it to be on the screen
		if(x + diameter / 2 > boardWidth)
		{
			vx *= -1;
			x = boardWidth - diameter / 2;
		}
		else if(x - diameter / 2 < 0)
		{
			vx *= -1;
			x += diameter / 2;
		}
		//if the ball goes above the screen
		//flip the sign of y velocity
		//reposition it to be on screen
		if(y - diameter / 2 < 0)
		{
			vy *= -1;
			y = diameter / 2;
		}
	}
}
