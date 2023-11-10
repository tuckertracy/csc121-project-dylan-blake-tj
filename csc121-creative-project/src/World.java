
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
	int shotsMade;


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
		int move = 40;

		switch(score) {
		case 0:
			c.background(102, 102, 255);


			// first cloud
			c.fill(255);
			c.rect(100 - move, 50,70,20);

			c.fill(255);
			c.stroke(255);
			c.circle(100 - move,50,40);

			c.fill(255);
			c.stroke(255);
			c.circle(110 - move,53,40);

			c.fill(255);
			c.stroke(255);
			c.circle(120 - move,30,40);

			c.fill(255);
			c.stroke(255);
			c.circle(130 - move,50,40);

			c.fill(255);
			c.stroke(255);
			c.circle(140 - move,30,40);

			c.fill(255);
			c.stroke(255);
			c.circle(145 - move,57,40);

			c.fill(255);
			c.stroke(255);
			c.circle(155 - move,45,40);

			c.fill(255);
			c.stroke(255);
			c.circle(160 - move,55,40);

			// second cloud
			c.fill(255);
			c.rect(100 + move*2, 50 + move,70,20);

			c.fill(255);
			c.stroke(255);
			c.circle(100 + move*2,50 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(110 + move*2,53 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(120 + move*2,30 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(130 + move*2,50 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(140 + move*2,30 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(145 + move*2,57 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(155 + move*2,45 + move,40);

			c.fill(255);
			c.stroke(255);
			c.circle(160 + move*2 ,55 + move,40);



			c.noStroke();




			c.fill(0);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			//c.circle(235, 215, 10);
			break;
		case 1:
			c.background(0);
			c.fill(224,224,224);
			c.circle(100, 100, 50);

			c.fill(47,79,79);
			c.stroke(169);
			c.circle(100, 115, 10);
			c.noStroke();

			c.fill(47,79,79);
			c.stroke(169);
			c.circle(90, 95, 15);
			c.noStroke();

			c.fill(47,79,79);
			c.stroke(169);
			c.circle(115, 100, 10);
			c.noStroke();

			c.fill(255, 255, 255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;
		case 2:
			c.background(0);
			c.fill(170, 74, 68);
			c.circle(100, 100, 100);

			c.fill(255);
			c.stroke(47,79,79);
			c.ellipse(100, 55, 35,10);
			c.noStroke();

			//136, 8, 8

			c.fill(255);
			c.stroke(47,79,79);
			c.ellipse(100, 145, 30,10);
			c.noStroke();

			c.fill(255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			c.fill(136, 8, 8);
			c.stroke(136,0,0);
			c.circle(120, 100, 12);
			c.noStroke();

			c.fill(136, 8, 8);
			c.stroke(136,0,0);
			c.circle(80, 80, 25);
			c.noStroke();

			c.fill(136, 8, 8);
			c.stroke(136,0,0);
			c.circle(95, 120, 18);
			c.noStroke();


			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;
		case 3:
			c.background(0);
			c.fill(152, 251, 152);
			c.circle(100, 100, 150);


			
			c.fill(255);
			c.circle(215,150,4);
			c.fill(255);
			c.circle(240,70,4);
			c.fill(255);
			c.circle(150,30,4);
			c.fill(255);
			c.circle(200,95,4);
			c.fill(255);
			c.circle(260,30,4);
			c.fill(255);
			c.circle(20,180,4);
			c.fill(255);
			c.circle(120,200,4);
			c.fill(255);
			c.circle(60,20,4);
			c.fill(255);
			c.circle(20,20,4);
			c.fill(255);
			c.circle(85,230,4);
			c.fill(255);
			c.circle(170,225,4);
			c.fill(255);
			c.circle(185,190,4);



			c.fill(255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;

		case 4:
			c.background(0);
			c.fill(0,0,255);
			c.circle(100, 100, 150);
			c.fill(255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;
		case 5:
			c.background(0);
			c.fill(204,153,102);
			c.circle(100, 100, 150);

			c.noFill();
			c.stroke(150,75,0);
			c.ellipse(100,100,200,5);

			c.fill(255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;
		case 6:
			c.background(0);
			c.fill(153,255,255);
			c.circle(100, 100, 150);
			c.fill(255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;
		case 7:
			c.background(0);
			c.fill(255,153,204);
			c.circle(100, 100, 150);
			c.fill(255);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;
		case 8:
			c.background(0);
			c.fill(0,0,102);
			c.circle(100, 100, 150);
			c.fill(0, 0, 0);
			c.text(score,10,10);
			c.text(time/60, 280,10);
			c.text(shotsMade, 150,10);

			this.ball.draw(c);
			this.p.draw(c);
			this.hoop.draw(c);
			break;


		} 


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

			state = new World(this.ball.move(), hoop, p.move(-5 ,0), time + increment,  score + increment, shotVertex);
		}





		return state;
	}

	public World keyPressed(KeyEvent key) {
		char k = key.getKey();

		// int positionChange = 5;

		/*if (k == 'a') {
			return new World(ball, hoop,
					p.move(-positionChange,0), time,score,shotVertex);

		} else if (k == 'd') {
			return new World(ball, hoop,
					this.p.move(positionChange,0), time,score,shotVertex);
		} */  
		if (k=='e') {
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
