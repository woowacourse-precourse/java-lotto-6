package lotto.messages;

public enum OutputMessages {
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    THREE_DIVIDING_LINES_MESSAGE("---"),
    RATE_OF_RETURN_MESSAGE_HEAD("총 수익률은 "),
    RATE_OF_RETURN_MESSAGE_TAIL("입니다.");

    String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
