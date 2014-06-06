package com.heidenreich.patient.handlers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GUIButton {

	private boolean clicked;
	private float height;
	private float width;
	private float x;
	private float y;
	private Sprite[] buttons;

	// Creates a new GUIButton
	public GUIButton(Sprite[] buttons, float x, float y) {
		this.buttons = buttons;
		this.x = x;
		this.y = y;
		this.width = buttons[0].getWidth();
		this.height = buttons[0].getHeight();
		clicked = false;

		for (int i = 0; i < this.buttons.length; i++)
			this.buttons[i].setPosition(this.x
					- (this.buttons[i].getWidth() / 2), this.y
					- (this.buttons[i].getHeight() / 2));
	}

	// Updates the button
	public void update(float dt) {
		if (PatientInput.isPressed() && PatientInput.x > x - width / 2
				&& PatientInput.x < x + width / 2
				&& PatientInput.y > y - height / 2
				&& PatientInput.y < y + height / 2) {
			clicked = true;
		} else {
			clicked = false;
		}
	}

	// Renders the button
	public void render(SpriteBatch batch) {
		batch.begin();
		if (clicked)
			buttons[1].draw(batch);
		else
			buttons[0].draw(batch);
		batch.end();
	}

	// Returns if the button is clicked
	public boolean isClicked() {
		return clicked;
	}
}
