package abstractalgebra.addition;

import abstractalgebra.AbelianGroup;

public class LongAddition implements AbelianGroup<Long> {

	public static final LongAddition INSTANCE = new LongAddition();
	
	private LongAddition() {}

	@Override
	public Long op(Long lhs, Long rhs) {
		return lhs + rhs;
	}

	@Override
	public Long getIdentityElement() {
		return 0L;
	}

	@Override
	public Long getInverse(Long op1) {
		return -op1;
	}

}
