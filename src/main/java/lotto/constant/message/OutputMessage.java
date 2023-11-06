package lotto.constant.message;

public enum OutputMessage {
    PURCHASE("\n%d개를 구매했습니다.\n"),
    WINNING_STATUS("\n당첨 통계\n---"),
    WINNING_RESULT("%d개 일치 (%,d원) - %d개\n"),
    WINNING_RESULT_BALL("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    TOTAL_RETURN("총 수익률은 %,.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
