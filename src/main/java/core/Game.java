package core;

public class Game {
	
	public static boolean debug = false;
	public static final GameVersion VERSION = new GameVersion("0.0.1");
	public static final int WIDTH = 1200, HEIGHT = 720;
	public static final String TITLE = "Game";
	
	Thread game = new Thread();
	
	
	public static void main(String[] args) {
		// Parse the command line arguments.
		Initializer.parseArgs(args);
		
		// Starts the window
		Initializer.init();
		
		// Run the game. This start the game loop
		MainGameLoop.loop();
		
		// Terminates the window after it is done.
		MainGameLoop.window.terminate();
	}
}
