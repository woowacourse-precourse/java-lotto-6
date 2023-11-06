package lotto;

public enum ErrorCode {
	IS_NOT_COMPOSED_OF_NUMBERS("[ERROR] 숫자로 이루어져 있지 않습니다.");
	private final String errorMessage;

	ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
