
import processing.core.*;
import processing.event.*;

public class World {
	BasketBall ball;
	Hoop hoop;
	Player p;
	int time;
	int score;
	Posn shotVertex;

	public World(BasketBall ball, Hoop hoop, Player p, int time, int score, Posn shotVertex) {
		this.ball = ball;
		this.hoop = hoop;
		this.p = p;
		this.time = time;
		this.score = score;
		this.shotVertex = shotVertex;
	}

	/**
	 * Renders a picture of the drop on the window
	 */
	public PApplet draw(PApplet c) {
		c.background(255);
		c.text(score,10,10);
		c.text(time/60, 280,10);

		this.ball.draw(c);
		this.p.draw(c);
		this.hoop.draw(c);

		return c;
	}

	/**
	 * Produces an updated world
	 */

	public World update() {
		
		if(ball.loc.distanceTo(hoop.loc) <= hoop.radius) {
			return new World(this.ball.move(), hoop, p, time+1, score + 10, shotVertex);
		}

		if(ball.loc.y >= shotVertex.y) {
			return new World(this.ball.move(), hoop, p, time+1, score, shotVertex);
		} else {
			return this;
		}
		
		

	}

	public World keyPressed(KeyEvent key) {
		char k = key.getKey();

		if (k == 'a') {
			return new World(ball, hoop,
					p.move(-5,0), time,score,shotVertex);

		} else if (k == 'd') {
			return new World(ball, hoop,
					this.p.move(5,0), time,score,shotVertex);
		}  else
			return this;
	}

	/**
	 * Produces an updated world with the position of the drop updated to the
	 * location of the mouse press.
	 */
	public World mousePressed(MouseEvent mev) { 
		int reducePowerFactor = 15;
		
		Posn vertex = new Posn(mev.getX(),mev.getY()); 
		return new World(new BasketBall(new Posn(p.x, p.y), 
						new Posn( (shotVertex.x - p.x) / reducePowerFactor, 
								  (shotVertex.y - p.y) / reducePowerFactor ), 
						ball.radius),
				hoop,p,time,score,vertex); }


}
