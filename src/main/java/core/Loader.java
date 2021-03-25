package core;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL46;

import java.nio.FloatBuffer;
import java.util.ArrayList;

public class Loader {

	private final ArrayList<Integer> VAOS = new ArrayList<Integer>();
	private final ArrayList<Integer> VBOS = new ArrayList<Integer>();

	/**
	 * Load data to a VAO.
	 * @param positions The position of each vertex.
	 * @return The model.
	 */
	public Model loadToVAO(float[] positions) {
		int vaoID = createVAO();

		storeDataInAttributeList(0, positions);
		unbindVAO();

		return new Model(vaoID, positions.length/3);
	}

	/**
	 * Deletes all the VAOS and VBOS in memory.
	 */
	public void cleanup() {
		for (int vao : VAOS) {
			GL46.glDeleteVertexArrays(vao);
		}

		for (int vbo : VBOS) {
			GL46.glDeleteBuffers(vbo);
		}
	}

	/**
	 * Create a VAO to store data in.
	 * @return The VAO
	 */
	private int createVAO() {
		int vaoID = GL46.glGenVertexArrays();
		GL46.glBindVertexArray(vaoID);
		VAOS.add(vaoID);

		return vaoID;
	}

	/**
	 * Creates a VBO and stores it in the VAO.
	 * @param num Index in the VAO
	 * @param data The data to store.
	 */
	private void storeDataInAttributeList(int num, float[] data) {
		int vboID = GL46.glGenBuffers();
		GL46.glBindBuffer(GL46.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInBuffer(data);

		GL46.glBufferData(GL46.GL_ARRAY_BUFFER, buffer, GL46.GL_STATIC_DRAW);
		GL46.glVertexAttribPointer(num, 3, GL46.GL_FLOAT, false, 0, 0);
		GL46.glBindBuffer(GL46.GL_ARRAY_BUFFER, 0);
	}

	/**
	 * Unbind from the VAO; Stop making changes to this VAO.
	 */
	private void unbindVAO() {
		GL46.glBindVertexArray(0);
	}

	/**
	 * Store data in a FloatBuffer so we can put in a VBO.
	 * @param data Data to store
	 * @return The float buffer
	 */
	private FloatBuffer storeDataInBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();

		return buffer;
	}

}
