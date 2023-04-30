package dazor.main.physics.components;

import java.awt.Color;

public class BallColor {

	static float hue = 0;
	static final float light = 1f;
	static final float saturation = 0.5f;
	static final float HSL_WHEEL = 360;
	
	public BallColor() {
		this.color = new Color(Color.HSBtoRGB(hue%1, saturation, light));
		hue += 0.01f;
	}
	
	private final Color color;

	public Color getColor() {
		return color;
	}
	
}
