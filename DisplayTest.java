import org.junit.Test;
import static org.junit.Assert.*;

public class DisplayTest {
	@Test (expected = IllegalArgumentException.class)
	public void testSwapBuffers() {
		Display display = new Display(20, 20, "No title");
		int[] fb = new int[70];

		display.swapBuffers(fb);
	}
}
