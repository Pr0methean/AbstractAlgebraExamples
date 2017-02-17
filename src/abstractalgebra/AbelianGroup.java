package abstractalgebra;
public interface AbelianGroup<TOperand> extends Monoid<TOperand> {
	TOperand getInverse(TOperand op1);
}
