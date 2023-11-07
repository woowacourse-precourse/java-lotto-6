package lotto.constant;

public enum LottoConstant {
	MIN_LOTTO_NUMBER(1),
	MAX_LOTTO_NUMBER(45),
	MIN_RANK(1),
	MAX_RANK(5),
	PICK_COUNT(6),
	LOTTO_PRICE(1000);

	private final int value;

	LottoConstant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
