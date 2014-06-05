package com.heidenreich.patient.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.heidenreich.patient.handlers.Animation;

public abstract class Entity {
	protected Animation animation;
	protected float height;
	protected float width;
	protected Vector2 position;

	public Entity(Vector2 position) {
		this.position = position;
	}

	public void setAnimation(Sprite[] frames, float delay) {
		animation.setFrames(frames, delay);
		width = frames[0].getWidth();
		height = frames[0].getHeight();
	}

	public abstract void update(float dt);

	public void render(SpriteBatch batch) {
		batch.begin();
		animation.setLocation(new Vector2(position.x - width, position.y
				- height));
		animation.getFrame().draw(batch);
		batch.end();
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
}
