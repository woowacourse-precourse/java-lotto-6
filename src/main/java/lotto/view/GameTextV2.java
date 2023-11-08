package lotto.view;

public enum GameTextV2 {
	PURCHASE_PRICE("얼마치를 살거야? 1000원의 배수로 입력해줘"),
	PURCHASE_COMPLETED("개를 구매했어!"),
	WINNING_NUMBER("당첨 번호를 알려주면 좋겠어"),
	BONUS_NUMBER("보너스 번호를 알려주면 좋겠어"),
	WINNING_STATISTICS("결과 통계야!"),
	UNDER_BAR("---"),
	THREE_CORRECT("3개 맞은 복권! (5,000원) - "),
	FOUR_CORRECT("4개 맞은 복권! (50,000원) - "),
	FIVE_CORRECT("5개 맞은 복권! (1,500,000원) - "),
	FIVE_CORRECT_BONUS("5개에 보너스 숫자 맞은 복권!! (30,000,000원) - "),
	SIX_CORRECT("1등 당첨!!! (2,000,000,000원) - "),
	RATE_OF_RETURN("너의 수익률은? "),
	COUNT("개"),
	SENTENCE_END("%!!");

	private final String text;

	GameTextV2(String str) {
		this.text = str;
	}

	public String getText() {
		return text;
	}
}
