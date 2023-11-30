package lotto.printer;

public enum PrintMessage {
	ASK_INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
	NOTICE_PURCHASE("개를 구매했습니다.\n"),
	ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
	NOTICE_RESULT("\n당첨 통계\n---\n"),
	FIFTH_PLACE_RESULT("3개 일치 (5,000원) - "),
	FOURTH_PLACE_RESULT("4개 일치 (50,000원) - "),
	THIRD_PLACE_RESULT("5개 일치 (1,500,000원) - "),
	SECOND_PLACE_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST_PLACE_RESULT("6개 일치 (2,000,000,000원) - "),
	RETURN_RATE_FIRST("총 수익률은 "),
	RETURN_RATE_SECOND("%입니다.\n");

	private final String message;

	PrintMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
