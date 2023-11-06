package lotto;

public enum ErrorCode {
	NOT_COMPOSED_OF_NUMBERS("[ERROR] 숫자로 이루어져 있지 않습니다."),
	NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 1000으로 나누어 떨어져야 합니다."),
	ELEMENTS_SHOULD_BE_SIX("[ERROR] 번호는 6개여야 합니다.");
	private final String errorMessage;

	ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
