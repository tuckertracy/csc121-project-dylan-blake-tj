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
	Posn loc;
	Pole po;
	Board b;
	int radius;
	boolean shotMade;
	
	
	public Hoop(Posn loc, Pole po, Board b, int radius, boolean shotMade) {
		this.loc = loc;
		this.po = po;
		this.b = b;
		this.radius = radius;
		this.shotMade = shotMade;
	}
	
	/** Draw basketball hoop */
	PApplet draw(PApplet c) {
	   c.fill(0, 0, 255);
		c.rect(this.loc.x,this.loc.y,this.po.getWidth(),this.po.getHeight());
		c.rect(this.loc.x - this.b.getWidth()/2, this.loc.y - this.po.getHeight()/2, 
				this.b.getWidth(), this.b.getHeight());
		c.circle(this.loc.x - this.b.getWidth()/2, this.loc.y, this.radius);
		return c;
	}
	
	public boolean shotIn(Posn that) {
		if(this.loc.distanceTo(that) <= this.radius) {
			this.shotMade=true;
		}
		return shotMade;
	}
	

}

 
