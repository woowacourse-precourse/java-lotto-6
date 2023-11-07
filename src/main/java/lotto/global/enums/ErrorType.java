package lotto.global.enums;

public enum ErrorType {

    ERROR_PREFIX("[ERROR]"),

    EMPTY_INPUT_VALUE("입력 값이 비어 있습니다."),
    INVALID_NUMBER_FORMAT("숫자 이외의 형식은 입력할 수 없습니다."),
    INVALID_RANGE_OF_LOTTO("로또 번호는 1~45 범위 내의 숫자입니다."),
    INVALID_COUNT_OF_LOTTO_NUMBER("로또 번호는 6개 숫자로 구성되어 있어야 합니다."),
    DUPLICATE_BONUS_NUMBER_IN_LOTTO("보너스 번호는 기존의 당첨 번호에 없는 숫자만 가능합니다."),
    DUPLICATE_NUMBER_IN_LOTTO("중복된 번호가 존재해서는 안 됩니다."),
    DIVIDED_INTO_1_000("1000원 단위로 나누어 떨어져야 합니다."),

    ;

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
