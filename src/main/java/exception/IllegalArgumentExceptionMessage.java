package exception;

public enum IllegalArgumentExceptionMessage {
	LOTTO_OUT_OF_RANGE("1~45 사이의 숫자를 입력해 주세요"),
	LOTTO_WRONG_FORMAT("로또번호는 6개를 쉼표로 구분해서 입력해 주세요"),
	LOTTO_NUMBER_DUPLICATE("서로 다른 숫자를 입력해 주세요"),
	BONUS_NUMBER_DUPLICATE("당첨 번호에 없는 번호를 입력해 주세요"),
	BONUS_OUT_OF_RANGE("1~45 사이의 숫자로 입력헤 주세요"),
	PURCHASE_AMOUNT_NUMERIC("금액을 숫자로만 다시 입력해 주세요"),
	PURCHASE_AMOUNT_THOUSAND_UNIT("입력 단위는 1000단위 입니다"),
	PURCHASE_AMOUNT_NOT_EXCEED_ZERO("0을 초과한 금액을 입력을 입력해 주세요");

	private static final String ERROR_TAG = "[ERROR] ";
	private final String message;

	IllegalArgumentExceptionMessage(String message) {
		this.message = ERROR_TAG + message;
	}

	public void throwException() {
		throw new IllegalArgumentException(message);
	}
}
