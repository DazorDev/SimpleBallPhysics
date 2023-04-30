package dazor.main.physics.components;

public class Position {

	float x,y;
	
	float oldX, oldY;
	
	
	public Position() {
		
	}
	
	public Position(float x, float y) {
		super();
		System.out.println("NEW POSITIONS : " + x + " " + y);
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
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

	public float getOldX() {
		return oldX;
	}

	public void setOldX(float oldX) {
		this.oldX = oldX;
	}

	public float getOldY() {
		return oldY;
	}

	public void setOldY(float oldY) {
		this.oldY = oldY;
	}
	
}
