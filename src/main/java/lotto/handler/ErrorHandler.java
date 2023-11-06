package lotto.handler;

public enum ErrorHandler {

    INCONVERTIBLE_TYPE("숫자로 변환될 수 없는 타입입니다."),
    INVALID_NEGATIVE_INPUT("0이하의 값은 들어갈 수 없습니다."),
    INVALID_DIVISION("입력값은 1000으로 나누어 떨어져야 합니다."),
    INVALID_SIZE("로또는 6개의 숫자만 가능합니다."),
    INVALID_RANGE("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다."),
    DUPLICATE_NUMBER("로또에 중복된 값은 들어갈 수 없습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        this.errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
