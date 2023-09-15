import processing.core.PApplet;

class Pole {
	int height;
	int width;
	
	public Pole(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	int getHeight() {
		return this.height;
	}
	
	int getWidth() {
		return this.width;
	}
}
 
 class Board {
	 int height;
	 int width;
	 
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	int getHeight() {
		return this.height;
	}
	
	int getWidth() {
		return this.width;
	}
 }

public class Hoop {
	int x;
	int y;
	Pole po;
	Board b;
	boolean shotMade;
	int radius;
	
	
	public Hoop(int x, int y, Pole po, Board b, int radius, boolean shotMade) {
		this.x = x;
		this.y = y;
		this.po = po;
		this.b = b;
		this.radius = radius;
		this.shotMade = shotMade;
	}
	
	/** Draw basketball hoop */
	PApplet draw(PApplet c) {
		c.rect(this.x,this.y,this.po.getWidth(),this.po.getHeight());
		c.rect(this.x - this.b.getWidth()/2, this.y - this.po.getHeight()/2, 
				this.b.getWidth(), this.b.getHeight());
		c.circle(this.x - this.b.getWidth()/2, this.y, this.radius);
		return c;
	}
	

}

 
