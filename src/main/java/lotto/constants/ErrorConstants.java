package lotto.constants;

public enum ErrorConstants {
    ERROR_PREFIX("[ERROR] "),
    ERROR_NULL_INPUT("NULL 값이 입력 되었습니다."),
    ERROR_BLANK_INPUT("공백,빈 값이 입력 되었습니다."),
    ERROR_NON_NUMBER_TYPE_INPUT("숫자 타입의 값이 입력되지 않았습니다."),
    ERROR_LOTTO_NUMBER_SIZE("로또 번호가 6자리가 아닙니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("중복된 로또 번호가 존재합니다."),
    ERROR_LOTTO_NUMBER_RANGE_OVER("로또 번호의 범위를 벗어났습니다. ( 1 ~ 45 )");

    private final String message;

    ErrorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
