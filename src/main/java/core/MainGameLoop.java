package core;

import core.io.Window;

public class MainGameLoop {
	static Window window;
	
	public static void loop() {
		while (!window.shouldClose()) {
			window.update();
			window.swapBuffers();
		}
	}
}
