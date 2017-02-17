package abstractalgebra.addition;

import abstractalgebra.AbelianGroup;

public class LongModularAddition implements AbelianGroup<Long> {
	protected final long modulus;

	private long nonNegativeMod(long in) {
		long absIn = Math.abs(in);
		return (Math.floorMod(in, modulus) + absIn) % absIn;
	}

	public LongModularAddition(long modulus) {
		if (modulus == 0) {
			throw new ArithmeticException("Attempt to define addition modulo zero");
		}
		this.modulus = Math.abs(modulus);
	}

	@Override
	public Long op(Long lhs, Long rhs) {
		return nonNegativeMod(lhs + rhs);
	}

	@Override
	public Long getIdentityElement() {
		return 0L;
	}

	@Override
	public Long getInverse(Long op1) {
		return nonNegativeMod(-op1);
	}

}
