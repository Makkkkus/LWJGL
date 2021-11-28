package core;

import core.io.Window;

public class MainGameLoop implements Runnable {
	private static Window window;

	public float[] vertices = {
			-0.5f, 0.5f, 0f,
			-0.5f, -0.5f, 0f,
			0.5f, -0.5f, 0f,
			0.5f, -0.5f, 0f,
			0.5f, 0.5f, 0f,
			-0.5f, 0.5f, 0f
	};

	public void run() {
		//Logger.debug("Started loop");

		// Create a window
		window = new Window(Game.WIDTH, Game.HEIGHT, Game.TITLE);
		window.create();

		Renderer renderer = new Renderer(); // Create renderer
		Loader loader = new Loader(); // Create loader

		while (!window.shouldClose()) {

			renderer.draw(loader.loadToVAO(vertices));

			// Keep the window updated
			window.update();
		}

		loader.cleanup();

		// Terminates the window after it is done.
		window.terminate();
	}
}
