package lotto.io.message;

public enum ExceptionMessage {

    INVALID_PURCHASE_AMOUNT_MESSAGE("금액은 1000의 배수여야 합니다.");

    public final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
