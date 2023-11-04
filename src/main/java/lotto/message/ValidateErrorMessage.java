package lotto.message;

public enum ValidateErrorMessage {

    PAYMENT_ERROR("구입 금액은 1,000원 단위 정수여야 합니다.");
    private final String message;

    ValidateErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
