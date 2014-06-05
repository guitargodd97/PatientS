package com.heidenreich.patient.handlers;

import java.util.Stack;

import com.heidenreich.patient.PatientSGame;
import com.heidenreich.patient.states.AbsorbLevel;
import com.heidenreich.patient.states.Achievements;
import com.heidenreich.patient.states.GameState;
import com.heidenreich.patient.states.Gameover;
import com.heidenreich.patient.states.KillLevel;
import com.heidenreich.patient.states.Lab;
import com.heidenreich.patient.states.LevelSelect;
import com.heidenreich.patient.states.LevelType;
import com.heidenreich.patient.states.MainMenu;
import com.heidenreich.patient.states.Options;
import com.heidenreich.patient.states.Pause;
import com.heidenreich.patient.states.Stats;
import com.heidenreich.patient.states.SurvivalLevel;
import com.heidenreich.patient.states.Victory;

public class GameStateManager {

	private PatientSGame game;
	private Stack<GameState> gameStates;

	public static final int ABSORB_LEVEL = 322353;
	public static final int ACHIEVEMENTS = 3266274;
	public static final int GAMEOVER = 949949;
	public static final int KILL_LEVEL = 43662346;
	public static final int LAB = 123214;
	public static final int LEVEL_SELECT = 38941353;
	public static final int LEVEL_TYPE = 52906823;
	public static final int MAIN_MENU = 99939203;
	public static final int OPTIONS = -34223;
	public static final int PAUSE = -1511536;
	public static final int STATS = 3287963;
	public static final int SURVIVAL_LEVEL = -5378923;
	public static final int VICTORY = -195708;

	// Creates a new GameStateManager
	public GameStateManager(PatientSGame game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(MAIN_MENU);
	}

	// Updates the manager
	public void update(float dt) {
		gameStates.peek().update(dt);
	}

	// Renders the manager
	public void render() {
		gameStates.peek().render();
	}

	// Gets the PatientSGame
	public PatientSGame getGame() {
		return game;
	}

	// Gets a state
	private GameState getState(int state) {
		if (state == ABSORB_LEVEL)
			return new AbsorbLevel(this);
		if (state == ACHIEVEMENTS)
			return new Achievements(this);
		if (state == GAMEOVER)
			return new Gameover(this);
		if (state == KILL_LEVEL)
			return new KillLevel(this);
		if (state == LAB)
			return new Lab(this);
		if (state == LEVEL_SELECT)
			return new LevelSelect(this);
		if (state == LEVEL_TYPE)
			return new LevelType(this);
		if (state == MAIN_MENU)
			return new MainMenu(this);
		if (state == OPTIONS)
			return new Options(this);
		if (state == PAUSE)
			return new Pause(this);
		if (state == STATS)
			return new Stats(this);
		if (state == SURVIVAL_LEVEL)
			return new SurvivalLevel(this);
		if (state == VICTORY)
			return new Victory(this);
		return null;
	}

	//Sets the state
	public void setState(int state) {
		popState();
		pushState(state);
	}

	//Pushes the state on top of the stack
	public void pushState(int state) {
		gameStates.push(getState(state));
	}

	//Pops the state off the stack and disposes of it
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}
}
