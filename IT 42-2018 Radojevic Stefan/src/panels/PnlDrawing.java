package panels;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import classes.Shape;
import classes.SurfaceShape;

@SuppressWarnings("serial")
public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> ite = shapes.iterator();
		while(ite.hasNext()) {
			Shape shapeTemp = ite.next();
			if(shapeTemp instanceof SurfaceShape)
			{
				((SurfaceShape) shapeTemp).fill(g);
			}
			shapeTemp.draw(g);
		}
		
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

}
