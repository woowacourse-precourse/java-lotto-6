package util;

public enum NumberErrorMessage {
    NUMBER_IN_EMPTY("아무것도 입력하지 않았습니다."),
    NOT_A_NUMBER("숫자가 아닙니다."),
    OUT_OF_INT_RANGE("숫자의 범위를 초과했습니다.");

    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}