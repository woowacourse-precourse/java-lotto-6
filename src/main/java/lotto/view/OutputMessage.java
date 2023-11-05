package lotto.view;

public enum OutputMessage {
    PURCHASE_RESULT("%d개를 구매했습니다."),
    WINNING_STATISTICS_TITLE("당첨 통계\n---");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
