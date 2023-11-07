package lotto.exception.constants;

public enum ErrorConsts {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호에 중복된 숫자가 있습니다."),
    LOTTO_NUMBERS_SIZE_NOT_MATCH("로또 번호는 6개만 가능합니다."),
    MONEY_NOT_DIVIDED_BY_LOTTO_PRICE("로또 구입 금액은 로또 가격의 배수여야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 로또 번호와 중복될 수 없습니다."),

    ;

    private final String message;

    ErrorConsts(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
