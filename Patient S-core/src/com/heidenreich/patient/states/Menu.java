package com.heidenreich.patient.states;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.Animation;
import com.heidenreich.patient.handlers.Background;
import com.heidenreich.patient.handlers.GUIButton;
import com.heidenreich.patient.handlers.GameStateManager;

public abstract class Menu extends GameState {

	protected Animation animation;
	protected Background background;
	protected GUIButton[] buttons;
	protected Music menuMusic;
	protected Sprite title;

	protected Menu(GameStateManager gsm) {
		super(gsm);
		background = new Background(PatientSGame.getAssets().getAnimatedSprite(
				"background0", 2));
	}

	protected abstract void setupButtons(int number);

	// Updates the menu
	public void update(float dt) {
		handleInput();
		background.update(dt);
		for (GUIButton gui : buttons)
			gui.update(dt);
	}

	// Renders the menu
	public void render() {
		background.render(batch);
		batch.begin();
		title.draw(batch);
		batch.end();
		for (GUIButton gui : buttons)
			gui.render(batch);
	}

	// Disposes of the resources
	public void dispose() {
	}
}
