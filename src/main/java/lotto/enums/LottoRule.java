package lotto.enums;

public enum LottoRule {
	START(1), END(45),
	LOTTO_PRICE(1000), LOTTO_MAX_COUNT(6);

	private Integer value;

	LottoRule(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
