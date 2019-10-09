import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Display extends Canvas {
	
	private final JFrame frame;
	private final RenderContext frameBuffer;
	private final BufferedImage displayImage;
	private final int[] displayComponents;
	private final BufferStrategy bufferStrategy;
	private final Graphics graphics;

	public Display(int width, int height, String title) {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		frameBuffer = new RenderContext(width, height);
		displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		displayComponents = 
			((DataBufferInt) displayImage.getRaster().getDataBuffer()).getData();

		frame = new JFrame();
		frame.add(this);
		frame.setSize(size);
		//frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		frame.setVisible(true);

		createBufferStrategy(1);
		bufferStrategy = getBufferStrategy();
		graphics = bufferStrategy.getDrawGraphics();
	}

	public RenderContext getFrameBuffer() {
		return (RenderContext) frameBuffer;
	}

	public void swapBuffers() {
		frameBuffer.copyToIntArray(displayComponents);
		graphics.drawImage(displayImage, 0, 0, frameBuffer.getWidth(),
			frameBuffer.getHeight(), null);
		bufferStrategy.show();
	}
}
