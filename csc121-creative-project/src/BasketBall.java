import java.util.Objects;

import processing.core.PApplet;

public class BasketBall {
	Posn loc;   // current location of the ball
	Posn vel;   // current speed and direction = velocity
	int radius;
    Posn drag = new Posn(0, 0.5f);   // resistance to the ball's movement (gravity)
	
	public BasketBall(Posn loc, Posn vel, int radius) {
        this.loc = loc;
        this.vel = vel;
        this.radius = radius;
    }

    /** Draw basket ball */
	PApplet draw(PApplet c) {
		c.fill(255, 0, 0);
		c.circle((int) this.loc.getX(), (int) this.loc.getY(), this.radius);
		
		return c;
	}
	
	/** 
	 * update the location, and velocity of this ball
	 * @return
	 */
	BasketBall move() {
	    return new BasketBall(this.loc.translate(this.vel),
	                          this.vel.translate(this.drag),
	                          this.radius);
	}

	/**
	 * When the ball hits the back board its x velocity is reversed.
	 * @return
	 */
	BasketBall hit() {
		this.vel = new Posn(-this.vel.x, this.vel.y);
	    return this.move();
	}
	

    @Override
    public int hashCode() {
        return Objects.hash(loc, radius, vel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BasketBall other = (BasketBall) obj;
        return Objects.equals(loc, other.loc) && radius == other.radius && Objects.equals(vel, other.vel);
    }

    @Override
    public String toString() {
        return "BasketBall [loc=" + loc + ", vel=" + vel + ", radius=" + radius + ", drag=" + drag + "]";
    }

}
