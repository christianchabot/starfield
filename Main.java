
public class Main {
	public static final String TITLE = "Software Renderer";

	public static final int WIDTH = 720;
	public static final int HEIGHT = 640;

	private static Display display;
	private static RenderContext frameBuffer;
	private static Stars3D stars;
	private static int[] image;
	
	public static void main(String[] args) {
		display = new Display(WIDTH, HEIGHT, TITLE);
		frameBuffer = new RenderContext(WIDTH, HEIGHT);
		stars = new Stars3D(4096, 64.0f, 20.0f, 70.0f);

		long previousTime = System.nanoTime();
		while (true) {
			long currentTime = System.nanoTime();
			float delta = (float) ((currentTime - previousTime) / 1000000000.0);
			previousTime = currentTime;

			frameBuffer.clear(0xff000000);
			stars.updateAndRender(frameBuffer, delta);

			display.swapBuffers(frameBuffer.getFrameBuffer(), frameBuffer.getWidth(), frameBuffer.getHeight());
		}
	}
}
