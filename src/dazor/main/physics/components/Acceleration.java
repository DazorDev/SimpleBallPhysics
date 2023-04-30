package dazor.main.physics.components;

public class Acceleration {

	float x,y;

	public Acceleration() {
		this(0,0);
	}
	
	public Acceleration(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
