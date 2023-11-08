package lotto.constant;

public enum LottoResultConstant {

	NO_BENEFIT(0.0),
	INIT_REWARD(0.0),
	PERCENTAGE_INDICATOR(100.0),
	ROUND_INDICATOR(100.0);


	private final Double setting;

	LottoResultConstant(final Double setting) {
		this.setting = setting;
	}

	public Double getSetting() {
		return setting;
	}
}
