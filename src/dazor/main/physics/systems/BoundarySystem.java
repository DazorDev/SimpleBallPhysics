package dazor.main.physics.systems;

import java.util.List;

import dazor.main.physics.GUI;
import dazor.main.physics.PhysicsSimulation;
import dazor.main.physics.components.Bounds;
import dazor.main.physics.components.Position;
import dazor.main.physics.components.Acceleration;

public class BoundarySystem implements Runnable {

	private static final int RADIUS = GUI.CIRCLE_RADIUS/2;
	private static final int XPOS = GUI.CIRCLE_X;
	private static final int YPOS = GUI.CIRCLE_Y;
	
	@Override
	public void run() {
		List<Position> positions  = PhysicsSimulation.REIGN.getComponentType(Position.class);
		List<Bounds>   bounds     = PhysicsSimulation.REIGN.getComponentType(Bounds.class);
		List<Acceleration> velocities = PhysicsSimulation.REIGN.getComponentType(Acceleration.class);
		List<Integer> ints = PhysicsSimulation.REIGN.getIndexWhere(Position.class,Bounds.class,Acceleration.class);
		for(int i : ints ) {
			handleBounds(positions.get(i),bounds.get(i),velocities.get(i));
		}
	}

	private static void handleBounds(Position p, Bounds b, Acceleration v) {
		float dX = p.getX() - XPOS;
		float dY = p.getY() - YPOS;
		float distance = (float) Math.sqrt(dX*dX + dY*dY);
		if(distance <= RADIUS-b.getRadius()) {
			return;
		}
		float x = dX / distance;
		float y = dY / distance;
//		System.out.println(x);
		p.setX(XPOS + x * (RADIUS - b.getRadius()));
		p.setY(YPOS + y * (RADIUS - b.getRadius()));
	}
	
	
	
}
