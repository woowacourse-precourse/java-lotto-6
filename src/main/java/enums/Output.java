package enums;

public enum Output {

	BUY_AMOUNT("구입금액을 입력해 주세요."),
	YOUR_LOTTO("개를 구입하셨습니다."),
	WINNING_NUMBER("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER("보너스 번호를 입력해 주세요."),
	STATS("당첨통계"),
	SIX_MATCHES("6개 일치 (2,000,000,000원) - "),
	FIVE_bONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIVE_MATCHES("5개 일치 (1,500,000원) - "),
	FOUR_MATCHES("4개 일치 (50,000원) - "),
	THREE_MATCHES("3개 일치 (5,000원) - ");
	
	final private String input; 

	Output(String input) {
		this.input = input;
	}
	
	String getInput() {
		return input;
	}
	
}
