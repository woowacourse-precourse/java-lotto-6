package lotto.exception;

public enum ExceptionInfo {
	PURCHASE_PRICE_IS_NOT_INTEGER("[ERROR] 구입 금액은 정수여야 합니다."),
	PURCHASE_PRICE_IS_NOT_RIGHT_PRICE("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
	LOTTO_NUMBERS_OVER_SIX("[ERROR] 로또 번호가 6개를 넘습니다."),
	WINNING_NUMBERS_ARE_NOT_INTEGER("[ERROR] 당첨 번호는 정수여야 합니다.");

	private final String message;

	ExceptionInfo(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
