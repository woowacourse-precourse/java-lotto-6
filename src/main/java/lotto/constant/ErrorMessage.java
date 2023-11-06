package lotto.constant;

public enum ErrorMessage {
    NOT_POSITIVE_INTEGER("양의 정수가 아닙니다."),
    NOT_DIVIDED_BY_1000("1000으로 나누어 떨어지는 수가 아닙니다."),
    SIZE_OF_LOTTO_IS_NOT_PROPER("번호의 개수가 6개가 아닙니다."),
    NUMBER_NOT_IN_RANGE("올바른 범위의 수가 아닙니다."),
    HAS_DUPLICATED_NUMBER("중복 값이 존재합니다.");

    private static final String MESSAGE_HEADER = "[ERROR]";
    private static final String WHITE_SPACE = " ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_HEADER
                + WHITE_SPACE
                + message;
    }
}
