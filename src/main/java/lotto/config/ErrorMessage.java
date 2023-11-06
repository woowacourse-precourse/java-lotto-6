package lotto.config;

public enum ErrorMessage {
	INVALID_PURCHASE_AMOUNT("[ERROR] 구매 금액은 1,000원 단위의 금액이어야 합니다."),
	BLANK_PURCHASE_AMOUNT("[ERROR] 구매 금액을 입력해 주세요."),
	NON_NUMERIC_PURCHASE_AMOUNT("[ERROR] 구매 금액은 숫자만 입력 가능합니다."),
	INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
	INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
	DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
	BLANK_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력해 주세요."),
	INVALID_WINNING_NUMBERS("[ERROR] 쉼표(,)를 기준으로 6개의 정수를 입력해 주세요."),
	BLANK_BONUS_NUMBER("[ERROR] 보너스 번호를 입력해 주세요."),
	OVERLAPPED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 다른 숫자를 입력해야 합니다.");


	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}