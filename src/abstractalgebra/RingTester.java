package abstractalgebra;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class RingTester<TOperand> extends OneTwoThreeTester<TOperand> {

    protected final	Ring<TOperand> ring;
    protected final AbelianGroupTester<TOperand> additionTester;
    protected final MonoidTester<TOperand> multiplicationTester;

    protected RingTester(Ring<TOperand> ring, List<TOperand> operands,
    		AbelianGroupTester<TOperand> additionTester,
    		MonoidTester<TOperand> multiplicationTester) {
    	super(operands);
    	this.ring = ring;
    	this.additionTester = additionTester;
    	this.multiplicationTester = multiplicationTester;
    }

	public RingTester(Ring<TOperand> ring, List<TOperand> operands) {
		this(ring, operands,
				new AbelianGroupTester<>(ring.add, operands),
				new MonoidTester<>(ring.mult, operands));
	}

	@Override
	protected void oneElementTests(TOperand op) {
		additionTester.oneElementTests(op);
		multiplicationTester.oneElementTests(op);
	}

	@Override
	protected void threeElementTests(TOperand op1, TOperand op2, TOperand op3) {
		additionTester.threeElementTests(op1, op2, op3);
		multiplicationTester.threeElementTests(op1, op2, op3);
		testDistributivity(op1, op2, op3);
		testDistributivity(op2, op3, op1);
		testDistributivity(op3, op1, op2);
	}

	/**
	 * Checks that <i>a(b + c) = ab + ac</i> and <i>(b + c)a = ba + ca</i>
	 */
	protected void testDistributivity(TOperand a, TOperand b, TOperand c) {
		assertEquals(
				ring.mult.op(a, ring.add.op(b, c)),
				ring.add.op(ring.mult.op(a, b), ring.mult.op(a, c)));
		assertEquals(
				ring.mult.op(ring.add.op(b, c), a),
				ring.add.op(ring.mult.op(b, a), ring.mult.op(c, a)));
	}

	@Override
	protected void twoElementTests(TOperand op1, TOperand op2) {
		additionTester.twoElementTests(op1, op2);
		multiplicationTester.twoElementTests(op1, op2);
	}

}
