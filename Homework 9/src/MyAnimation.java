
/*
 * Veronica Baker
 * Intro to CS
 * 
 */

import java.util.ArrayList;

import processing.core.PApplet;

public class MyAnimation extends PApplet
{
	public static void main(String[] args)
	{
		PApplet.main("MyAnimation");
	}
	ArrayList<Shapes> shapeList = new ArrayList<>();
	public void setup()
	{
		size(500, 500);
		shapeList.add(new Road(-1000, 355, 500, 5));
	}
	public void draw()
	{
		background(73, 179, 245);
		sun(50, 50, 50);
		road(300, 75);
		ground();
		car(265, 265);
		for(int i = 0; i < shapeList.size(); i++)
		{
			if(shapeList.get(i) != null)
			{
				shapeList.get(i).render();
				shapeList.get(i).reset(500, -1000);
			}
		}
	}
	public void keyPressed()
	{
		if(key == CODED)
		{
			int randomX = (int)(Math.random() * 500);
			if(keyCode == 'm')
			{
				shapeList.add( new Mountain(randomX, 300, randomX + 300, 300, randomX + 150, 75, 1));
			}
			else if(keyCode == 't')
			{
				shapeList.add(new Tree(randomX, 275, randomX + 30, 275, randomX + 15, 200, 3));
			}
		}
	}
	//draw the sun
		public void sun(int x, int y, int r)
		{
			noStroke();
			fill(250, 242, 22);
			ellipse(x, y, r, r);	
		}
		//draw some grass
		public void ground()
		{
			noStroke();
			fill(105, 204, 88);
			rect(0, 375, width, 200);
		}
		//draw a pink car
		public void car(int x, int y)
		{
			noStroke();
			fill(245, 54, 197);
			rect(x, y, 75, 25);
			rect(x + 10, y - 20, 60, 20);
			fill(0);
			ellipse(x + 15, y + 25, 20, 20);
			ellipse(x + 55, y + 25, 20, 20);
			fill(201, 240, 242);
			rect(x + 17, y - 15, 15, 15);
		}
		public void road(int y, int height)
		{
			fill(200);
			rect(0, y, width, height);
		}
}
