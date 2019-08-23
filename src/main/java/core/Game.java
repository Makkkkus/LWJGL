package core;

public class Game {
	
	public static boolean debug = false;
	public static final Version VERSION = new Version("0.0.1");
	public static final int WIDTH = 1200, HEIGHT = 720;
	public static final String TITILE = "Game";

	public static void main(String[] args) {
		// Parse the command line arguments.
		Initializer.parseArgs(args);
		
		// Starts the window
		Initializer.init();
		
		// Run the game. This start the game loop
		MainGameLoop.loop();
	}
}
