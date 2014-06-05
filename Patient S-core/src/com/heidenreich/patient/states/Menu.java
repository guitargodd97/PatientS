package com.heidenreich.patient.states;

import com.badlogic.gdx.audio.Music;
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
	}

	protected abstract void setupButtons(int number);

}
