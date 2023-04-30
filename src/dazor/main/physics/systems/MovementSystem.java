package dazor.main.physics.systems;

import java.util.List;

import dazor.main.physics.PhysicsSimulation;
import dazor.main.physics.components.Position;
import dazor.main.physics.components.Acceleration;

public class MovementSystem implements Runnable {

	@Override
	public void run() {
		List<Position> positions  = PhysicsSimulation.REIGN.getComponentType(Position.class);
		List<Acceleration> velocities = PhysicsSimulation.REIGN.getComponentType(Acceleration.class);
		List<Integer> ints = PhysicsSimulation.REIGN.getIndexWhere(Position.class, Acceleration.class);
		for(int i: ints ) {
			applyMovement(positions.get(i),velocities.get(i));
		}
	}
	
	private static void applyMovement(Position point, Acceleration acceleration) {
		float velX = point.getX() - point.getOldX();
		float velY = point.getY() - point.getOldY();
//		System.out.println("Positions  : " +point.getX() + " " + point.getY());
//		System.out.println("Velocities : " +velX + " " + velY);
		float dT = 1.f/(1000/60);
		point.setOldX(point.getX());
		point.setOldY(point.getY());
		point.setX(point.getX() + velX + acceleration.getX() * (dT*dT));
		point.setY(point.getY() + velY + acceleration.getY() * (dT*dT));
//		System.out.println(point.getX() + " " + point.getY());
	}

}
