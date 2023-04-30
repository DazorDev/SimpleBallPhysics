package dazor.main.physics.systems;

import java.util.List;

import dazor.main.physics.PhysicsSimulation;
import dazor.main.physics.components.Bounds;
import dazor.main.physics.components.Position;

public class CollisionSystem implements Runnable {

	@Override
	public void run() {
		List<Position> positions = PhysicsSimulation.REIGN.getComponentType(Position.class);
		List<Bounds> bounds = PhysicsSimulation.REIGN.getComponentType(Bounds.class);
		List<Integer> ints = PhysicsSimulation.REIGN.getIndexWhere(Position.class,Bounds.class);
		for(int i: ints ) {
			for(int j : ints) {
				if(i==j) continue;
				handleCollision(positions.get(i),bounds.get(i),positions.get(j),bounds.get(j));
			}
		}
	}
	
	private static void handleCollision(Position p1, Bounds b1, Position p2, Bounds b2) {
//		System.out.println("before : " +p1.getX() + " " + p1.getY());
		float deltaX = p1.getX() - p2.getX();
		float deltaY = p1.getY() - p2.getY();
		float distance = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		float minDistance = b1.getRadius() + b2.getRadius();
		if(distance > minDistance) return;
//		if(Float.isNaN(distance)) {
//			System.out.println("IS NAN X = " + p1.getX() + " | " + p2.getX());
//			System.out.println("IS NAN Y = " + p1.getY() + " | " + p2.getY());
//			System.exit(1);
//		}
//		System.out.println(distance);
		float x = deltaX / distance;
		float y = deltaY / distance;
		float delta = minDistance - distance;
		p1.setX(p1.getX() + 0.5f * delta * x);
		p1.setY(p1.getY() + 0.5f * delta * y);
		p2.setX(p2.getX() - 0.5f * delta * x);
		p2.setY(p2.getY() - 0.5f * delta * y);
	}
	
}
