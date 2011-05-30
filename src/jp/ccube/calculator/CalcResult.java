package jp.ccube.calculator;

import java.io.Serializable;

public class CalcResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5994677679597766399L;
	private String formula;
	private long answer;
	
	public CalcResult() {
		this.formula = null;
		this.answer = 0;
	}
	
	public CalcResult(String formula, long answer) {
		this.formula = formula;
		this.answer = answer;
	}
	
	public String getFormula() {
		return this.formula;
	}
	
	public long getAnswer() {
		return this.answer;
	}
	
	@Override
	public String toString() {
		if (this.getFormula() == null) {
			return "";
		} else  {
			StringBuilder sb = new StringBuilder();
			sb.append(this.getFormula());
			sb.append("=");
			sb.append(Long.toString(this.getAnswer()));
			return sb.toString();
		}
	}
}
