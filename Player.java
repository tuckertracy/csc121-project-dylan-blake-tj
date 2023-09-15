import processing.core.PApplet;

public class Player {
	int x;
	int y;
	int height;
	int width;
	int headSize;
	
	public Player(int x, int y, int height, int width, int headSize) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.headSize = headSize;
	}	
	
	/** Draw player */
	PApplet draw(PApplet c) {
		c.rect(this.x, this.y, this.width,this.height);
		c.circle(this.x + this.width/2, this.y, this.headSize);
		
		return c;
	}
}
