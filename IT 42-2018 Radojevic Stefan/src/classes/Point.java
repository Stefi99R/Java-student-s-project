package classes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	private int x;
	private int y;
	
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x-3, y, x+3, y);
		g.drawLine(x, y-3, x, y+3);
		if(isSelected()) {
			selected(g);
		}
	}
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}
	public boolean contains(int x, int y) {
		if(this.distance(new Point(x, y))<=2) {
			return true;
		}
		else {
			return false;
		}
	}
	public double distance(Point p) {
		int dX = x - p.x;
		int dY = p.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
