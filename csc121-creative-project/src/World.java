
import processing.core.*;
import processing.event.*;

public class World {
	BasketBall ball;
	Hoop hoop;
	Player p;
	int time;
	Posn shotVertex;

	public World(BasketBall ball, Hoop hoop, Player p, int time, Posn shotVertex) {
		this.ball = ball;
		this.hoop = hoop;
		this.p = p;
		this.time = time;
		this.shotVertex = shotVertex;
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

		return c;
	}

	/**
	 * Produces an updated world
	 */

	public World update() {

		/*
		 * if (ball.y > p.height / 2 & ball.y < 300) { ball = new BasketBall(ball.x,
		 * ball.y + .5, ball.radius); return new World(ball, hoop, p, time + 1); } else
		 * if (ball.y >= 300) { ball = new BasketBall(ball.x, ball.y - 35, ball.radius);
		 * return new World(ball, hoop, p, time + 1); } else { return this; }
		 */
		if(ball.y >= 300){
			return new World(new BasketBall(p.x - 15, p.y + 10, ball.radius),hoop,p,time+1,
					shotVertex = new Posn(300,300));
		}else if(ball.x < shotVertex.x & ball.y > shotVertex.y) {
			return new World(new BasketBall(ball.x + 1, ball.y-1,ball.radius),hoop,p,time+1,
					shotVertex);
		} else if (ball.x >= shotVertex.x & ball.y >= shotVertex.y){
			return new World(new BasketBall(ball.x + 1, ball.y+1,ball.radius),hoop,p,time+1,
					shotVertex);
		} else {
			return this;
		}

	}

	public World keyPressed(KeyEvent key) {
		char k = key.getKey();

		if (k == 'a') {
			return new World(new BasketBall(p.x - 15, p.y + 10, ball.radius), hoop,
					new Player(p.x - 5, p.y, p.height, p.width, p.headSize), time,shotVertex);

		} else if (k == 'd') {
			return new World(new BasketBall(p.x + 25, p.y + 10, ball.radius), hoop,
					new Player(p.x + 5, p.y, p.height, p.width, p.headSize), time,shotVertex);

		} else if (k == 'w') {
			return new World(new BasketBall(p.x + 25, p.y - 15, ball.radius), hoop,
					new Player(p.x, p.y - 5, p.height, p.width, p.headSize), time,shotVertex);

		} else if (k == 's') {
			return new World(new BasketBall(p.x + 20, p.y + 15, ball.radius), hoop,
					new Player(p.x, p.y + 5, p.height, p.width, p.headSize), time,shotVertex);

		} else
			return new World(ball, hoop, p, time,shotVertex);
	}

	/**
	 * Produces an updated world with the position of the drop updated to the
	 * location of the mouse press.
	 */
		  public World mousePressed(MouseEvent mev) { Posn vertex = new
		  Posn(mev.getX(),mev.getY()); return new World(ball,hoop,p,time,vertex); }
		 

}
