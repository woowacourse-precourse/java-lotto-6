package lotto.message;

public enum ErrorMessage {
	DUPLICATED_NUMBER("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
	EMPTY_INPUT("[ERROR] 입력값이 없습니다."),
	LACK_LOTTONUMBER("[ERROR] 당첨 번호는 6개여야 합니다."),
	CONTAIN_LETTER("[ERROR] 숫자가 아닌 값을 입력했습니다."),
	SHORT_OF_MONEY("[ERROR] 1000원부터 로또 구매가 가능합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}
	
	public String printErrorMessage() {
		return message;
	}

}
