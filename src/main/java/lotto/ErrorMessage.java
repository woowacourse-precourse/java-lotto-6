package lotto;

public enum ErrorMessage {
	PRICE_NUMBER("[ERROR] 구입금액은 숫자만 입력할 수 있습니다."),
	PRICE_DIVIDE_BY_1000("[ERROR] 구입금액은 1,000원 단위로 입력해주세요."),
	WINNING_NUM_CONTAIN_NUMBER_AND_COMMA("[ERROR] 당첨 번호는 숫자와 쉼표(,)만 입력해주세요."),
	WINNING_NUM_RANGE("[ERROR] 당첨 번호는 1~45 사이의 숫자를 입력해주세요."),
	WINNING_NUM_SIZE("[ERROR] 당첨 번호는 여섯개의 숫자를 입력해주세요."),
	WINNING_NUM_NOT_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
	BONUS_IS_NUMBER("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
	BONUS_RANGE("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해주세요."),
	BONUS_NOT_SAME_WINNING_NUM("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

	private String errorMsg;
	ErrorMessage(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
