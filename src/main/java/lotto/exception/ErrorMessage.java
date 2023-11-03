package lotto.exception;

public enum ErrorMessage {
    VALIDATE_INPUT_EMPTY("[ERROR] 입력값은 비어있으면 안됩니다."),
    VALIDATE_INPUT_NUMBER("[ERROR] 입력값은 숫자만 가능합니다."),
    VALIDATE_PURCHASE_PRICE_DIVIDE("[ERROR] 입력한 값이 로또 금액으로 나누어 떨어지지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}
