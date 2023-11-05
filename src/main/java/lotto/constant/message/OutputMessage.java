package lotto.constant.message;

public enum OutputMessage {
    PURCHASE("개를 구매했습니다."),
    WINNING_STATUS("당첨 통계\n---"),
    WINNING_RESULT("%d개 일치 (%,d원) - %d개"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
