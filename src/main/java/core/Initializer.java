package core;

import static core.Game.GAMETHREAD;

public class Initializer {

	public static void parseArgs(String[] args) {
		for (String arg : args) {
			switch (arg) {
				case "-debug":
					Game.debug = true;
					break;
			}
		}
		
		if (Game.debug) System.out.println("Parsed arguments");
	}

	public static void init() {
		if (Game.debug) System.out.println("Initializing");
		
		// Init time
		Time.init();

		GAMETHREAD.setName("Game Thread");
	}
}
