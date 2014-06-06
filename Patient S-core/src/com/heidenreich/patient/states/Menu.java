package com.heidenreich.patient.states;

import com.badlogic.gdx.audio.Music;
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

	protected Menu(GameStateManager gsm) {
		super(gsm);
		background = new Background(PatientSGame.getAssets().getSprite(
				"background0"), gsm.getGame().getCam());
	}

	protected abstract void setupButtons(int number);

}
