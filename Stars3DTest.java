import org.junit.Test;
import static org.junit.Assert.*;

public class Stars3DTest {
	@Test (expected = IllegalArgumentException.class)
	public void testStars3DConstructorNumStars() {
		Stars3D stars = new Stars3D(-1, 64.0f, 20.0f, 70.0f);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStars3DConstructorSpread() {
		Stars3D stars = new Stars3D(4096, -1, 20.0f, 70.0f);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStars3DConstructorSpeed() {
		Stars3D stars = new Stars3D(4096, 64.0f, -1, 70.0f);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStars3DConstructorAngle() {
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f, -1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testStars3DUpdateAndRenderBounds() {
		Stars3D stars = new Stars3D(4096, 64.0f, 20.0f, -1);
		int[] frameBuffer = new int[20*20];

		stars.updateAndRender(frameBuffer, 20, 3, 4);
	}
}
