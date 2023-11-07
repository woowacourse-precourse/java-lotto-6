package lotto.view.constant;

public enum InputConstant {
	PRICE_REQUEST("구입금액을 입력해 주세요."),
	WINNING_REQUEST("당첨 번호를 입력해 주세요."),
	BONUS_REQUEST("보너스 번호를 입력해 주세요."),
	INPUT_DELIMITER(",");

	private final String value;

	InputConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
