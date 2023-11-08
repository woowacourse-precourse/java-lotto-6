package lotto.util;

public enum ErrorCode {
	INVALID_PURCHASE_AMOUNT("구매 금액은 천원 단위여야 합니다."),
	INVALID_PURCHASE_VALUE("구매 금액은 숫자여야 합니다.");

	private final String message;

	ErrorCode(final String message) {
		this.message = "[ERROR] " + message;
	}

	public String message() {
		return message;
	}
}
