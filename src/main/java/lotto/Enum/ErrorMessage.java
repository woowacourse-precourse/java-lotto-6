//ErrorMessage.java
package lotto.Enum;

public enum ErrorMessage {
	//Money Error
	NOT_NUMBER("[ERROR] 구입금액은 숫자로 입력해주세요."),
	NOT_DIVISIBLE_BY_1000("구입금액은 1000으로 나누어 떨어져야 합니다."),
	LESS_THAN_1000("1000 이상의 숫자를 입력해주세요."),

	//Lotto Error
	NOT_RIGHT_LOTTO_SIZE("[ERROR] 로또의 숫자는 6개로 이루어져 있어야 합니다."),
	NOT_UNIQUE_NUMBER("[ERROR] 로또의 숫자 중 중복된 숫자가 존재합니다."),

	//WinningNumber Error
	INVALID_WINNING_NUMBERS_FORMAT("[ERROR] , 로 구분하여 입력해주세요."),
	INVALID_NUMBER_COUNT("[ERROR] 6개의 숫자를 입력해주세요."),
	INVALID_NUMBER_RANGE("[ERROR] 숫자는 1에서 45 사이여야 합니다."),
	DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 있습니다."),

	// BonusNumber Error
	BONUS_NOT_NUMBER("[ERROR] 보너스 번호는 숫자로 입력해주세요."),
	BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다."),
	BONUS_DUPLICATE_NUMBER("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");


	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

