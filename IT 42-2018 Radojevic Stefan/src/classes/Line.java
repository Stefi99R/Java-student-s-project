package classes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	public Line(Point startPoint, Point endPoint) {
		this.setStartPoint(startPoint);
		this.setEndPoint(endPoint);
	}
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint,endPoint);
		this.setColor(color);
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
		if(isSelected()) {
			selected(g);
		}
	}
	
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		startPoint.selected(g);
		endPoint.selected(g);
		getMiddlePoint().selected(g);
	}
	
	public Point getMiddlePoint() {
		int xMiddle = (startPoint.getX() + endPoint.getX())/2;
		int yMiddle = (startPoint.getY() + endPoint.getY())/2;
		Point midPoint;
		midPoint = new Point(xMiddle,yMiddle);
		return midPoint;
	}
	@Override
	public boolean contains(int x, int y) {
		Point temp = new Point(x, y);
		if((startPoint.distance(temp) + endPoint.distance(temp))-length()<=1)
			return true;
		else
			return false;
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
}
