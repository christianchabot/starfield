
public class Vector4f {

	private float x;
	private float y;
	private float z;
	private float w;
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getW() {
		return w;
	}

	public Vector4f add(Vector4f v1) {
		return new Vector4f(x+v1.getX(), y+v1.getY(), z+v1.getZ(), w+v1.getW());
	}

	public Vector4f add(float number) {
		return new Vector4f(x+number, y+number, z+number, w+number);
	}

	public Vector4f divide(Vector4f v1) {
		return new Vector4f(x/v1.getX(), y/v1.getY(), z/v1.getZ(), w/v1.getW());
	}

	public Vector4f divide(float scale) {
		return new Vector4f(x/scale, y/scale, z/scale, w/scale);
	}

	public Vector4f getCrossProduct(Vector4f v1) {
		float newX = y*v1.getZ() - z*v1.getY();
		float newY = z*v1.getX() - x*v1.getZ();
		float newZ = x*v1.getY() - y*v1.getX();

		return new Vector4f(newX, newY, newZ, 0);
	}

	public float getDotProduct(Vector4f v1) {
		return x*v1.getX() + y*v1.getY() + z*v1.getZ() + w*v1.getW();
	}

	public float length() {
		return (float) Math.sqrt(x*x + y*y + z*z + w*w);
	}

	public Vector4f multiply(Vector4f v1) {
		return new Vector4f(x*v1.getX(), y*v1.getY(), z*v1.getZ(), w*v1.getW());
	}

	public Vector4f multiply(float scale) {
		return new Vector4f(x*scale, y*scale, z*scale, w*scale);
	}

	public Vector4f normalize() {
		return divide(length());
	}

	public Vector4f subtract(Vector4f v1) {
		return new Vector4f(x-v1.getX(), y-v1.getY(), z-v1.getZ(), w-v1.getW());
	}

	public Vector4f subtract(float number) {
		return new Vector4f(x-number, y-number, z-number, w-number);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
