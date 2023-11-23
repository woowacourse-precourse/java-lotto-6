package lotto.view.output.message;

public enum OutputMessage {

    READ_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
