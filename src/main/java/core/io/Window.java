package core.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import core.Game;

public class Window {
	
	private int width, height;
	private String title;
	private long window;
	
	public Window(int width, int height, String title) {
	
		this.width = width;
		this.height = height;
		this.title = title;
		
		create();
	}
	
	private void create() {
		if(!GLFW.glfwInit()) {
			System.err.println("ERROR: Could not initialize GLFW");
			GLFW.glfwTerminate();
			System.exit(-1);
		}
		
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		
		if (window == 0) {
			System.err.println("ERROR: Could not create window");
			GLFW.glfwTerminate();
			System.exit(-1);
		}
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
		
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		
		GLFW.glfwShowWindow(window);
	}
	
	public void update() {
		GLFW.glfwPollEvents();
		GLFW.glfwSwapBuffers(window);
	}
	
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public void terminate() {
		GLFW.glfwDestroyWindow(window);
		GLFW.glfwTerminate();
		
		if (Game.debug) System.out.println("Terminated window");
	}
}
