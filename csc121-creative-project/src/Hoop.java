import processing.core.PApplet;

class partOfHoop {
	int height;
	int width;

	public partOfHoop(int height, int width) {
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


class Pole extends partOfHoop{
	
	public Pole(int height, int width) {
		super(height,width);
	}

}

class Board extends partOfHoop {
	public Board(int height, int width) {
		super(height,width);
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
<<<<<<< HEAD
		
		int halfOfShape = 2;
		float hoopX = this.loc.x;
		float hoopY = this.loc.y;
		float poleWidth = this.po.getWidth();
		float poleHeight = this.po.getHeight();
		float ballWidth = this.b.getWidth();
		float ballHeight = this.b.getHeight();
		
		c.fill(0, 0, 255);
		
		c.rect(hoopX,hoopY,poleWidth,poleHeight);
		
		c.rect(hoopX - ballWidth/halfOfShape, hoopY - poleHeight/halfOfShape, 
				ballWidth, ballHeight);
		
		c.circle(hoopX - ballWidth/halfOfShape, hoopY, this.radius);
		
=======
	   c.fill(0, 0, 255);
		c.rect(this.loc.x,this.loc.y,this.po.getWidth(),this.po.getHeight());
		c.rect(this.loc.x - this.b.getWidth()/2, this.loc.y - this.po.getHeight()/2, 
				this.b.getWidth(), this.b.getHeight());
		c.circle(this.loc.x-this.b.getWidth()/2-this.radius/2, this.loc.y, this.radius);
>>>>>>> 0d8540d73a57120b49c496f211989dd6c6110b3e
		return c;
	}

	public boolean shotIn(Posn that) {
		if(this.loc.distanceTo(that) <= this.radius) {
			this.shotMade=true;
		}
		return shotMade;
	}


}


