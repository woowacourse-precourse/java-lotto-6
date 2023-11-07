package lotto;

public enum Output {
	RESULT_MESSAGE("등 ㅊㅋ"),
	PURCHASE_MESSAGE("구입할 금액을 입력해 주세요."),
	PURCHASE_COUNT_MESSAGE("\n8개를 구매했습니다.\n"),
	WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
	BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
	STATISTICS_MESSAGE("당첨 통계\n---\n"),
	MATCH_THREE("3개 일치 (5,000원) - "),
	MATCH_FOUR("4개 일치 (50,000원) - "),
	MATCH_FIVE("5개 일치 (1,500,000원) - "),
	MATCH_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치(30,000,000원) - "),
	MATCH_SIX("6개 일치 (2,000,000,000원) - ");

	private final String message;
	Output(String message) {
		this.message = message;
	}
	public void getMessage() {
		System.out.println(message);
	}
	public static void printMessage(String message) {
		System.out.println(message);
	}
	public void ResultMessage(int number) {
		if (number == 3)
			System.out.println(MATCH_THREE.message);
		if (number == 4)
			System.out.println("4등 ㅊㅋ");
		if (number == 5)
			System.out.println("5등 ㅊㅋ");
	}
}
