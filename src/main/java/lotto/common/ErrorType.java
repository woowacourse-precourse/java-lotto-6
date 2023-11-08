package lotto.common;

public enum ErrorType {
	INVALID_LOTTO_NUMBER("[ERROR] 로또 번호가 올바르지 않습니다."),
	INVALID_PURCHASE_ERROR("[ERROR] 구입 금액이 올바르지 않습니다."),
	INVALID_BONUS_NUMBER("[ERROR] 보너스 번호가 올바르지 않습니다."),
	INVALID_RESULT_ERROR("[ERROR] 잘못된 로또 형태로 인해 로또 번호 비교 도중 에러가 발생했습니다.");

	private final String errorMessage;

	ErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
