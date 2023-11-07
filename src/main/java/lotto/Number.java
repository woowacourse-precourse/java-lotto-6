package lotto;

public enum Number {
	LOTTO_SIZE(6),
	LOTTO_PRICE(1000),
	MAX_NUMBER(45),
	MIN_NUMBER(1),
	ZERO(0),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6);

	private final int number;

	Number(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
