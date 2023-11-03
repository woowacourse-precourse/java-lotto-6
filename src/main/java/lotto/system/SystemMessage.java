package lotto.system;

public enum SystemMessage {
	INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");
	
	private final String message;
	
	SystemMessage(String message) {
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