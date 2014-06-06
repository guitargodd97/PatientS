package com.heidenreich.patient.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class PatientInputProcessor extends InputAdapter {

	// Saves mouse movement
	public boolean mouseMoved(int x, int y) {
		PatientInput.x = x;
		PatientInput.y = Gdx.graphics.getHeight() - y;
		return true;
	}

	// Saves a dragged touch
	public boolean touchDragged(int x, int y, int pointer) {
		PatientInput.x = x;
		PatientInput.y = Gdx.graphics.getHeight() - y;
		PatientInput.down = true;
		return true;
	}

	// Saves a touch
	public boolean touchDown(int x, int y, int pointer, int button) {
		PatientInput.x = x;
		PatientInput.y = Gdx.graphics.getHeight() - y;
		PatientInput.down = true;
		return true;
	}

	// Saves a released touch
	public boolean touchUp(int x, int y, int pointer, int button) {
		PatientInput.x = x;
		PatientInput.y = Gdx.graphics.getHeight() - y;
		PatientInput.down = false;
		return true;
	}
}
