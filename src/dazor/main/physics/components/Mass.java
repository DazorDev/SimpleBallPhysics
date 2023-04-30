package dazor.main.physics.components;

public class Mass {

	double mass;

	public Mass() {
		this(0);
	}
	
	public Mass(double mass) {
		super();
		this.mass = mass;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
	
}
