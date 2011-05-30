package jp.ccube.calculator.operator;

public abstract class AbstractOperator {
	private long leftValue;
	private long rightValue;

	public AbstractOperator() {
		this.leftValue = 0;
		this.rightValue = 0;
	}
	
	public void setLeftValue(long value) {
		this.leftValue = value;
	}
	
	public void setRightValue(long value) {
		this.rightValue = value;
	}
	
	protected long getLeftValue() {
		return this.leftValue;
	}
	
	protected long getRightValue() {
		return this.rightValue;
	}
	
	public abstract long calculate();
	public abstract String toString();
}
