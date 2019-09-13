package core;

import org.lwjgl.glfw.GLFW;

public class Time {
	
	private static double lastLoopTime;
	
	public static double getTime() {
		return GLFW.glfwGetTime();
	}
	
	public static void init() {
		lastLoopTime = getTime();
	}
	
	public static float deltaTime() {
	    double time = getTime();
	    float delta = (float) (time - lastLoopTime);
	    lastLoopTime = time;
	    return delta;
	}
}
