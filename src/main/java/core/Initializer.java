package core;

import core.io.Window;

public class Initializer {
	
	public static void parseArgs(String[] args) {
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "-debug":
				Game.debug = true;
				break;

			default:
				break;
			}
		}
	}
	
	public static void init() {
		if (Game.debug) System.out.println("Initializing");
		
		// Create a window
		MainGameLoop.window = new Window(Game.WIDTH, Game.HEIGHT, Game.TITILE);
		MainGameLoop.window.create();
	}
}
