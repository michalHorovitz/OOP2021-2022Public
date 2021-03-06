import java.util.Objects;

public abstract class FieldMember<E> implements Comparable<FieldMember<E>> {

	private E value;

	public FieldMember(E value) {
		this.value = value;
	}

	public E getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getValue().toString();
	}

	/**
	 * @param num
	 * @return the sum of this and num
	 * the current object is not changed
	 */
	public FieldMember<E> add(FieldMember<E> num) {
		return add(num.getValue());
	}

	/**
	 * @param num
	 * @return the result of subtraction num of this.
	 * the current object is not changed
	 */
	public FieldMember<E> sub(FieldMember<E> num) {
		return add(num.getNegative());
	}

	/**
	 * @param num
	 * @return the multiplication by num
	 * the current object is not changed
	 */
	public FieldMember<E> mult(FieldMember<E> num) {
		return mult(num.getValue());
	}

	/**
	 * @param num
	 * @return the result of this divided by num
	 * the current object is not changed
	 */
	public FieldMember<E> div(FieldMember<E> num) {
		return mult(num.getInverse());
	}

	/**
	 * @param num
	 * @return the the exponent n of this (value^n).
	 * the current object is not changed
	 */
	public FieldMember<E> exponent(int n) {
		if (n == 0)
			return getIdentity();
		FieldMember<E> res = copy();
		for (int i = 1; i < n; i++)
			res = res.mult(getValue());
		return res;
	}

	/**
	 * @return a copy of the object
	 */
	public abstract FieldMember<E> copy();

	/**
	 * @param num
	 * @return the sum of this and num
	 * the current object is not changed
	 */
	public abstract FieldMember<E> add(E num);

	/**
	 * @param num
	 * @return the multiplication by num
	 * the current object is not changed
	 */
	public abstract FieldMember<E> mult(E num);

	/**
	 * @return the negative number
	 * the current object is not changed
	 */
	public abstract FieldMember<E> getNegative();

	/**
	 * @return the inverse number
	 * the current object is not changed
	 */
	public abstract FieldMember<E> getInverse();

	/**
	 * @return the multiplication identity
	 * the current object is not changed
	 */
	public abstract FieldMember<E> getIdentity();

	/**
	 * @return the additional identity
	 * the current object is not changed
	 */
	public abstract FieldMember<E> getZero();

	public boolean isZero() {
		return this.equals(getZero());
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldMember<E> other = (FieldMember<E>) obj;
		return Objects.equals(value, other.value);
	}

}