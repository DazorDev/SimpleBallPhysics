package dazor.main.physics.systems;

import java.util.List;

import dazor.main.physics.PhysicsSimulation;
import dazor.main.physics.components.Acceleration;

public class GravitySystem implements Runnable {

	private static final float GRAVITY_CONSTANT = 30f;
	
	@Override
	public void run() {
		List<Acceleration> accelerations = PhysicsSimulation.REIGN.getComponentType(Acceleration.class);
		PhysicsSimulation.REIGN.getIndexWhere(Acceleration.class)
			.stream()
			.map(accelerations::get)
			.forEach(GravitySystem::applyGravity);
	}
	
	private static void applyGravity(Acceleration acceleration) {
		acceleration.setY(acceleration.getY() + GRAVITY_CONSTANT);
	}
}
