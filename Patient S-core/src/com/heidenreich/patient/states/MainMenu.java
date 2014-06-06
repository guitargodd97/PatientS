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

	// Updates the menu
	public void update(float dt) {
		handleInput();

		background.update(dt);
		//animation.update(dt);

		//for (GUIButton gui : buttons)
		//	gui.update(dt);
		buttons[2].update(dt);
	}

	// Renders the menu
	public void render() {
		background.render(batch);
		for (GUIButton gui : buttons)
			gui.render(batch);
	}

	// Disposes of the resources
	public void dispose() {
	}

	// Sets up the buttons
	protected void setupButtons(int number) {
		buttons = new GUIButton[number];

		// Start Button
		buttons[0] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"startbutton", 2), 400, 380);

		// Lab Button
		buttons[1] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"labbutton", 2), 400, 300);

		// Quit Button
		buttons[2] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"quitbutton", 2), 400, 60);

		// Options Button
		buttons[3] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"optionsbutton", 2), 400, 220);

		// Stats Button
		buttons[4] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"statsbutton", 2), 400, 140);
	}

}
