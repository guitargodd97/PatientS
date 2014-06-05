package com.heidenreich.patient.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.heidenreich.patient.PatientSGame;
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
	}

	public abstract void update(float dt);

	public void render(SpriteBatch batch) {
		batch.begin();
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
