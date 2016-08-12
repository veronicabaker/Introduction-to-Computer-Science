import processing.core.PApplet;


public class Pong extends PApplet
{
	
	final int WIDTH = 400, HEIGHT = 400;
		
	/**
	 * The background color of the window
	 */
	final int BACKGROUND_COLOR = 0;
	
	/**
	 * The diameter of the ball
	 */
	final int BALL_DIAMETER = 20;
	
	/**
	 * The paddle's x velocity
	 */
	final int PADDLE_VX = 3;
	
	/**
	 * The paddle's width
	 */
	final int PADDLE_WIDTH = 75;
	
	/**
	 * The paddle's height
	 */	
	final int PADDLE_HEIGHT = 15;

	/**
	 * The ball's max velocity
	 */	
	final int MAX_VELOCITY = 5;
	
	/**
	 * The ball's min velocity
	 */		
	final int MIN_VELOCITY = 2;	
	
	/**
	 * The ball instance representing the game's ball
	 */
	Ball ball;
	
	/**
	 * The Bar instance that represents the game's paddle
	 */
	Bar paddle;
	
    /**
     * Allow processing to be run as application rather than just applet
     */
    public static void main(String[] args) 
    {
        PApplet.main("Pong");
    }
                    
    /**
     * Sets height and width of sketch, initalizes game.
     */
	public void setup() 
	{
		size(WIDTH, HEIGHT);
		noStroke();
		reset();
	}
	
    /**
     * "Main" draw method... controls animation, clears screen, draws
     * elements and checks for collision.
     */
	public void draw() 
	{
		background(BACKGROUND_COLOR);
		
		//use the ball and paddle's move methods to move them to their
		// next location
		ball.move();
		paddle.move();
	
		// check if there's a collision... if there is, bounce the ball
		// in the opposite direction
		if (intersects(ball, paddle)) 
		{
			ball.vy *= -1;
			ball.y = paddle.y - ball.diameter / 2 - 1;
		}
		
		// draw an ellipse and a rectangle using the ball and 
		// paddle's member variables (the ball's x, y, and diameter
		// values... and the paddle's x, y, barWidth, and barHeight
		// values)
		ellipse(ball.x, ball.y, ball.diameter / 2, ball.diameter / 2);
		rect(paddle.x, paddle.y, paddle.barWidth, paddle.barHeight);
	}
	
    /**
     * Reacts to left, right and (r)eset keys. Left and right change
     * the direction of the paddle.
     */
	public void keyPressed() 
	{
		if(keyCode == LEFT) 
		{
			//tell the paddle to move left
			paddle.goLeft();
		} 
		else if(keyCode == RIGHT) 
		{
			//tell the paddle to move right
			paddle.goRight();
		}
		
		if(key == 'r') 
		{
			reset();
		}
	}
	
	/**
	 * brings the ball back to the center of the screen, with a
	 * random velocity for x and y... and add the paddle to the
	 * center bottom of the window, with an initial velocity
	 * going right
	 */
	public void reset() 
	{
		// TODO: implement a reset method to start the ball somewhere
		// in the window with a random velocity for x and y and start
		// the paddle in the center bottom of the window with an 
		// initial velocity going right
		
		// 1. do this by assigning a new Ball object to the ball variable
		//    and a new Bar object to the paddle variable
		// 2. use as many of the constants defined above as you can as
		//    arguments to the Ball and Bar constructors....
		//    a. for example, generate a random velocity based on the
		//       MIN_VELOCITY and MAX_VELOCITY constants
		//    b. initialize the paddle's velocity with PADDLE_VX, and
		//       its dimensions with PADDLE_WIDTH and PADDLE_HEIGHT
		ball = new Ball(WIDTH / 2, HEIGHT / 2, 
				(int)(Math.random() * (MAX_VELOCITY - MIN_VELOCITY + 1) + MIN_VELOCITY), 
				(int)(Math.random() * (MAX_VELOCITY - MIN_VELOCITY + 1) + MIN_VELOCITY), 
				WIDTH, HEIGHT, BALL_DIAMETER);
		paddle = new Bar(WIDTH / 2 + PADDLE_WIDTH / 2, HEIGHT - PADDLE_HEIGHT, 
				(int)(-1 * (Math.random() * (MAX_VELOCITY - MIN_VELOCITY + 1) + MIN_VELOCITY)), 
				PADDLE_WIDTH, PADDLE_HEIGHT, WIDTH);
	}
	
	
	/* *
	 * tests if the ball intersects with the paddle
	 * @param b the ball
	 * @param p the paddle
	 * @return true if the ball and paddle intersect
	 */
	boolean intersects(Ball b, Bar p) 
	{
		// TODO: determine if the ball intersects the paddle. Here's
		// a solution that works for most cases (it doesn't quite work
		// if the ball and paddle collide on the left or right most edge)
		// 1. determine the point closest to the circle that's in the paddle:
		//    a. the x coordinate is going to be the paddle's
		//       left x coordinate if the ball is to the paddle's left
		//    b. the x coordinate is going to be the paddle's
		//       right x coordinate if the ball is to the paddle's right
		//    c. the x coordinate is going to be the ball's own x coordinate
		//       if the ball is between the left and right most x value
		//       of the paddle
		// 2. once you have the closest point in the paddle... determine
		//    its distance from the ball's center
		// 3. if this distance is less than the radius, then we have an 
		//    intersection!
		int closestX;
		double distance;
		if(p.x < b.x && b.x < p.x + p.barWidth)
		{
			closestX = b.x;
			distance = Math.sqrt(Math.pow(closestX - b.x, 2) + Math.pow(b.y - p.y, 2));
		}
		else if(b.x < p.x)
		{
			closestX = p.x;
			distance = Math.sqrt(Math.pow(closestX - b.x, 2) + Math.pow(p.y - b.y, 2));
		}
		else
		{
			closestX = p.x + p.barWidth;
			distance = Math.sqrt(Math.pow(closestX - b.x, 2) + Math.pow(p.y - b.y, 2));
		}
		if(distance < b.diameter / 2)
		{
			return true;
		}
		return false;
	}
	
	/* *
	 * generates a random integer from a, up to but not including b
	 * @param a the start number
	 * @param b goes up to, but does not include this number
	 * @return a random integer from a to b
	 */
	private int randInt(int a, int b) 
	{
		return (int) (Math.random() * (b - a) + a);
	}
	
	/* *
	 * generates a 1 or -1
	 * @return either 1 or -1
	 */
	private int randSign() 
	{
		//Implement a short method to generate either a 1 or a -1
		int x = randInt(-10, 10);
		if(x < 0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
