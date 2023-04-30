package dazor.main.physics;

import dazor.insight.framework.Insight;
import dazor.main.physics.systems.GravitySystem;
import dazor.main.physics.systems.BoundarySystem;
import dazor.main.physics.systems.CollisionSystem;
import dazor.main.physics.systems.CreateBallsSystem;
import dazor.main.physics.systems.MovementSystem;
import dazor.main.physics.systems.WeakenVelocity;
import dazor.reason.framework.Reason;
import dazor.reign.framework.Reign;

public class PhysicsSimulation {

	public static final Reign   REIGN   = Reign.create();
	public static final Reason  REASON  = Reason.create();
	public static final Insight INSIGHT = Insight.create();

	private static final GUI GUI = new GUI();
	
	private static final int TICKS = 60;
	private static final int SECOND = 1000;
	private static final int TICKS_SECOND = SECOND / TICKS;
	
	public static void main(String[] args) {
		register();
//		REASON.setDelta(TICKS_SECOND*50*60);
		REASON.loop(TICKS_SECOND, REIGN::tick, GUI::repaint);
	}
	
	private static void register() {
		REIGN.addSystem(new CreateBallsSystem());
		REIGN.addSystem(new GravitySystem());
		REIGN.addSystem(new MovementSystem());
		REIGN.addSystem(new WeakenVelocity());
		REIGN.addSystem(new BoundarySystem());
		REIGN.addSystem(new CollisionSystem());
		REIGN.addSystem(new CollisionSystem());
	}
	
}
