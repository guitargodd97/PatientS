package com.heidenreich.patient.states;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.heidenreich.patient.handlers.Animation;
import com.heidenreich.patient.handlers.GameStateManager;

public abstract class Menu extends GameState{
	
	protected Animation animation;
	protected Background background;
	protected ImageButton[] buttons;
	protected Music menuMusic;
	
	protected Menu(GameStateManager gsm) {
		super(gsm);
	}

}
