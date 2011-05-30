package jp.ccube.calculator.operator;

public class OperatorFactory {
	public static AbstractOperator create(String operator) throws EInvalidOperator {
		if (OperatorConst.OPERATOR_PLUS.equals(operator)) {
			return new PlusOperator();
		}
		else if (OperatorConst.OPERATOR_MINUS.equals(operator)) {
			return new MinusOperator();
		}
		else if (OperatorConst.OPERATOR_TIMES.equals(operator)) {
			return new TimesOperator();
		}
		else if (OperatorConst.OPERATOR_DIVIDE.equals(operator)) {
			return new DivideOperator();
		}
		else {
			throw new EInvalidOperator();
		}
	}
}
