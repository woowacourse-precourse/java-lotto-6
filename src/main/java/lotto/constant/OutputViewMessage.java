package lotto.constant;

public enum OutputViewMessage {
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---");
    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
