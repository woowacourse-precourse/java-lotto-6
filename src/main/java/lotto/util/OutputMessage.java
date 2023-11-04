package lotto.util;

public enum OutputMessage {
    OUTPUT_MONEY_MESSAGE("개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
