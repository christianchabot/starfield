
public class RenderContext extends Bitmap {
	private final int[] scanBuffer;

	public RenderContext(int width, int height) {
		super(width, height);
		scanBuffer = new int[height * 2];
	}


	public void drawScanBuffer(int yCoord, int xMin, int xMax) {
		scanBuffer[yCoord * 2] = xMin;
		scanBuffer[yCoord * 2 + 1] = xMax;
	}

	public void fillShape(int yMin, int yMax) {
		for (int j = yMin; j < yMax; j++) {
			int xMin = scanBuffer[j * 2];
			int xMax = scanBuffer[j * 2 + 1];

			for (int i = xMin; i < xMax; i++)
				drawPixel(i, j, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff);
		}
	}
}
