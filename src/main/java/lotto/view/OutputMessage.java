package lotto.view;

public enum OutputMessage {
    PURCHASE_RESULT("%d개를 구매했습니다."),
    WINNING_STATISTICS_TITLE("당첨 통계\n---"),
    WINNING_RESULT("%s (%,d원) - %d개"),
    WINNING_STATISTICS("총 수익률은 %.1f%%입니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
