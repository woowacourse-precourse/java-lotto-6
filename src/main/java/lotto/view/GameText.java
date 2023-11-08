package lotto.view;

public enum GameText {
	PURCHASE_PRICE("구입 금액을 입력해 주세요."),
	PURCHASE_COMPLETED("개를 구매했습니다."),
	WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS("당첨 통계"),
	UNDER_BAR("---"),
	THREE_CORRECT("3개 일치 (5,000원) - "),
	FOUR_CORRECT("4개 일치 (50,000원) - "),
	FIVE_CORRECT("5개 일치 (1,500,000원) - "),
	FIVE_CORRECT_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	SIX_CORRECT("6개 일치 (2,000,000,000원) - "),
	RATE_OF_RETURN("총 수익률은 "),
	COUNT("개"),
	SENTENCE_END("입니다.");

	private final String text;

	GameText(String str) {
		this.text = str;
	}

	public String getText() {
		return text;
	}
}