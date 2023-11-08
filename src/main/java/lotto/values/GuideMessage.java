package lotto.values;

public enum GuideMessage {
    REQUEST_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    PURCHASED_MESSAGE("%d개를 구매했습니다.\n"),
    RESULT_MESSAGE("당첨 통계\n---"),
    TOTAL_EARNINGS_RATE_MESSAGE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
