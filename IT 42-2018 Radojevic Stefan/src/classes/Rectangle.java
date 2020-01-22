package classes;

import java.awt.Color;
import java.awt.Graphics;

import frames.SortFrame;
import frames.StackFrame;

public class Rectangle extends SurfaceShape {
	
	private float x;
	private float y;
	private float height;
	private float width;
	
	public Rectangle() {
		
	}
	
	public Rectangle(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Rectangle(float x, float y, float height, float width) {
		this(x,y);
		this.height = height;
		this.width = width;
	}
	
	public String toStringStack() {
		return "Rectangle #" + (StackFrame.dlmStack.getSize()+ 1) + ": Upper left point coordinates: (" + String.valueOf(getX()) + ", "
				 + String.valueOf(getY()) + "), Width: "
				+ String.valueOf(getWidth()) + ", Height: " + String.valueOf(getHeight());
	}
	
	public String toStringSort() {
		return "Upper left point coordinates: (" + String.valueOf(getX()) + ", "
				 + String.valueOf(getY()) + "), Width: "
				+ String.valueOf(getWidth()) + ", Height: " + String.valueOf(getHeight()) + ", Area: " + getArea();
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
		if(isSelected()) {
			selected(g);
		}
	}
	@Override
	public void fill(Graphics g) {
		g.setColor(getSurfaceColor());
		g.fillRect((int)x+1, (int)y+1, (int)width-1, (int)height-1);
	}
	
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(new Point((int)x,(int)y), new Point((int)x+(int)width,(int)y)).selected(g);
		new Line(new Point((int)x,(int)y), new Point((int)x,(int)y+(int)height)).selected(g);
		new Line(new Point((int)x,(int)y+(int)height), new Point((int)x+(int)width,(int)y+(int)height)).selected(g);
		new Line(new Point((int)x+(int)width,(int)y), new Point((int)x+(int)width,(int)y+(int)height)).selected(g);
	}
	
	public float getArea() {
		return (this.height*this.width);
	}
	
	@Override
	public boolean contains(int x, int y) {
		if(this.x<=x && x<=(this.x + width) && this.y<=y && y<=(this.y + height))
			return true;
		else 
			return false;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

}

