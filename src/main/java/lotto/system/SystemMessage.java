package lotto.system;

public enum SystemMessage {
	INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
	OUTPUT_QUANTITY_MESSAGE("개를 구매했습니다."),
	INPUT_WINNING_MESSAGE("당첨 번호를 입력해 주세요."),
	INPUT_BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
	RESULT_STATISTICS("당첨 통계"),
	LAST_RANK_MATCH_MESSAGE("3개 일치 (5,000원) - "),
	FOURTH_RANK_MATCH_MESSAGE("4개 일치 (50,000원) - "),
	THIRD_RANK_MATCH_MESSAGE("5개 일치 (1,500,000원) - "),
	SECOND_RANK_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
	FIRST_RANK_MATCH_MESSAGE("6개 일치 (2,000,000,000원) - "),
	STATISTICS_START_MESSAGE("총 수익률은 "),
	STATISTICS_END_MESSAGE("%입니다."),
	COUNT_MESSAGE("개"),
	LINE("---"),
	COMMA(","),
	NEWLINE("\n");
	
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