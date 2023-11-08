package lotto.constant;

public enum LottoConstant {
	REPLACE_SIZE(2),
	LOTTO_LENGTH(6),
	RANGE_START_NUMBER(1),
	RANGE_END_NUMBER(45);

	private final Integer setting;

	LottoConstant(final Integer setting) {
		this.setting = setting;
	}

	public Integer getSetting() {
		return setting;
	}
}
