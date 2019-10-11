import org.junit.Test;
import static org.junit.Assert.*;

public class DisplayTest {
	@Test (expected = IllegalArgumentException.class)
	public void testDisplayConstructorWidth() {
		Display display = new Display(-1, 20, null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDisplayConstructorHeight() {
		Display display = new Display(20, -1, null);
	}
}
