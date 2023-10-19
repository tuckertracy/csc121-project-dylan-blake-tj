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

		c.fill(0, 0, 255);
		c.rect(this.x, this.y, this.width,this.height);
		c.circle(this.x + this.width/halfOfPlayer, this.y, this.headSize);

		return c;
	}

	Player move(int lat, int vert) {
		return new Player(this.x + lat, this.y + vert,this.height,this.width,this.headSize);
	}

}
