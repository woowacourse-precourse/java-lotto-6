package lotto.exception;

public enum LottoExceptionMessage {
	WRONG_LOTTO_LENGTH("[ERROR] 로또는 6개의 숫자로 구성되야합니다"),
	WRONG_LOTTO_NUMBER_RANGE("[ERROR] 로또 숫자의 허용 범위는 1~45까지입니다."),
	DUPLICATED_NUMBER("[ERROR] 중복된 숫자로 이루어진 로또를 생성할 수 없습니다.");

	private final String message;

	LottoExceptionMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
