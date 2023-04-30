package dazor.main.physics.systems;

import dazor.main.physics.GUI;
import dazor.main.physics.PhysicsSimulation;
import dazor.main.physics.components.Acceleration;
import dazor.main.physics.components.BallColor;
import dazor.main.physics.components.Bounds;
import dazor.main.physics.components.Mass;
import dazor.main.physics.components.Position;

public class CreateBallsSystem implements Runnable {

	static int nBalls = 0;
	static final int maxBalls = 1000;
	static int count = 0;
	static final int spawnAfter = 5;
	static final int xOffset = 100;
	static final int yOffset = 100;
	static final float centerX = GUI.CIRCLE_RADIUS;
	static final float centerY = GUI.CIRCLE_RADIUS;
	static final float maxX = 250;
	static final float maxY = 250;
	static final int minSize = 5;
	static final int maxSize = 40;
	static float rotationCount = 0;
	static float rotationAcceleration = 100;
	static final float rotationIncrease = 1f;
	@Override
	public void run() {
		if(count++ < spawnAfter) return;
		count = 0;
		if(nBalls++ > maxBalls) {
			PhysicsSimulation.REIGN.removeSystem(this);
			return;
		}
		float x = centerX;
		float y = centerY;
		float r = minSize;
		PhysicsSimulation.REIGN.addEntity(new Position(x,y), new BallColor(), new Mass(10), new Acceleration((int)(Math.sin(rotationCount)*10),1), new Bounds(r));
		rotationCount+=rotationIncrease;
	}

}
