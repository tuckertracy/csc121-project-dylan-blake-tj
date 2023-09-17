import processing.core.PApplet;

public class BasketBall {
	double x;
	double y;
	int radius;
	
	public BasketBall(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/** Draw basket ball */
	PApplet draw(PApplet c) {
		
		c.circle((int) this.x, (int) this.y, this.radius);
		
		return c;
	}

}
