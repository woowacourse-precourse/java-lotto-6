package lotto.enums;

public enum OutputMessages {
    RESULT_MESSAGE("당첨 통계\n---"),
    TOTAL_PROFIT_MESSAGE("총 수익률은 %.2f입니다."),
    OPEN_MARK("["),
    CLOSE_MARK("]"),
    DIVISION_MARK(", ");
    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
