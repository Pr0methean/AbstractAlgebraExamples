package abstractalgebra.addition;

import abstractalgebra.AbelianGroup;

public class DoubleModularAddition implements AbelianGroup<Double> {

	protected final double modulus;
	protected final double halfModulus;

	public DoubleModularAddition(double modulus) {
		if (modulus == 0) {
			throw new ArithmeticException("Attempt to define addition modulo zero");
		}
		this.modulus = Math.abs(modulus);
		halfModulus = modulus * 0.5;
	}

	@Override
	public Double op(Double lhs, Double rhs) {
		return rangeConstrainedMod(lhs + rhs);
	}

	@Override
	public Double getIdentityElement() {
		return 0.0;
	}

	@Override
	public Double getInverse(Double op1) {
		return rangeConstrainedMod(-op1);
	}

	protected double rangeConstrainedMod(double op1) {
		double remainder = Math.IEEEremainder(op1, modulus);
		return (remainder >= halfModulus) ? -halfModulus : remainder;
	}


}
