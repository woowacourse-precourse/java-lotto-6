package lotto.message;

public enum PrintMessage {
	PURCHASE_LOTTO("구입금액을 입력해 주세요."),
	INPUT_LOTTO_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
	INPUT_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
	
	PRINT_LOTTO("개를 구매했습니다."),
	RESULT_LOTTO_HEADER("당첨 통계\n---"),
	FIRST("6개 일치 (2,000,000,000원) -"),
	SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) -"),
	THIRD("5개 일치 (1,500,000원) -"),
	FOURTH("4개 일치 (50,000원) -"),
	FIFTH("3개 일치 (5,000원) -");
	

	private String message;

	PrintMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
