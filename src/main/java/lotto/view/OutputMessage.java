package lotto.view;

public enum OutputMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_RESULT("\n%d개를 구매했습니다.\n"),
    REQUEST_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계"),
    SEPARATOR("---"),
    RESULT("%d개 일치 (%s원) - %d개\n"),
    BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    TOTAL_RETURN("총 수익률은 %.2f%%입니다.\n");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
