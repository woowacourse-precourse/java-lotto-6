package lotto.domain.validate.exception;

public enum InputException {
    NO_VALUE_NAME("자동차 이름을 위한 입력값이 입력되지 않았습니다."),
    NOT_IN_RANGE_MONEY("1000이상 50000이하의 값을 입력하십시오."),
    NOT_DIVIDED_BY_1000("1000으로 나눠 떨어지는 값을 입력하십시오."),
    NO_NUMBER("숫자 값을 입력하십시오.");

    private static final String prefix = "[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
