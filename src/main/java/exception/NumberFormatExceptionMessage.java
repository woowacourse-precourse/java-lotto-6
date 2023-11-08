package exception;

public enum NumberFormatExceptionMessage {
	NUMBERS_ONLY("숫자만 입력해 주세요"),
	PURCHASE_AMOUNT_NUMBERS_ONLY("금액을 숫자로만 다시 입력해 주세요");

	private static final String ERROR_TAG = "[ERROR] ";
	private final String message;

	NumberFormatExceptionMessage(String message) {
		this.message = ERROR_TAG + message;
	}

	public void throwException() {
		throw new NumberFormatException(message);
	}
}
