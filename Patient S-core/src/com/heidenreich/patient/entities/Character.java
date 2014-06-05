package com.heidenreich.patient.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public abstract class Character extends Entity {

	protected boolean alive;
	protected float healthScale;
	protected int attack;
	protected int health;
	protected int totalHealth;
	protected Sprite healthImg;

	// Creates a new Character
	public Character(Vector2 position) {
		super(position);
		alive = true;
		healthScale = 1f;
	}

	// Returns the attack
	public int getAttack() {
		return attack;
	}

	// Subtracts health
	public void loseHealth(int damage) {
		health -= damage;
		updateHealthBar();
	}

	// Returns if the character is alive
	public boolean getAlive() {
		return alive;
	}

	// Abstract death method
	public abstract void die();

	// Method to update the health bar size
	protected void updateHealthBar() {
		healthScale = (float) (health / totalHealth);
		healthImg.setScale(healthScale, 1);
	}
}
