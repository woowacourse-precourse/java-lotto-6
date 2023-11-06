package lotto.messages;

public enum OutputMessages {
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    THREE_DIVIDING_LINES_MESSAGE("---");

    String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
