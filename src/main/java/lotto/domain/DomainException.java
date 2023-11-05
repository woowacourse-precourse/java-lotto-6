package lotto.domain;

enum DomainException {
    ERROR("[ERROR] "),

    LOTTO_RANGE(ERROR.message + "로또 번호는 1에서 45 사이 숫자여야 합니다."),
    LOTTO_SIZE(ERROR.message + "로또는 6개여야 합니다."),
    LOTTO_DUPLICATION(ERROR.message + "로또번호에 중복되는 숫자가 있습니다."),

    PRICE_LESS_THAN_OR_EQUAL_TO_ZERO(ERROR.message + "구입 금액이 0 이하입니다."),
    ;

    private final String message;

    DomainException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
