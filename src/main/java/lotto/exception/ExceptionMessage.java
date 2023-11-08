package lotto.exception;

public enum ExceptionMessage {
	LOTTO_INVALID_SIZE("[ERROR] 유효하지 않은 로또 사이즈입니다."),
	LOTTO_OUT_OF_RANGE_ERROR("[ERROR] 로또 숫자가 유효 범위내에 존재하지 않습니다."),
	LOTTO_DUPLICATED_ERROR("[ERROR] 중복된 로또 숫자가 존재합니다."),
	INVALID_NUMBER("[ERROR] 유효하지 않은 숫자입니다."),
	POSITIVE_NUMBER_ERROR("[ERROR] 양수를 입력해주세요."),
	MONEY_UNIT_ERROR("[ERROR] 기준 금액 단위로 입력해주세요.");

	private String message;

	private ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
