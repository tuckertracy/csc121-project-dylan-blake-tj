
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
		c.fill(0, 0, 0);
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
		}  else if (k=='e') {
			this.saveScore();
			this.copyScores();
			this.orderScores();
			System.exit(0);
		} 

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
						new Posn(p.returnX(), p.returnY()), 
						new Posn( (shotVertex.x - p.returnX()) / reducePower, (shotVertex.y - p.returnY()) / reducePower), 
						ball.radius),
				hoop,p,time,score, vertex); 
	}

	public void saveScore() {
		try {
			PrintWriter pw = new PrintWriter(new File("scores.txt"));
			pw.print(this.score);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyScores() {

		try {

			// open file with scores
			File f = new File("output.txt");

			// found on internet to add text to existing files
			FileWriter fw = new FileWriter("output.txt",true); 
			BufferedWriter bw = new BufferedWriter(fw); 
			PrintWriter pw = new PrintWriter(bw);

			// open file with score of game
			Scanner sc = new Scanner(new File("scores.txt"));

			if (f.length() == 0) {

				System.out.println("file empty");

				// open file with score of game
				while(sc.hasNextInt()) {
					int s = sc.nextInt();
					pw.println(s);
				}

				System.out.println("added score");


				bw.close();
				fw.close();
				pw.close();

			} else if (f.length() > 0) {

				Scanner df = new Scanner(new File("output.txt"));

				/** copies score from current game to the output.txt file **/

				while ( sc.hasNextInt()) {
					int s = sc.nextInt();
					pw.println(s);
				}


				/** sorts the current entries in the output file **/
				/*
				// create an empty array
				ArrayList<Integer> al = new ArrayList<Integer>();

				// add all the current integers into an ArrayList
				while (df.hasNextInt()) {
					int s = df.nextInt();
					al.add(s);
				}
				// sort the array list
				Collections.sort(al);


				for(int s : al) {
					pw.println(s);
				}

				sc.close();				


			}*/

				bw.close();
				fw.close();
				pw.close();


			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	public void orderScores() {
		try {
			File scores = new File("output.txt");
						
			Scanner sc = new Scanner(new File("output.txt"));
			PrintWriter pw = new PrintWriter(new File("leaderboard.txt"));
			
			/** sorts the current entries in the output file **/
			
			// create an empty array
			ArrayList<Integer> al = new ArrayList<Integer>();

			// add all the current integers into an ArrayList
			while (sc.hasNextInt()) {
				int s = sc.nextInt();
				al.add(s);
			}
			
			// sort the array list
			Collections.sort(al, Collections.reverseOrder());


			for(int i = 0 ; i < 5 ; i++) {
				pw.println(i+1 + ") " + al.get(i));
			}
			
			sc.close();
			pw.close();
			
		} catch (IOException e) {
			System.out.print("err");
		}
	}


}
