import processing.core.PApplet;
import processing.event.*;
import java.util.*;
import java.io.*;



/**
 * Provides the scaffolding to launch a Processing application
 */
public class WorldApp extends PApplet {
	World w;

	public void settings() {
		this.size(300, 300);
	}

	public void setup() {
		w = new World(
				new BasketBall(new Posn(150,260), new Posn(4, -2), 10),
				new Hoop(new Posn(250,230),new Pole(100,10),new Board(50,10),20),
				new Player(150,260,20,10,15),
				0,
				0,
				new Posn(120,300)
				);
		}

	public void draw() {

		w = w.update();
		w.draw(this);

	}


	public void mousePressed(MouseEvent mev) { w = w.mousePressed(mev); }


	public void keyPressed(KeyEvent kev) {  w = w.keyPressed(kev); }


	public static void main(String[] args) {
		PApplet.runSketch(new String[] { "CircleApp" }, new WorldApp());
	}
}
