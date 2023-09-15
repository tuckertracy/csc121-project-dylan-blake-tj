import processing.core.PApplet;

public class BasketBall {
	int x;
	int y;
	int radius;
	
	public BasketBall(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/** Draw basket ball */
	PApplet draw(PApplet c) {
		
		c.circle(this.x, this.y, this.radius);
		
		return c;
	}

}
