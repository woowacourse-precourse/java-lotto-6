package lotto.system;

public enum Constant {
	LOTTO_LENGTH(6),
	LOTTO_START_NUMBER(1),
	LOTTO_END_NUMBER(45);
	
	private final int constant;
	
	Constant(int constant) {
		this.constant = constant;
	}
	
	public int getconstant() {
		return constant;
	}
}