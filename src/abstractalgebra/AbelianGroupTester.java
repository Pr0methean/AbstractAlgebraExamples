package abstractalgebra;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class AbelianGroupTester<TOperand> extends MonoidTester<TOperand> {
	protected final AbelianGroup<TOperand> abelian;
	
	public AbelianGroupTester(AbelianGroup<TOperand> groupUnderTest, List<TOperand> operands) {
		super(groupUnderTest, operands);
		this.abelian = groupUnderTest;
	}
	
	@Override
	protected void oneElementTests(TOperand op) {
		super.oneElementTests(op);
		testInverseElement(op);
	}
	
	@Override
	protected void twoElementTests(TOperand op1, TOperand op2) {
		super.twoElementTests(op1, op2);
		testCommutativity(op1, op2);
	}
	
	public void testCommutativity(TOperand op1, TOperand op2) {
		assertEquals(monoid.op(op1, op2), monoid.op(op2, op1));
	}
	
	public void testInverseElement(TOperand op1) {
		TOperand inverse = abelian.getInverse(op1);
		assertEquals(identity, monoid.op(op1, inverse));
		assertEquals(identity, monoid.op(inverse, op1));
	}
}
