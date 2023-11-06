package lotto.config;

public enum GameGuideMessage {
	INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
	NUMBER_OF_TICKETS_PURCHASED("%d개를 구매했습니다."),
	INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
	WINNING_STATISTICS("당첨 통계\n---"),
	SHOW_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

	private final String message;

	GameGuideMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}