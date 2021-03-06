package com.heidenreich.patient.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class BoundedCamera extends OrthographicCamera {

	private float xmax;
	private float xmin;
	private float ymax;
	private float ymin;

	// Creates a new camera
	public BoundedCamera() {
		this(0, 0, 0, 0);
	}

	// Creates a new camera
	public BoundedCamera(float xmin, float xmax, float ymin, float ymax) {
		super();
		setBounds(xmin, xmax, ymin, ymax);
	}

	// Sets the cameras boundaries
	public void setBounds(float xmin, float xmax, float ymin, float ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}

	// Sets the position of the camera
	public void setPosition(float x, float y) {
		setPosition(x, y, 0);
	}

	// Sets the position of the camera
	public void setPosition(float x, float y, float z) {
		position.set(x, y, z);
		fixBounds();
	}

	// Fixes the boundaries of the camera
	private void fixBounds() {
		if (position.x < xmin + viewportWidth / 2) {
			position.x = xmin + viewportWidth / 2;
		}
		if (position.x > xmax - viewportWidth / 2) {
			position.x = xmax - viewportWidth / 2;
		}
		if (position.y < ymin + viewportHeight / 2) {
			position.y = ymin + viewportHeight / 2;
		}
		if (position.y > ymax - viewportHeight / 2) {
			position.y = ymax - viewportHeight / 2;
		}
	}
}
