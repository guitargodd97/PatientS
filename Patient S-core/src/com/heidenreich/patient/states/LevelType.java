package com.heidenreich.patient.states;

import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.GUIButton;
import com.heidenreich.patient.handlers.GameStateManager;

public class LevelType extends Menu {

	// Creates a LevelType state
	public LevelType(GameStateManager gsm) {
		super(gsm);
		setupButtons(4);
		background.setVector(-12, 0);
		title = PatientSGame.getAssets().getSprite("leveltypetitle");
		title.setPosition(400 - (title.getWidth() / 2), 480 - title.getHeight());
	}

	// Sets up the buttons
	protected void setupButtons(int number) {
		buttons = new GUIButton[number];

		// Back Button
		buttons[0] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"backbutton", 2), 745, 435);

		// Kill Level Button
		buttons[1] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"killbutton", 2), 400, 200);

		// Survival Level Button
		buttons[2] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"survivalbutton", 2), 140, 200);

		// Absorb Level Button
		buttons[3] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"absorbbutton", 2), 660, 200);
	}

	// Handles the input
	public void handleInput() {
		// Back Button
		if (buttons[0].isClicked())
			gsm.setState(GameStateManager.MAIN_MENU);

		// Kill Level Button
		if (buttons[1].isClicked())
			gsm.setState(GameStateManager.KILL_LEVEL);

		// Survival Level Button
		if (buttons[2].isClicked())
			gsm.setState(GameStateManager.SURVIVAL_LEVEL);

		// Absorb Level Button
		if (buttons[3].isClicked())
			gsm.setState(GameStateManager.ABSORB_LEVEL);
	}
}
