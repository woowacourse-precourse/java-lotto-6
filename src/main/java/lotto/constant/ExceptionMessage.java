package lotto.constant;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    INVALID_NUMERIC_INPUT("숫자만 입력해주세요."),
    OUT_OF_NUMBER_RANGE("숫자가 0~9 범위를 넘어갔습니다."),
    INVALID_DIVIDE_THOUSAND("1000으로 나누어 떨어지는 수가 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toValue() {
        return ERROR.message + message;
    }
}
