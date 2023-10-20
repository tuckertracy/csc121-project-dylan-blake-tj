import processing.core.PApplet;
import processing.event.MouseEvent;
import processing.event.KeyEvent;

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
		int halfOfPlayer = 2;

		// Draws the body of the player
		c.fill(0, 0, 255);
		c.rect(this.x, this.y, this.width,this.height);
		// draws the legs of the player
		c.fill(50, 50, 50);
		c.rect(this.x, this.y+this.height, this.width/2,this.height);
		c.rect(this.x+this.width/2, this.y+this.height, this.width/2,this.height);
		// draws the head of the player
		c.fill(150, 75, 0);
		c.circle(this.x + this.width/halfOfPlayer, this.y-this.headSize/halfOfPlayer, this.headSize);
		// draws the arms of the player
		c.fill(150, 75, 0);
		c.rect(this.x-this.width/2, this.y, this.width/2,this.height);
		c.rect(this.x+this.width, this.y, this.width/2,this.height);
		c.fill(0, 0, 0);
		c.ellipse(this.x, this.y-this.headSize/2, headSize/4, headSize/4);
		c.ellipse(this.x+this.width, this.y-this.headSize/halfOfPlayer, headSize/4, headSize/4);
		c.line(this.x, this.y-this.headSize/2, this.x+this.width, this.y-this.headSize/2);
		return c;
	}

	Player move(int lat, int vert) {
		return new Player(this.x + lat, this.y + vert,this.height,this.width,this.headSize);
	}

}
