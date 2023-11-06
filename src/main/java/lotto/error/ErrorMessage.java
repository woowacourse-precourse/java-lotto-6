package lotto.error;

public enum ErrorMessage {
    NOT_DIGIT_PRICE("[ERROR] 구입 금액은 숫자여야 합니다."),
    NEGATIVE_PRICE("[ERROR] 구입 금액은 음수일 수 없습니다."),
    NOT_THOUSAND_UNIT_PRICE("[ERROR] 구입 금액은 천 단위여야 합니다."),

    NOT_SIX_LOTTO_NUMBERS("[ERROR] 로또 번호가 6자리가 아닙니다."),
    NOT_UNIQUE_LOTTO_NUMBERS("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    NOT_IN_BOUND_LOTTO_NUMBERS("[ERROR] 로또 번호에 1부터 45 범위가 아닌 숫자가 있습니다."),
    NOT_DIGIT_LOTTO_NUMBERS("[ERROR] 로또 번호에 숫자가 아닌 값이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
