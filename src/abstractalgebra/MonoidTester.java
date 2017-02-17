package abstractalgebra;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class MonoidTester<TOperand> extends OneTwoThreeTester<TOperand> {

	protected final Monoid<TOperand> monoid;
	protected final TOperand identity;
	public MonoidTester(Monoid<TOperand> groupUnderTest, List<TOperand> operands) {
		super(operands);
		this.monoid = groupUnderTest;
		identity = groupUnderTest.getIdentityElement();
	}

	public void testAssociativity(TOperand op1, TOperand op2, TOperand op3) {
		assertEquals(
				monoid.op(monoid.op(op1, op2), op3),
				monoid.op(op1, monoid.op(op2, op3))
				);
	}

	public void testIdentityElement(TOperand op1) {
		assertEquals(op1, monoid.op(op1, identity));
		assertEquals(op1, monoid.op(identity, op1));
	}

	@Override
	protected void twoElementTests(TOperand op1, TOperand op2) {
		// No-op unless overridden.
	}

	@Override
	protected void threeElementTests(TOperand op1, TOperand op2, TOperand op3) {
		testAssociativity(op1, op2, op3);
	}

	@Override
	protected void oneElementTests(TOperand op) {
		testIdentityElement(op);
	}

}