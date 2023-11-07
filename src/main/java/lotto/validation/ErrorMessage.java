package lotto.validation;

public enum ErrorMessage {
	ERROR_INPUT_SIZE("[ERROR] 6개의 숫자를 입력해 주세요."), ERROR_RANGE("[ERROR] 1-45의 숫자를 입력해 주세요."),
	ERROR_INPUT_DUPLICATION("[ERROR] 중복되지 않은 숫자를 입력해 주세요."),
	ERROR_BONUS_RANGE_DUPLICATION("[ERROR] 당첨 번호와 다른 1-45의 숫자를 입력해 주세요."),
	ERROR_PURCHASE_1000("[ERROR] 구입 금액은 1,000원의 배수여야 합니다."),
	ERROR_PURCHASE_LIMIT("[ERROR] 구입 금액은 1,000이상 100000이하여야 합니다."), ERROR_IS_NUMBER("[ERROR] 숫자를 입력해 주세요."),
	ERROR_WINNING_CONTAINS_COMMA("[ERROR] ,로 구분된 숫자를 입력해 주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}