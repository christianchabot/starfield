import java.util.Arrays;

public class Bitmap {
	private final int width;
	private final int height;
	private final int[] pixels;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public int[] getFrameBuffer() {
		return pixels;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void clear(int color) {
		for (int i = 0; i < width*height; i++)
			pixels[i] = color;
	}

	public void drawPixel(int x, int y, byte a, byte r, byte g, byte b) {
		int color = (int) (a << 24) | (int) (r << 16) | (int) (g << 8) | (int) b;
		pixels[x + y*width] = color;
	}
}
