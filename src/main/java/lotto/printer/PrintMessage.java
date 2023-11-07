package lotto.printer;

public enum PrintMessage {
	ASK_INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
	NOTICE_PURCHASE("개를 구매했습니다.");

	private final String message;

	PrintMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
