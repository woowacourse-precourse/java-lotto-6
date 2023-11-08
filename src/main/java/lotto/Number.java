package lotto;

public enum Number {
	LOTTO_SIZE(6),
	LOTTO_PRICE(1000),
	MAX_NUMBER(45),
	MIN_NUMBER(1),
	ZERO(0),
	THREE(3),
	THREE_PRIZE(5000),
	FOUR(4),
	FOUR_PRIZE(50000),
	FIVE(5),
	FIVE_PRIZE(1500000),
	FIVE_WITH_BONUS_PRIZE(30000000),
	SIX(6),
	SEVEN(7),
	SIX_PRIZE(2000000000);

	private final int number;

	Number(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
