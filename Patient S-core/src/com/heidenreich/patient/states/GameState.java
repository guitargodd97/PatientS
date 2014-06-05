package com.heidenreich.patient.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.BoundedCamera;
import com.heidenreich.patient.handlers.GameStateManager;

public abstract class GameState {

	protected BoundedCamera cam;
	protected GameStateManager gsm;
	protected OrthographicCamera hudCam;
	protected PatientSGame game;
	protected SpriteBatch batch;

	// Creates a new GameState
	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		game = gsm.getGame();
		cam = game.getCam();
		hudCam = game.getHUDCam();
		batch = game.getSpriteBatch();
	}

	// Handles Input for the state
	public abstract void handleInput();

	// Updates the state
	public abstract void update(float dt);

	// Renders the state
	public abstract void render();

	// Disposes of the state
	public abstract void dispose();
}
