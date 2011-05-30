package jp.ccube.calculator;

import java.lang.Character;

public class NumberGenerator {
	private String value;
	
	public NumberGenerator() {
		this.clear();
	}
	
	public void clear() {
		this.value = "0";
	}
	
	public String getValue() {
		return this.value;
	}
	
	public String addValue(char digit) {
		//¬”“_‚ª‚·‚Å‚É‚ ‚Á‚½‚çAˆ—I—¹
		if (digit == '.') {
			if (this.value.contains(Character.toString(digit))) {
				return this.getValue();
			}
		}

		StringBuilder sb = new StringBuilder();
		if (!"0".equals(this.value)) {
			sb.append(this.value);
		}
		sb.append(Character.toString(digit));
		this.value = sb.toString();
		
		return this.getValue();
	}
}
