package com.heidenreich.patient.handlers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

	private float dx;
	private float dy;
	private float x;
	private float y;
	private int numDrawX;
	private int numDrawY;
	private OrthographicCamera gameCam;
	private Sprite image;

	// Creates new background
	public Background(Sprite image, OrthographicCamera gameCam) {
		this.image = image;
		this.gameCam = gameCam;
		numDrawX = 800 / image.getRegionWidth() + 1;
		numDrawY = 480 / image.getRegionHeight() + 1;
	}

	// Sets the speed of the background
	public void setVector(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}

	// Updates the backgroudn
	public void update(float dt) {
		x += dx * dt;
		y += dy * dt;
	}

	// Renders the background
	public void render(SpriteBatch sb) {
		// Calculates X and Y
		float x = ((this.x + gameCam.viewportWidth / 2 - gameCam.position.x))
				% image.getRegionWidth();
		float y = ((this.y + gameCam.viewportHeight / 2 - gameCam.position.y))
				% image.getRegionHeight();

		// Draws the background
		sb.begin();
		int colOffset = x > 0 ? -1 : 0;
		int rowOffset = y > 0 ? -1 : 0;
		for (int row = 0; row < numDrawY; row++) {
			for (int col = 0; col < numDrawX; col++) {
				sb.draw(image, x + (col + colOffset) * image.getRegionWidth(),
						y + (rowOffset + row) * image.getRegionHeight());
			}
		}
		sb.end();
	}
}
