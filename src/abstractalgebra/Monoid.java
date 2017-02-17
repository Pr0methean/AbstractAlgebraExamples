package abstractalgebra;
public interface Monoid<TOperand> {

	TOperand op(TOperand lhs, TOperand rhs);

	TOperand getIdentityElement();
	
	default TOperand opAll(Iterable<TOperand> ops) {
		TOperand result = getIdentityElement();
		for (TOperand nextOp : ops) {
			result = op(result, nextOp);
		}
		return result;
	}
}