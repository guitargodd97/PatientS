package com.heidenreich.patient.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.Animation;
import com.heidenreich.patient.handlers.PlayerStats;

public class Player extends Character {

	private Animation animation;
	private int gainedEXP;

	// Creates a player
	public Player(Vector2 position) {
		super(position);
		PatientSGame.getPlayerStats();
		Sprite[] s = PatientSGame.getAssets().getAnimatedSprite(
				"player-" + PlayerStats.CUR_BRAIN, 4);
		for (Sprite sprite : s)
			sprite.setPosition(position.x - (sprite.getWidth() / 2), position.y
					- (sprite.getHeight() / 2));
		animation = new Animation(s);
	}

	// Gameover trigger
	public void die() {
	}

	// Updates the player
	public void update(float dt) {
		animation.update(dt);
	}

	// Adds to the EXP gained during a level
	public void gainEXP(int gain) {
		gainedEXP += gain;
	}

	public void render(SpriteBatch batch) {
		batch.begin();
		animation.getFrame().draw(batch);
		batch.end();
	}

	// Returns the EXP gained during a level
	public int getGainedEXP() {
		return gainedEXP;
	}
}
