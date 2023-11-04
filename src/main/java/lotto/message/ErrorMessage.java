package lotto.message;

public enum ErrorMessage {
    LOTTO_NUMBER_IS_NOT_IN_RANGE("[ERROR] 로또 번호의 숫자 범위는 1~45까지이다."),
    LOTTO_IS_NOT_6DIGITS("[ERROR] 로또는 6자리이다."),
    LOTTO_NUMBER_IS_DUPLICATED("[ERROR] 로또는 중복되지 않는 숫자로 이루어져 있습니다."),
    AMOUNT_IS_NOT_IN_THOUSAND_WN_UNITS("[ERROR] 구입 금액은 1,000원 단위입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
