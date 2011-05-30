package jp.ccube.calculator.operator;


public class MinusOperator extends AbstractOperator {

	@Override
	public long calculate() {
		return getLeftValue() - getRightValue();
	}

	@Override
	public String toString() {
		return OperatorConst.OPERATOR_MINUS;
	}

}
