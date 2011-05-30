package jp.ccube.calculator;

import jp.ccube.calculator.operator.AbstractOperator;

public interface ICalculator {
	void setValue(long value);
	void setOperator(AbstractOperator operator);
	
	String getFormula();
	long getAnswer();
	
	void clear();
	void clearOperator();
	void clearValue();
}
