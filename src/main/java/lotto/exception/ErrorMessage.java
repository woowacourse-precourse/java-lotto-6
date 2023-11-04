package lotto.exception;

public enum ErrorMessage {

    // InputView
    INPUT_NOT_COMPOSED_OF_NUMBER("[ERROR] 구입 금액은 숫자로 이루어져야 합니다."),
    PURCHASE_AMOUNT_UNDER_THOUSAND("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    INDIVISIBLE_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원으로 나누어떨어져야 합니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
