package core;

import core.io.Window;

public class Initializer {

	public static void parseArgs(String[] args) {
		for (String arg : args) {
			switch (arg) {
			case "-debug":
				Game.debug = true;
				break;

			default:
				break;
			}
		}
		
		if (Game.debug) System.out.println("Parsed arguments");
	}

	public static void init() {
		if (Game.debug) System.out.println("Initializing");
		
		// Init time
		Time.init();

		// Create a window
		MainGameLoop.window = new Window(Game.WIDTH, Game.HEIGHT, Game.TITLE);
		
	}
}
