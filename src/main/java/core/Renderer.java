package core;

import org.lwjgl.opengl.GL46;

public class Renderer {

	public void draw(Model model) {
		GL46.glClearColor(1, 0, 0, 1);
		GL46.glClear(GL46.GL_COLOR_BUFFER_BIT);

		GL46.glBindVertexArray(model.getVaoID()); // Bind to the vao we want
		GL46.glEnableVertexAttribArray(0); // Enable the vbo we want
		GL46.glDrawArrays(GL46.GL_TRIANGLES, 0, model.getVertexCount()); // Draw the array
		GL46.glDisableVertexAttribArray(0); // Disable VBO
		GL46.glBindVertexArray(0); // Disable VAO
	}
}
