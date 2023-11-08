package enums;

public enum Input {
	
	BUY_AMOUNT("구입금액을 입력해 주세요."),
	WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요.");
	
	final private String input; 

	Input(String input) {
		this.input = input;
	}
	
	public String getInput() {
		return input;
	}
}
