package classes;

import java.awt.Graphics;

public class Circle extends SurfaceShape {
	
	private Point center;
	private int radius;
	
	public Circle() {
		
	}
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getSurfaceColor());
		g.fillOval(center.getX()-this.radius+1, center.getY()-this.radius+1, 2*this.radius-1, 2*this.radius-1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX()-this.radius, center.getY()-this.radius, 2*this.radius, 2*this.radius);
		if(isSelected()) {
			selected(g);
		}
	}

	@Override
	public void selected(Graphics g) {
		new Line(new Point(center.getX(),center.getY()-radius),new Point(center.getX(),center.getY()+radius)).selected(g);;
		new Line(new Point(center.getX()-radius,center.getY()),new Point(center.getX()+radius,center.getY())).selected(g);;
	}
	@Override
	public boolean contains(int x, int y) {
		if(new Point(x, y).distance(getCenter()) <= radius)
			return true;
		else
			return false;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
