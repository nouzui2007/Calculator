package jp.ccube.calculator;

import jp.ccube.calculator.operator.AbstractOperator;

public class SimpleCalculator implements ICalculator {

	private long leftValue;
	private long rightValue;
	private AbstractOperator operator;
	
	public SimpleCalculator() {
		this.leftValue = 0;
		this.rightValue = 0;
		this.operator = null;
	}
	
	public Boolean isEmptyOperator() {
		return (this.operator == null);
	}

	public void setValue(long value) {
		if (this.isEmptyOperator())
			this.leftValue = value;
		else
			this.rightValue = value;
	}

	public void setOperator(AbstractOperator operator) {
		this.operator = operator;
	}

	public String getFormula() {
		StringBuilder sb = new StringBuilder();
		sb.append(Long.toString(this.leftValue));
		sb.append(this.operator.toString());
		sb.append(Long.toString(this.rightValue));
		return sb.toString();
	}

	public long getAnswer() {
		this.operator.setLeftValue(this.leftValue);
		this.operator.setRightValue(this.rightValue);
		return this.operator.calculate();
	}

	public void clear() {
		this.clearOperator();
		this.clearValue();
	}

	public void clearOperator() {
		this.operator = null;
	}

	public void clearValue() {
		this.leftValue = 0;
		this.rightValue = 0;
	}
}
