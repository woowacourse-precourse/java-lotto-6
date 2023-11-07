package lotto.exception;

public enum ExceptionMessage {
	INVALID_NUMBER("[ERROR] 유효하지 않은 숫자입니다."),
	MONEY_POSITIVE_ERROR("[ERROR] 양수를 입력해주세요."),
	MONEY_UNIT_ERROR("[ERROR] 기준 금액 단위로 입력해주세요.");

	private String message;

	private ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
