
public class Matrix4f {
	private static final int WIDTH = 4;
	private static final int HEIGHT = 4;
	
	private float[] entries;

	public Matrix4f() {
		entries = new float[WIDTH*HEIGHT];
	}

	public Matrix4f getIdentity() {
		for (int j = 0; j < HEIGHT; j++) {
			for (int i = 0; i < WIDTH; i++) {
				if (i-j == 0)
					entries[i + j*WIDTH] = 1;
				else
					entries[i + j*WIDTH] = 0;
			}
		}

		return this;
	}

	public Matrix4f getTranslation(float x, float y, float z) {
		getIdentity();
		entries[3] = x;
		entries[7] = y;
		entries[11] = z;

		return this;
	}
}
