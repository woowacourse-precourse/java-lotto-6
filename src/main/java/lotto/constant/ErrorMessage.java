package lotto.constant;

public enum ErrorMessage {
    NOT_INTEGER_MESSAGE("정수가 아닙니다."),
    NON_POSITIVE_INTEGER_MESSAGE("양의 정수가 아닙니다."),
    NOT_DIVIDED_BY_1000_MESSAGE("1000으로 나누어 떨어지는 수가 아닙니다."),
    THE_SIZE_OF_LOTTO_IS_NOT_PROPER_MESSAGE("번호의 개수가 6개가 아닙니다."),
    NUMBER_NOT_IN_RANGE_MESSAGE("올바른 범위의 수가 아닙니다."),
    DUPLICATED_MESSAGE("중복 값이 존재합니다.");

    private static final String ERROR_HEADER = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEADER
                + " "
                + message;
    }
}
