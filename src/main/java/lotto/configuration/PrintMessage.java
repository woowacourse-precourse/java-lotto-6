package lotto.configuration;

public enum PrintMessage {
    WINNING_STATISTICS("당첨 통계"),
    DASH("-"),
    COUNT("개");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
