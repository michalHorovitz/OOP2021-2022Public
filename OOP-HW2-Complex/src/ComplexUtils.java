
public class ComplexUtils {
	
	private static double PRECISION = 1.0e-5;

	public static double getAngleInRange(double angle) {

		if ((angle > Math.PI) || (angle < (-1) * Math.PI)) {
			int d = (int) (angle / Math.PI);
			angle -= d * Math.PI;
		}
		return angle;
	}

	public static boolean areEqual(double d1, double d2) {
		return Math.abs(d1 - d2) < PRECISION;
	}

	public static void main(String[] args) {

		System.out.println(Math.round(1.0));
		System.out.println(Math.round(1.2));
		System.out.println(Math.round(1.5));
		System.out.println(Math.round(1.2));
	}

}
