package lotto.model.constant;

public enum CharSymbolicConstantEnum {
	UNALLOWED_LAST_CHAR(',');
	private final char value;
	CharSymbolicConstantEnum(char value) { this.value = value; }

	public char getValue() { return value; }

}
