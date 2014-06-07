package com.heidenreich.patient.states;

import com.badlogic.gdx.Gdx;
import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.GUIButton;
import com.heidenreich.patient.handlers.GameStateManager;

public class MainMenu extends Menu {

	// Creates the MainMenu
	public MainMenu(GameStateManager gsm) {
		super(gsm);
		setupButtons(5);
		background.setVector(10, 0);
		title = PatientSGame.getAssets().getSprite("title");
		title.setPosition(400 - (title.getWidth() / 2), 480 - title.getHeight());
	}

	// Handles the input
	public void handleInput() {
		// Start Button
		if (buttons[0].isClicked())
			gsm.setState(GameStateManager.LEVEL_TYPE);

		// Lab Button
		if (buttons[1].isClicked())
			gsm.setState(GameStateManager.LAB);

		// Quit Button
		if (buttons[2].isClicked())
			Gdx.app.exit();

		// Options Button
		if (buttons[3].isClicked())
			gsm.setState(GameStateManager.OPTIONS);

		// Stats Button
		if (buttons[4].isClicked())
			gsm.setState(GameStateManager.STATS);
	}

	// Sets up the buttons
	protected void setupButtons(int number) {
		buttons = new GUIButton[number];

		// Start Button
		buttons[0] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"startbutton", 2), 150, 275);

		// Lab Button
		buttons[1] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"labbutton", 2), 550, 250);

		// Quit Button
		buttons[2] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"quitbutton", 2), 400, 45);

		// Options Button
		buttons[3] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"optionsbutton", 2), 745, 55);

		// Stats Button
		buttons[4] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"statsbutton", 2), 55, 55);
	}

}
