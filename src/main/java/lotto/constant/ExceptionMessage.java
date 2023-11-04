package lotto.constant;

public enum ExceptionMessage {

    INVALID_PAYMENT_UNIT("1000원 단위로 입력해 주십시오.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
