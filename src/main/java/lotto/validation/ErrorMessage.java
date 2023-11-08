package lotto.validation;

public enum ErrorMessage {
    LOTTO_MIN_PRICE_ERROR("[ERROR] 최소 구입 금액은 1,000원입니다."),
    LOTTO_PRICE_ERROR("[ERROR] 1,000 원 단위로만 구매할 수 있습니다."),

    NOT_INTGER_ERROR("[ERROR] 숫자가 아닌 값이 입력되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
