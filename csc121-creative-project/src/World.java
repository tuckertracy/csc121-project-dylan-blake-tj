
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
		int increment = 1;
		World state = this;


		if(ball.loc.y >= shotVertex.y) {
			state = new World(this.ball.move(), hoop, p, time + increment, score, shotVertex);
		} else {
			state = new World(this.ball.move(), hoop, p, time + increment, score, shotVertex);
		}

		if(
			( (ball.loc.y <= hoop.loc.y & ball.loc.y >= hoop.loc.y - hoop.b.getHeight()) & 
					(ball.loc.x >= hoop.loc.x - hoop.b.getWidth()/2 ) )
			
				) {
			//this.ball.vel = new Posn(-this.ball.vel.x, this.ball.vel.y);
			state = new World(this.ball.hit(), hoop, p, time, score, shotVertex);
		} 
		
		if(this.hoop.shotIn(this.ball.loc)) {
			state = new World(this.ball.move(), hoop, p, time + increment, score + increment, shotVertex);
		} else {
			return state;
		}
		
		return state;
	}

	public World keyPressed(KeyEvent key) {
		char k = key.getKey();

		int positionChange = 5;

		if (k == 'a') {
			return new World(ball, hoop,
					p.move(-positionChange,0), time,score,shotVertex);

		} else if (k == 'd') {
			return new World(ball, hoop,
					this.p.move(positionChange,0), time,score,shotVertex);
		}  else
			return this;
	}

	/**
	 * Produces an updated world with the position of the drop updated to the
	 * location of the mouse press.
	 */
	public World mousePressed(MouseEvent mev) { 
		int reducePower = 15;

		Posn vertex = new Posn(mev.getX(),mev.getY()); 
		return new World(
				new BasketBall(
						new Posn(p.x, p.y), 
						new Posn( (shotVertex.x - p.x) / reducePower, (shotVertex.y - p.y) / reducePower), 
						ball.radius),
				hoop,p,time,score,vertex); }


}
