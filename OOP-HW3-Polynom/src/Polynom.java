import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Polynom<E> implements IPolynom<E>{

	private SortedMap<Integer, FieldMember<E>> coefficients;

	/**
	 * constructor: create the zero polynomial.
	 */
	public Polynom() {
		//TODO add your implementation
	}

	/**
	 * @param coefficients
	 * constructor: create the polynomial according to the parameter coefficients.
	 */
	public Polynom(Map<Integer, ? extends FieldMember<E>> coefficients) {
		//TODO add your implementation
	}

	/**
	 * @param poly
	 * Copy constructor.
	 */
	public Polynom(IPolynom<E> poly) {
		//TODO add your implementation
	}

	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (coefficients.isEmpty()) {
			return sb.toString();
		}
		sb.append("Polynom: ");
		int lastKey = coefficients.lastKey();
		for (Map.Entry<Integer, FieldMember<E>> monom : coefficients.entrySet()) {
			sb.append(monom.getValue());
			if (monom.getKey() != 0)
				sb.append("x^" + monom.getKey());
			if (monom.getKey() != lastKey) {
				sb.append(" + ");
			}
		}
		return sb.toString();
	}

}
