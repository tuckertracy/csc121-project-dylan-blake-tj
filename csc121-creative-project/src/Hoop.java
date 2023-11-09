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


	public Hoop(Posn loc, Pole po, Board b, int radius) {
		this.loc = loc;
		this.po = po;
		this.b = b;
		this.radius = radius;
	}
	

	/** Draw basketball hoop */
	PApplet draw(PApplet c) {
		
		int halfOfShape = 2;
		int quarterOfShape = 4;

		float hoopX = this.loc.x;
		float hoopY = this.loc.y;
		float poleWidth = this.po.getWidth();
		float poleHeight = this.po.getHeight();
		float boardWidth = this.b.getWidth();
		float boardHeight = this.b.getHeight();
				
		
		
		/** draw the pole */
		c.fill(0, 0, 0);
		c.rect(hoopX,hoopY - boardHeight/2,poleWidth,poleHeight);
		
		/** draw the board */
		c.fill(192, 192, 192);
		c.rect(hoopX - boardWidth + poleWidth/halfOfShape, hoopY - boardHeight, 
				boardWidth, boardHeight);
		
		/** draw the hoop */
		c.fill(255, 165, 0);
		//c.circle(hoopX - boardWidth/halfOfShape, hoopY - boardHeight/quarterOfShape, this.radius);
		c.ellipse(hoopX - boardWidth-quarterOfShape, hoopY - boardHeight/quarterOfShape, this.radius, this.radius/3);

		return c;
	}

	public boolean shotIn(Posn that) {
		boolean shotMade = false;
		Posn rim = new Posn(235,215);
		if(rim.distanceTo(that) <= 4) {
			shotMade = true;
		}
		return shotMade;
	}


}


