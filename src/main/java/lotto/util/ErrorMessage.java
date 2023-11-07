package lotto.util;

public enum ErrorMessage {
    INVALID_INTEGER_FORMAT("[ERROR] INTEGER 형식에 어긋나는 입력입니다."),
    INVALID_PAYMENT_AMOUNT("[ERROR] 구입금액은 1000원 단위이어야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
