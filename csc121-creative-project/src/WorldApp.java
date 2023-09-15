import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class WorldApp extends PApplet {
    World w;
    
    public void settings() {
        this.size(300, 300);
    }
    
    public void setup() {
        w = new World(new BasketBall(150,260,10),
        		new Hoop(250,230,new Pole(60,10),new Board(40,48),20,false),
        		new Player(120,250,40,10,15));
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
	/*
	 * public void mousePressed(MouseEvent mev) { w = w.mousePressed(mev); }
	 * 
	 * public void keyPressed(KeyEvent kev) { // w = w.keyPressed(kev); }
	 */

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "CircleApp" }, new WorldApp());
    }
}
