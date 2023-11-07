package lotto.view.constant;

public enum OutputConstant {
	PURCHASE_RESULT("개를 구매했습니다."),
	WINNING_RESULT("당첨통계\n---"),
	PRIZE_PATTERN("#,###");

	private final String value;

	OutputConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
