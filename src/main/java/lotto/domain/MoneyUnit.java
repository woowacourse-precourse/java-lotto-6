package lotto.domain;

public enum MoneyUnit {
	MONEY_UNIT(1000),
	WANTED_REMAINDER(0);

	private final int value;
	MoneyUnit(int value) { this.value = value; }

	public int getValue() { return value; }
}
