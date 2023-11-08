package lotto.exception;

public enum ErrorMessage {
	EMPTY_INPUT("입력값이 없습니다."),
	INVALID_LOTTO_NUMBER("로또 번호는 1부터 45사이의 숫자여야 합니다."),
	INVALID_AMOUNT("금액은 1000원 단위로 설정해야 합니다."),
	INVALID_MONEY("금액은 음수가 될 수 없습니다."),
	STRING_NOT_ALLOWED("숫자만 입력 가능합니다."),
	INVALID_WINNING_NUMBERS_VALUE("당첨 번호는 쉼표(,)로 구분된 숫자 조합여야합니다."),
	INVALID_WINNING_NUMBERS_SIZE("당첨 번호는 6개의 숫자여야 합니다."),
	INVALID_BONUS_NUMBER("보너스 번호는 당첨 번호와 겹칠 수 없습니다."),
	DUPLICATED_NUMBER("중복된 번호가 있습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = String.format("%s %s", "[ERROR]", message);
	}

	public String getMessage() {
		return this.message;
	}

}
