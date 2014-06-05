package com.heidenreich.patient.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class PlayerStats {

	public static int ATK;
	public static int ATK_LEVEL;
	public static int EXP_TO_NEXT;
	public static int HP;
	public static int HP_LEVEL;
	public static int LEVEL;
	public static int UPGRADE_POINTS;
	public static String CUR_BEAM;
	public static String CUR_BRAIN;
	public static String NAME;

	// Create PlayerStats
	public PlayerStats() {
		// Assigns all variables with default values
		ATK = 1;
		ATK_LEVEL = 1;
		EXP_TO_NEXT = 50;
		HP = 3;
		HP_LEVEL = 1;
		LEVEL = 1;
		UPGRADE_POINTS = 0;
		CUR_BEAM = "base";
		CUR_BRAIN = "base";
		NAME = "default";
	}

	// Loads all the saved data
	public void loadData() {
		// Grabs file
		FileHandle fileLocation = Gdx.files.local("data/playerstats.txt");

		// Write a new file if none exists
		if (!fileLocation.exists()) {
			String s = ATK + "|" + ATK_LEVEL + "|" + EXP_TO_NEXT + "|" + HP
					+ "|" + HP_LEVEL + "|" + LEVEL + "|" + UPGRADE_POINTS + "|"
					+ CUR_BEAM + "|" + CUR_BRAIN + "|" + NAME + "|";
			fileLocation.writeString(s, false);
		}

		// Slice up the file data into compatible types
		String data = fileLocation.readString();
		ATK = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		ATK_LEVEL = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		EXP_TO_NEXT = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		HP = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		HP_LEVEL = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		LEVEL = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		UPGRADE_POINTS = Integer.parseInt(data.substring(0, data.indexOf("|")));
		data = data.substring(data.indexOf("|") + 1);
		CUR_BEAM = data.substring(0, data.indexOf("|"));
		data = data.substring(data.indexOf("|") + 1);
		CUR_BRAIN = data.substring(0, data.indexOf("|"));
		data = data.substring(data.indexOf("|") + 1);
		NAME = data.substring(0, data.indexOf("|"));
	}

	// Saves the data
	public void saveData() {
		FileHandle fileLocation = Gdx.files.local("data/playerstats.txt");
		String s = ATK + "|" + ATK_LEVEL + "|" + EXP_TO_NEXT + "|" + HP + "|"
				+ HP_LEVEL + "|" + LEVEL + "|" + UPGRADE_POINTS + "|"
				+ CUR_BEAM + "|" + CUR_BRAIN + "|" + NAME + "|";
		fileLocation.writeString(s, false);
	}

	// Calculates an ATK upgrade
	public void calculateNewATK() {
		ATK_LEVEL++;
		ATK += (int) (ATK_LEVEL * 1.25);
		saveData();
	}

	// Calculates an HP upgrade
	public void calculateNewHP() {
		HP_LEVEL++;
		HP += (int) (HP_LEVEL * 1.2);
		saveData();
	}

	// Changes the player's name
	public void setName(String name) {
		NAME = name;
		saveData();
	}

	// Changes player's brain type
	public void setBRAIN(String brain) {
		CUR_BRAIN = brain;
		saveData();
	}

	// Changes player's beam type
	public void setBEAM(String beam) {
		CUR_BEAM = beam;
		saveData();
	}

	// Levels up a player
	public void levelUp() {
		LEVEL++;
		EXP_TO_NEXT = (int) (50 * 1.25 * LEVEL);
		UPGRADE_POINTS += (int) (LEVEL * 1.15);
		saveData();
	}

	// Subtracts UPGRADE_POINTS
	public void spendPoints(int spent) {
		UPGRADE_POINTS -= spent;
	}
}
