package com.heidenreich.patient.states;

import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.handlers.GUIButton;
import com.heidenreich.patient.handlers.GameStateManager;

public class LevelSelect extends Menu {

	private GUIButton[] nums;

	// Creates a new LevelSelect
	public LevelSelect(GameStateManager gsm) {
		super(gsm);
		setupButtons(11);
		background.setVector(-12, 22);
		title = PatientSGame.getAssets().getSprite("selecttitle");
		title.setPosition(400 - (title.getWidth() / 2), 480 - title.getHeight());
	}

	// Sets up the buttons
	protected void setupButtons(int number) {
		buttons = new GUIButton[number];
		nums = new GUIButton[9];

		// Back Button
		buttons[0] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"backbutton", 2), 745, 435);

		// Level 1-9 Buttons
		for (int i = 0; i < 9; i++)
			buttons[i + 1] = new GUIButton(PatientSGame.getAssets()
					.getAnimatedSprite("levelbutton", 2), ((i % 3) + 1) * 200,
					350 - (100 * (int) (i / 3)));

		// Level 1-9 Numbers
		for (int i = 0; i < 9; i++)
			nums[i] = new GUIButton(PatientSGame.getAssets().getSprite(
					"" + (i + 1)), ((i % 3) + 1) * 200,
					350 - (100 * (int) (i / 3)));

		// Final Boss Button
		buttons[10] = new GUIButton(PatientSGame.getAssets().getAnimatedSprite(
				"finalbossbutton", 2), 400, 50);
	}

	//Renders the state
	public void render() {
		super.render();
		for(GUIButton guiNum : nums)
			guiNum.render(batch);
	}
	
	public void handleInput() {
	}

}
