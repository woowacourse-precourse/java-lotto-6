package lotto.message;

public enum ErrorMessage {
    LOTTO_NUMBER_IS_NOT_IN_RANGE("[ERROR] 로또 번호의 숫자 범위는 1~45까지입니다."),
    LOTTO_IS_NOT_SIX_DIGITS("[ERROR] 로또는 6자리입니다."),
    LOTTO_NUMBER_IS_DUPLICATED("[ERROR] 로또는 중복되지 않는 숫자로 이루어져 있습니다."),
    AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS("[ERROR] 구입 금액은 1,000원 단위입니다."),
    INPUT_CONTAINS_WHITE_CHAR("[ERROR] 입력에는 공백 문자가 포함되면 안됩니다."),
    INPUT_IS_EMPTY("[ERROR] 입력이 비어있습니다."),
    INPUT_IS_NOT_NUMBER("[ERROR] 숫자를 입력해야 합니다."),
    PURCHASE_AMOUNT_IS_LESS_THAN_LOTTO_PRICE("[ERROR] 로또 구입 금액은 로또 가격보다 커야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
