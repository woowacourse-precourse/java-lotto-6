package lotto.view.input.error;

public enum InputError {

    ERROR("[ERROR]"),

    MUST_BE_DIGIT(ERROR.message + " 숫자를 입력해주세요."),

    NOT_DIVISIBLE_BY_PRICE(ERROR.message + " 1000원 단위로만 구매가 가능합니다."),

    MUST_POSITIVE_AMOUNT_MONEY(ERROR.message + " 양수여야 합니다."),

    NOT_SUITABLE_LENGTH(ERROR.message + " %s개의 문자를 입력해주세요."),

    NOT_IN_RANGE_NUMBER(ERROR.message + " 가능한 로또 숫자가 아닙니다."),

    DUPLICATED(ERROR.message + " 중복된 숫자가 있으면 안됩니다."),
    ;


    final String message;

    InputError(String message) {
        this.message = message;
    }
}
