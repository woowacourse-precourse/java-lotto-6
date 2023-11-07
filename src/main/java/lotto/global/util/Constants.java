package lotto.global.util;

public enum Constants {
	LOTTO_NUMBER_COUNT(6),
	LOTTO_COUNT(8),
	PRICE_UNIT(1000),
	MIN_LOTTO_NUMBER(1),
	MAX_LOTTO_NUMBER(45);

	public int value;

	Constants(int value) {
		this.value = value;
	}
}