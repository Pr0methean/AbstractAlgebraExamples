package abstractalgebra;
public class Ring<TOperand> {
	public final AbelianGroup<TOperand> add;
	
	public final Monoid<TOperand> mult;
	
	public Ring(AbelianGroup<TOperand> addition, Monoid<TOperand> multiplication) {
		this.add = addition;
		this.mult = multiplication;
	}
}
