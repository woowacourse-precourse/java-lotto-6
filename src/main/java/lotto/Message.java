package lotto;

public enum Message {
	SEPARATOR(","),
	PURCHASE_MESSAGE("구입할 금액을 입력해 주세요."),
	PURCHASE_COUNT_MESSAGE("개를 구매했습니다.\n"),
	WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
	BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
	STATISTICS_MESSAGE("\n당첨 통계\n---"),
	MATCH_THREE("3개 일치 (5,000원) - "),
	MATCH_FOUR("4개 일치 (50,000원) - "),
	MATCH_FIVE("5개 일치 (1,500,000원) - "),
	MATCH_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치(30,000,000원) - "),
	MATCH_SIX("6개 일치 (2,000,000,000원) - "),
	ERROR_MESSAGE("[ERROR]"),
	EMPTY("Empty error is occurred"),
	DIGIT("Digit error is occurred"),
	REMAINDER("Remainder error is occurred"),
	NEGATIVE("Negative error is occurred"),
	RANGE("Range error is occurred"),
	DUPLICATE("Duplicate error is occurred"),
	SIZE("Size error is occurred");

	private final String message;
	Message(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void printMessage() {
		System.out.println(message);
	}
	public void printMessageWithNumber(int number) {
		System.out.println(message + number + "개");
	}
	public void printMessageWithString(String message) {
		System.out.println(this.message + message);
	}
	public static void printStringMessage(String message) {
		System.out.printf(message);
	}
	public static void printProfitMessage(int total, int money) {
		System.out.printf("총 수익률은 %.1f%%입니다.", (double) (total * 100) / money);
	}
}
