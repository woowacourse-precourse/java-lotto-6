package lotto.exception;

public enum ExceptionMessage {
	INVALID_NUMBER("[ERROR] 유효하지 않은 숫자입니다.");

	private String message;

	private ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
