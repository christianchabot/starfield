import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Display extends Canvas {
	
	private final BufferedImage displayImage;
	private final BufferStrategy bufferStrategy;
	private final Graphics graphics;
	private final JFrame frame;
	private final int[] displayComponents;
	private final int width, height;

	public Display(int width, int height, String title) {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		this.width = width;
		this.height = height;
		displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		displayComponents = 
			((DataBufferInt) displayImage.getRaster().getDataBuffer()).getData();

		frame = new JFrame();
		frame.add(this);
		frame.setSize(size);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		frame.setVisible(true);

		createBufferStrategy(1);
		bufferStrategy = getBufferStrategy();
		graphics = bufferStrategy.getDrawGraphics();
	}

	public int[] getFrameBuffer() {
		return displayComponents;
	}

	public void swapBuffers() {
		graphics.drawImage(displayImage, 0, 0, this.width, this.height, null);
		bufferStrategy.show();
	}
}
