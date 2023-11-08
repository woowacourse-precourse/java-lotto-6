package lotto.validation;

public enum ErrorMessage {
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개가 입력되어야 합니다."),
    LOTTO_DUPLICATION_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

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
