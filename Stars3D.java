
public class Stars3D {
	private final int numStars;
	private final float spread;
	private final float speed;
	private final float fieldOfView;
	private final float[] starX;
	private final float[] starY;
	private final float[] starZ;

	public Stars3D(int numStars, float spread, float speed, float angle) {
		if (numStars < 0 || spread < 0 || speed < 0 || angle < 0)
			throw new IllegalArgumentException();

		this.numStars = numStars;
		this.spread = spread;
		this.speed = speed;
		fieldOfView = (float) Math.tan(Math.toRadians(angle/2.0));

		starX = new float[numStars];
		starY = new float[numStars];
		starZ = new float[numStars];

		for (int i = 0; i < numStars; i++)
			initStar(i);
	}

	private void initStar(int index) {
		// Math.random() returns a number between -1 and 1.
		// So that is why you multiply then add half the 
		// width and height in updateAndRender();
		starX[index] = 2 * ((float) Math.random() - 0.5f) * spread;
		starY[index] = 2 *((float) Math.random() - 0.5f) * spread;
		starZ[index] = ((float) Math.random() + 0.00001f) * spread;
	}

	public void updateAndRender(int[] frameBuffer, int width, int height, float delta) {
		if (width*height != frameBuffer.length)
			throw new IllegalArgumentException();

		float halfWidth = width/2.0f;
		float halfHeight = height/2.0f;

		for (int i = 0; i < numStars; i++) {
			starZ[i] -= delta * speed;

			if (starZ[i] <= 0)
				initStar(i);

			// Adding half width and height brings the stars into the center screen.
			int x = (int) ((starX[i] / (starZ[i] * fieldOfView)) * halfWidth + halfWidth);
			int y = (int) ((starY[i] / (starZ[i] * fieldOfView)) * halfHeight + halfHeight);

			if (x < 0 || x >= width || y < 0 || y >= height)
				initStar(i);
			else
				frameBuffer[x + y*width] = 0xffffffff;
		}
	}
}
