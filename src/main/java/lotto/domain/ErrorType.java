package lotto.domain;

public enum ErrorType {
	INVALID_LOTTO_NUMBER("[ERROR] 로또 번호가 올바르지 않습니다."),
	INVALID_PURCHASE_ERROR("[ERROR] 구입 금액이 올바르지 않습니다."),
	INVALID_BONUS_NUMBER("[ERROR] 보너스 번호가 올바르지 않습니다.");

	private final String errorMessage;

	ErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
