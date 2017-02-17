package abstractalgebra.addition;

import abstractalgebra.AbelianGroup;

public class DoubleAddition implements AbelianGroup<Double> {
	
	public static final DoubleAddition INSTANCE = new DoubleAddition();

	private DoubleAddition() {}

	@Override
	public Double op(Double lhs, Double rhs) {
		return lhs + rhs;
	}

	@Override
	public Double getIdentityElement() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double getInverse(Double op1) {
		// TODO Auto-generated method stub
		return -op1;
	}

}
