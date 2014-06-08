package com.heidenreich.patient.states;

import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.GUIButton;
import com.heidenreich.patient.handlers.GameStateManager;

public class LevelType extends Menu {

	// Creates a LevelType state
	public LevelType(GameStateManager gsm) {
		super(gsm);
		setupButtons(5);
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

		// Unlimited Mode Button
		buttons[4] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"unlimitedbutton", 2), 400, 25);
	}

	// Handles the input
	public void handleInput() {
		// Back Button
		if (buttons[0].isClicked())
			gsm.setState(GameStateManager.MAIN_MENU);

		// Kill Level Button
		if (buttons[1].isClicked()) {
			GameStateManager.SAVED_TYPE = GameStateManager.KILL_LEVEL;
			gsm.setState(GameStateManager.LEVEL_SELECT);
		}

		// Survival Level Button
		if (buttons[2].isClicked()) {
			GameStateManager.SAVED_TYPE = GameStateManager.SURVIVAL_LEVEL;
			gsm.setState(GameStateManager.LEVEL_SELECT);
		}

		// Absorb Level Button
		if (buttons[3].isClicked()) {
			GameStateManager.SAVED_TYPE = GameStateManager.ABSORB_LEVEL;
			gsm.setState(GameStateManager.LEVEL_SELECT);
		}

		if (buttons[4].isClicked())
			gsm.setState(GameStateManager.UNLIMITED_LEVEL);
	}
}
