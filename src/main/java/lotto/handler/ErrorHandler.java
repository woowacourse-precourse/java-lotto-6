package lotto.handler;

public enum ErrorHandler {

    INVALID_TYPE("숫자로 변환될 수 없는 타입입니다."),
    INVALID_NEGATIVE_INPUT("0이하의 값은 들어갈 수 없습니다."),
    INVALID_DIVISION("입력값은 1000으로 나누어 떨어져야 합니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        this.errorMessage = "[Error] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
