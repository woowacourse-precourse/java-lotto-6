package lotto.common.exception;

public enum ErrorType {
    INVALID_PURCHASE_AMOUNT("로또 구입 금액은 1,000원 단위이어야 합니다."),
    ;

    final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
