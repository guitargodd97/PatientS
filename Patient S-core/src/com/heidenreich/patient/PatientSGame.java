package com.heidenreich.patient;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.heidenreich.patient.handlers.Assets;
import com.heidenreich.patient.handlers.BoundedCamera;
import com.heidenreich.patient.handlers.GameStateManager;
import com.heidenreich.patient.handlers.PatientInput;
import com.heidenreich.patient.handlers.PatientInputProcessor;
import com.heidenreich.patient.handlers.PlayerStats;

public class PatientSGame implements ApplicationListener {

	public static final int HEIGHT = 480;
	public static final int WIDTH = 800;
	public static final String TITLE = "PatientS";
	public static final String VER = "Alpah 1.0";

	public static Assets ASSETS;
	public static PlayerStats PLAYER_STATS;

	private BoundedCamera cam;
	private GameStateManager gsm;
	private OrthographicCamera hud;
	private SpriteBatch batch;

	// Creates the game
	public void create() {
		// Names the game
		Gdx.graphics.setTitle(PatientSGame.getLog());

		// Sets the InputProcessor to the custom input
		Gdx.input.setInputProcessor(new PatientInputProcessor());

		// Loads the assets
		loadResources();

		// Loads the PlayerStats
		loadPlayerStats();

		// Sets up the SpriteBatch
		batch = new SpriteBatch();

		// Sets up the camera
		cam = new BoundedCamera();
		cam.setToOrtho(false, PatientSGame.WIDTH, PatientSGame.HEIGHT);
		hud = new OrthographicCamera();
		hud.setToOrtho(false, PatientSGame.WIDTH, PatientSGame.HEIGHT);

		// Creates a new GameStateManager
		gsm = new GameStateManager(this);
	}

	// Renders and updates the game
	public void render() {
		//Debug title
		Gdx.graphics.setTitle(PatientSGame.getLog() + " -- FPS: "
				+ Gdx.graphics.getFramesPerSecond());

		// Update and render the GameStateManager
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();

		// Update input
		PatientInput.update();
	}

	// Disposes of assets
	public void dispose() {
		savePlayerStats();
		disposeResources();
	}

	// Called when the game is resized
	public void resize(int width, int height) {
	}

	// Called when the screen is minimized
	public void pause() {
	}

	// Called when the screen is unminimized
	public void resume() {
	}

	// Loads the resources
	private void loadResources() {
		ASSETS = new Assets();
		PatientSGame.getAssets().loadAll();
	}

	// Disposes of the resources
	private void disposeResources() {
		PatientSGame.getAssets().disposeAll();
	}

	// Returns the Assets
	public static Assets getAssets() {
		return ASSETS;
	}

	// Returns the GameStateManager
	public GameStateManager getGameStateManager() {
		return gsm;
	}

	// Returns the HUDCamera
	public OrthographicCamera getHUDCam() {
		return hud;
	}

	// Returns the camera
	public BoundedCamera getCam() {
		return cam;
	}

	// Returns the SpriteBatch
	public SpriteBatch getSpriteBatch() {
		return batch;
	}

	// Returns the version
	public static String getVersion() {
		return VER;
	}

	// Returns the title
	public static String getTitle() {
		return TITLE;
	}

	// Returns the log
	public static String getLog() {
		return PatientSGame.getTitle() + " " + PatientSGame.getVersion();
	}

	// Loads the PlayerStats
	private void loadPlayerStats() {
		PatientSGame.PLAYER_STATS = new PlayerStats();
		PatientSGame.getPlayerStats().loadData();
	}

	// Saves the PlayerStats
	private void savePlayerStats() {
		PatientSGame.getPlayerStats().saveData();
	}

	// Returns the PlayerStats
	public static PlayerStats getPlayerStats() {
		return PLAYER_STATS;
	}
}
