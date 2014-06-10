package com.heidenreich.patient.states;

import com.heidenreich.patient.handlers.GameStateManager;

public class KillLevel extends Play {

	public KillLevel(GameStateManager gsm, int level) {
		super(gsm, level);
	}

	@Override
	protected boolean checkMission() {
		return false;
	}

	@Override
	public void handleInput() {
	}

}
