import processing.core.PApplet;

public class World {
	BasketBall ball;
	 Hoop hoop;
	 Player p;

	public World(BasketBall ball, Hoop hoop, Player p) {
		this.ball = ball;
		this.hoop = hoop;
		this.p = p;
	}

	/**
	 * Renders a picture of the drop on the window
	 */
	public PApplet draw(PApplet c) {
		c.background(255);
		c.fill(0, 0, 255);
		this.ball.draw(c);
		this.p.draw(c);
		this.hoop.draw(c);

		

		/*
		 * //Draw hoop
		 * c.rect(this.hoop.x,this.hoop.y,this.hoop.height,.this.hoop.width);
		 * c.circle(this.hoop.x, this.hoop.height, this.hoop.size);
		*/

		return c;
	}

	/**
	 * Produces an updated world where the drop moves down a little bit, if it
	 * hasn't hit the bottom of the screen yet.
	 */

	public World update() {
		return this;
	}

	/* *//**
			 * Produces an updated world with the position of the drop updated to the
			 * location of the mouse press.
			 */
	/*
	 * 
	 * public CircleWorld mousePressed(MouseEvent mev) { return new
	 * CircleWorld(mev.getX(), mev.getY()); }
	 * 
	 *//**
		 * Produces a string rendering of the position of the drop
		 *//*
			 * public String toString() { return "[" + x + ", " + y + "]"; }
			 */

}
