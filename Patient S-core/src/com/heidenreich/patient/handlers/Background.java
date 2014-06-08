package com.heidenreich.patient.handlers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

	private Animation animation;
	private Sprite[] image;

	// Creates new background
	public Background(Sprite image[]) {
		this.image = image;
		for (int i = 0; i < this.image.length; i++)
			this.image[i].setPosition(0, 0);
		animation = new Animation(this.image, 1 / 6f);
	}

	// Updates the background
	public void update(float dt) {
		animation.update(dt);
	}

	// Renders the background
	public void render(SpriteBatch batch) {
		// Draws the background
		batch.begin();
		animation.getFrame().draw(batch);
		batch.end();
	}
}
