package com.heidenreich.patient.handlers;

public class PatientInput {

	public static boolean down;
	public static boolean pdown;
	public static int x;
	public static int y;

	// Updates the input
	public static void update() {
		pdown = down;
	}

	// If input is down
	public static boolean isDown() {
		return down;
	}

	// If input is pressed
	public static boolean isPressed() {
		return down && !pdown;
	}

	// If input is released
	public static boolean isReleased() {
		return !down && pdown;
	}
}
