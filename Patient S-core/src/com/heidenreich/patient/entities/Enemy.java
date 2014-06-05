package com.heidenreich.patient.entities;

import com.badlogic.gdx.math.Vector2;
import com.heidenreich.patient.PatientSGame;

public abstract class Enemy extends Character {

	protected boolean dead;
	protected int exp;
	protected Player player;
	protected String name;
	protected Vector2 velocity;

	// Creates a new enemy
	public Enemy(Vector2 position, Player player, String name) {
		super(position);
		this.player = player;
		this.name = name;
		dead = false;
	}

	// Calculates the velocity
	protected void calculateVelocity() {

	}

	// Triggers the death animation
	public void die() {
		dead = true;
		animation.setFrames(PatientSGame.getAssets().getAnimatedSprite(
				name + "-dead", 5));
	}

	// Updates the enemy
	public void update(float dt) {
		if (health <= 0)
			alive = false;
		if (dead) {
			if (animation.hasPlayedOnce())
				turnOff();
		} else if (!alive)
			die();
	}

	// Return the exp
	public int getEXP() {
		return exp;
	}

	// Puts the enemy to sleep
	protected void turnOff() {
		alive = false;
		dead = false;
		velocity = new Vector2(0, 0);
		position = new Vector2(-1000, -100);
	}
}
