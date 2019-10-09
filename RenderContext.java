
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

	public void fillTriangle(Vertex v1, Vertex v2, Vertex v3) {
		Vertex minY = v1;
		Vertex midY = v2;
		Vertex maxY = v3;

		if (maxY.getY() < midY.getY()) {
			Vertex temp = maxY;
			maxY = midY;
			midY = temp;
		}

		if (midY.getY() < minY.getY()) {
			Vertex temp = midY;
			midY = minY;
			minY = temp;
		}

		if (maxY.getY() < midY.getY()) {
			Vertex temp = maxY;
			maxY = midY;
			midY = temp;
		}

		float area = minY.triangleArea(maxY, midY);
		int handedness = area >= 0 ? 1 : 0;

		scanConvertTriangle(minY, midY, maxY, handedness);
		fillShape((int)minY.getY(), (int)maxY.getY());
	}

	public void scanConvertTriangle(Vertex minY, Vertex midY, Vertex maxY, int handedness) {
		scanConvertLine(minY, maxY, 0 + handedness);
		scanConvertLine(minY, midY, 1 - handedness);
		scanConvertLine(midY, maxY, 1 - handedness);
	}

	private void scanConvertLine(Vertex minY, Vertex maxY, int whichSide) {
		int yStart = (int) minY.getY();
		int yEnd = (int) maxY.getY();
		int xStart = (int) minY.getX();
		int xEnd = (int) maxY.getX();

		int yDist = yEnd - yStart;
		int xDist = xEnd - xStart;

		if (yDist <= 0) return;

		float xStep = (float) xDist / yDist;
		float curX = (float) xStart;

		for (int j = yStart; j < yEnd; j++) {
			scanBuffer[j * 2 + whichSide] = (int)curX;
			curX += xStep;
		}
	}
}
