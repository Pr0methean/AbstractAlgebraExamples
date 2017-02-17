package abstractalgebra;
import java.util.List;

/**
 * Abstract tester that calls its test methods over every 1-, 2- and 3-element subset of the list.
 *
 * @author cryoc
 *
 * @param <TOperand>
 */
public abstract class OneTwoThreeTester<TOperand> {

	protected final List<TOperand> operands;

	protected abstract void oneElementTests(TOperand op);

	protected abstract void threeElementTests(TOperand op1, TOperand op2, TOperand op3);

	protected abstract void twoElementTests(TOperand op1, TOperand op2);

	public OneTwoThreeTester(List<TOperand> operands) {
		this.operands = operands;
	}

	public void test() {
		int n = operands.size();
		for (int i = 0; i < n; i++) {
			TOperand op1 = operands.get(i);
			oneElementTests(op1);
			for (int j = i; j < n; j++) {
				TOperand op2 = operands.get(j);
				twoElementTests(op1, op2);
				for (int k = j; k < n; k++) {
					threeElementTests(op1, op2, operands.get(k));
				}
			}
		}
	}

}