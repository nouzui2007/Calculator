package jp.ccube.calculator.operator;


public class DivideOperator extends AbstractOperator {

	@Override
	public long calculate() {
		if (getRightValue() == 0) 
			return 0;
		else
			return getLeftValue() / getRightValue();
	}

	@Override
	public String toString() {
		return OperatorConst.OPERATOR_DIVIDE;
	}

}
