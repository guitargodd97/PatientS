package com.heidenreich.patient.states;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.heidenreich.patient.handlers.Animation;
import com.heidenreich.patient.handlers.GameStateManager;

public abstract class Play extends GameState {

	protected Animation animation;
	protected Array<Enemy> enemies;
	protected Array<Powerup> powers;
	protected Background background;
	protected ImageButton[] buttons;
	protected int level;
	protected int type;
	protected Label mission;
	protected Music gameMusic;
	protected Player player;

	protected Play(GameStateManager gsm) {
		super(gsm);
	}

}
