import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestComplexJUnit {

	// Complex1 members
	private IComplex c11;
	private IComplex c12;
	private IComplex c13;

	// Complex2 members
	private IComplex c21;
	private IComplex c22;
	private IComplex c23;

	@Before
	public void before() {
		c11 = new Complex1();
		c12 = new Complex1(3, 4);

		c21 = new Complex2();
		c22 = new Complex2(c12);

		c23 = new Complex2(1, Math.PI / 2);
		c13 = new Complex1(c23);
	}

	@Test
	public void testCtors() {
		testGets(c11, 0, 0, 0, 0);
		testGets(c21, 0, 0, 0, 0);
		testGets(c12, 3, 4, 5, Math.atan(4 / 3.0));
		testGets(c22, 3, 4, 5, Math.atan(4 / 3.0));

		IComplex c23 = new Complex2(1, Math.PI / 2);
		IComplex c13 = new Complex1(c23);
		testGets(c23, 0, 1, 1, Math.PI / 2);
		testGets(c13, 0, 1, 1, Math.PI / 2);

	}

	private void testGets(IComplex c, double real, double img, double radius, double angle) {
		assertTrue(ComplexUtils.areEqual(c.getReal(), real));
		assertTrue(ComplexUtils.areEqual(c.getImage(), img));
		assertTrue(ComplexUtils.areEqual(c.getRadius(), radius));
		assertTrue(ComplexUtils.areEqual(c.getAngle(), angle));
	}

	@Test
	public void testSets() {
	}

	@Test
	public void testAdd() {
	}

	@Test
	public void testSub() {
	}

	@Test
	public void testMult() {
	}

	@Test
	public void testDiv() {
	}

	@Test
	public void testMultScalar() {
	}

	@Test
	public void testEqualsTo() {

		assertTrue(c11.equalTo(c11));
		assertTrue(c21.equalTo(c21));
		assertTrue(c11.equalTo(c21));
		assertTrue(c21.equalTo(c11));

		assertTrue(c22.equalTo(c12));
		assertTrue(c12.equalTo(c22));

		assertFalse(c11.equalTo(c12));
		assertFalse(c11.equalTo(c22));
		assertFalse(c21.equalTo(c22));
		assertFalse(c21.equalTo(c12));
	}

}
