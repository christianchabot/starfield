
public class Main {
	public static final String TITLE = "Software Renderer";

	public static final int WIDTH = 720;
	public static final int HEIGHT = 640;
	
	public static void main(String[] args) {
		Display display = new Display(WIDTH, HEIGHT, TITLE);

		RenderContext target = display.getFrameBuffer();
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f, 70.0f);

		Vertex minY = new Vertex(100, 100);
		Vertex midY = new Vertex(150, 200);
		Vertex maxY = new Vertex(80, 300);

		long previousTime = System.nanoTime();
		while (true) {
			long currentTime = System.nanoTime();
			float delta = (float) ((currentTime - previousTime) / 1000000000.0);
			previousTime = currentTime;

			target.clear(0xff000000);
			stars.updateAndRender(target, delta);

			//target.fillTriangle(minY, midY, maxY);
			display.swapBuffers();
		}
	}
}
