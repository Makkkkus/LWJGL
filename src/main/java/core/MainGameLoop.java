package core;

import core.io.Window;

public class MainGameLoop {
	static Window window;
	
	public static void loop() {
		if (Game.debug) System.out.println("Started loop");
		
		while (!window.shouldClose()) {
			
			
			// Keep the window updated
			window.update();
		}
	}
}
