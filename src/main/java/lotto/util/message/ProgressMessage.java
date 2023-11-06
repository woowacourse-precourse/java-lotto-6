package lotto.util.message;

public enum ProgressMessage implements MessageFormatter{

	INPUT_MONEY("구입금액을 입력해 주세요."),
	BUYED_LOTTO_NUMBER("%s개를 구매했습니다."),
	INPUT_ANSWER_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

	private final String message;

	ProgressMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getFormattedMessage(Object... params) {
		return String.format(getMessage(), params);
	}
}
