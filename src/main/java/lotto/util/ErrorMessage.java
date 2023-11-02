package lotto.util;

public enum ErrorMessage {
	
	LOTTO_SIZE_ERROR("로또의 사이즈는 %s이여야 합니다."),
	LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복되지 말아야 합니다."),
	LOTTO_BONUS_NUMBER_DUPLICATE_ERROR("당첨 번호와 보너스 번호는 중복되지 말아야 합니다."),
	LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %s부터 %s 사이의 숫자여야 합니다."),
	PREFIX("[ERROR] ");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX.message + message;
	}
	
	public String getForMatMessage(Object... params) {
	    return String.format(getMessage(), params);
	}
}
