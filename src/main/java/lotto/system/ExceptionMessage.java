package lotto.system;

public enum ExceptionMessage {
	COMMON_VALIDATION_ERROR_MESSAGE("[ERROR] 입력이 잘못되었습니다."),
	AMOUN_VALIDATION_ERROR_MESSAGE("[ERROR] 1000원 단위가 아닙니다."),
	LOTTO_VALIDATION_ERROR_MESSAGE("[ERROR] 로또 번호가 잘못되었습니다."),
	WINNING_VALIDATION_ERROR_MESSAGE("[ERROR] 쉼표를 기준으로 입력해주세요.");
	private final String message;
	
	ExceptionMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}