package lotto;

public enum InputMessage {
	INPUT_PURCHASE("구입금액을 입력해 주세요."),
	INPUT_WINNINGNUMBERS("당첨 번호를 입력해 주세요."),
	INPUT_BONUS("보너스 번호를 입력해 주세요");
	
	private String message;

	InputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
