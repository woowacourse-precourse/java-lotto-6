package lotto;

public enum ExceptionMessage {
    INPUT_AMOUNT_EXCEPTION("1,000원으로 나누어 떨어지지 않습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
