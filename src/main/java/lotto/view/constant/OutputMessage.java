package lotto.view.constant;

public enum OutputMessage {

    PURCHASED_COUNT("개를 구매했습니다."),
    NEWLINE("\n");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
