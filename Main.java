
public class Main {
	public static final String TITLE = "Software Renderer";
	public static final int WIDTH = 720;
	public static final int HEIGHT = 640;

	private static Display display;
	private static Bitmap frameBuffer;
	private static Stars3D stars;
	
	public static void main(String[] args) {
		/* These should be static factory methods */
		display = new Display(WIDTH, HEIGHT, TITLE);
		frameBuffer = new Bitmap(WIDTH, HEIGHT);
		stars = new Stars3D(4096, 64.0f, 20.0f, 70.0f);

		/* Bad code smell calculating the time could be a function */
		long previousTime = System.nanoTime();
		while (true) {
			long currentTime = System.nanoTime();
			float delta = (float) ((currentTime - previousTime) / 1000000000.0);
			previousTime = currentTime;

			int width = frameBuffer.getWidth();
			int height = frameBuffer.getHeight();
			frameBuffer.clear(0xff000000);
			stars.updateAndRender(frameBuffer.getFrameBuffer(), width, height, delta);
			display.swapBuffers(frameBuffer.getFrameBuffer());
		}
	}
}
