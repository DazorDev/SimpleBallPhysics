package dazor.main.physics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dazor.main.physics.components.BallColor;
import dazor.main.physics.components.Bounds;
import dazor.main.physics.components.Position;

public class GUI extends JFrame {
	
	public GUI() {
		this.setDefaultCloseOperation(3);
		this.setIgnoreRepaint(true);
		this.add(new Canvas());
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.pack();
		this.setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	
	public static final int CIRCLE_RADIUS = WIDTH/2;	
	public static final int CIRCLE_X = WIDTH/2;
	public static final int CIRCLE_Y = HEIGHT/2;
	
	private class Canvas extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Canvas() {
			this.setPreferredSize(new Dimension(500,500));
			this.setSize(500,500);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			List<Position> positions = PhysicsSimulation.REIGN.getComponentType(Position.class);
			List<Bounds>   bounds    = PhysicsSimulation.REIGN.getComponentType(Bounds.class);
			List<BallColor> colors   = PhysicsSimulation.REIGN.getComponentType(BallColor.class);
			List<Integer> ints = PhysicsSimulation.REIGN.getIndexWhere(Position.class, Bounds.class, BallColor.class);
			clear(g);
			drawBoundary(g);
			for(int i : ints) paintCircle(g,positions.get(i),bounds.get(i), colors.get(i));
		}
		
		
		private static void paintCircle(Graphics g, Position p, Bounds b, BallColor color) {
			g.setColor(color.getColor());
			g.fillArc((int)(p.getX()-b.getRadius()), (int)(p.getY()-b.getRadius()), (int)b.getRadius()*2, (int)b.getRadius()*2, 0, 360);
			g.setColor(Color.black);
		}
		
		private void clear(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.black);
		}
		
		private static void drawBoundary(Graphics g) {
			g.drawArc(CIRCLE_X-CIRCLE_RADIUS/2, CIRCLE_Y-CIRCLE_RADIUS/2, CIRCLE_RADIUS, CIRCLE_RADIUS, 0, 360);
		}
		
		
		
	}
	
	
	
}
