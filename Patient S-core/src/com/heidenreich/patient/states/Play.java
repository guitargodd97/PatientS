package com.heidenreich.patient.states;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.entities.Enemy;
import com.heidenreich.patient.entities.Player;
import com.heidenreich.patient.entities.Powerup;
import com.heidenreich.patient.handlers.Animation;
import com.heidenreich.patient.handlers.Background;
import com.heidenreich.patient.handlers.GameStateManager;

public abstract class Play extends GameState {

	protected Animation animation;
	protected Array<Enemy> enemies;
	protected Array<Powerup> powers;
	protected Background background;
	protected ImageButton[] buttons;
	protected int level;
	protected Label mission;
	protected Music gameMusic;
	protected Player player;

	protected Play(GameStateManager gsm, int level) {
		super(gsm);
		this.level = level;
		background = new Background(PatientSGame.getAssets().getAnimatedSprite(
				"background0", 2));
		player = new Player(new Vector2(400, 240));
	}

	protected abstract boolean checkMission();

	public void render() {
		background.render(batch);
		player.render(batch);
	}

	// Updates the menu
	public void update(float dt) {
		background.update(dt);
		player.update(dt);
	}

	public void dispose() {

	}
}
