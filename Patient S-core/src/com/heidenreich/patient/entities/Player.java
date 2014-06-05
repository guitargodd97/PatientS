package com.heidenreich.patient.entities;

import com.badlogic.gdx.math.Vector2;

public class Player extends Character {

	private int gainedEXP;

	// Creates a player
	public Player(Vector2 position) {
		super(position);
	}

	// Gameover trigger
	public void die() {
	}

	// Updates the player
	public void update(float dt) {
	}

	// Adds to the EXP gained during a level
	public void gainEXP(int gain) {
		gainedEXP += gain;
	}

	// Returns the EXP gained during a level
	public int getGainedEXP() {
		return gainedEXP;
	}
}
