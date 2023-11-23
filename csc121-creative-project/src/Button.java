import processing.core.PApplet;

public class Button {
	int x;
	int y;
	int width;
	int height;
	int color;
	
	Button(int x, int y, int width, int height, int color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	PApplet Draw(PApplet c) {
		c.fill(color);
		c.rect(x, y, width, height);	
		return c;
	}
	
	boolean isPressed(PApplet c) {
		if (c.mousePressed == true && c.mouseX >= x && c.mouseX <= x + width && c.mouseY >= y && c.mouseY <= y + height) {
			return true;
		} else {
			return false;
		}
	}
	
	PApplet checkButton(PApplet c) {
		if (c.mouseX >= x && c.mouseX <= x + width && c.mouseY >= y && c.mouseY <= y + height) {
			color = 204;
		} else {
			color = 255;
		}
		return c;
	}
	
}
