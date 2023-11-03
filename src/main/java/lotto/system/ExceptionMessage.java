package lotto.system;

public enum ExceptionMessage {
	COMMON_VALIDATION_ERROR_MESSAGE("[ERROR] 입력이 잘못되었습니다."),
	AMOUN_VALIDATION_ERROR_MESSAGE("[ERROR] 1000원 단위가 아닙니다.");
	
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