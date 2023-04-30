package dazor.main.physics.systems;

import java.util.List;

import dazor.main.physics.PhysicsSimulation;
import dazor.main.physics.components.Acceleration;

public class WeakenVelocity implements Runnable {
	
	@Override
	public void run() {
		List<Acceleration> velocities = PhysicsSimulation.REIGN.getComponentType(Acceleration.class);
		List<Integer> ints = PhysicsSimulation.REIGN.getIndexWhere(Acceleration.class);
		for(int i: ints) {
			weaken(velocities.get(i));
		}
//		ints.stream()
//			.map(velocities::get)
//			.forEach(WeakenVelocity::weaken);
	}
	
	private static void weaken(Acceleration accel) {
		accel.setX(0);
		accel.setY(0);
	}
}
