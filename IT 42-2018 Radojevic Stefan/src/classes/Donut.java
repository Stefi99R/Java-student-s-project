package classes;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut() {
		
	}
	public Donut(Point center, int radius, int innerRadius) {
		super(center,radius);
		this.innerRadius = innerRadius;
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getSurfaceColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - getInnerRadius(), getCenter().getY() - getInnerRadius(), getInnerRadius() * 2, getInnerRadius() * 2);
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, getInnerRadius() * 2, getInnerRadius() * 2);
		
		if(isSelected()) {
			selected(g);
		}
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		super.selected(g);
		new Line(new Point(super.getCenter().getX()-innerRadius,super.getCenter().getY()),new Point(super.getCenter().getX()+innerRadius,super.getCenter().getY())).selected(g);
		new Line(new Point(super.getCenter().getX(),super.getCenter().getY()-innerRadius),new Point(super.getCenter().getX(),super.getCenter().getY()+innerRadius)).selected(g);
	}
	
	public boolean contains(int x, int y) {
		if((new Point(x,y).distance(getCenter()) <= getRadius()) && (new Point(x,y).distance(getCenter()) >= innerRadius)) {
			return true;
		} else return false;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

}
