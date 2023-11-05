package lotto.constant;

public enum ErrorMessage {
    INITIAL_ERROR_TEXT("[ERROR] "),
    BLANK_INPUT("입력값은 공백일 수 없습니다."),
    INPUT_NOT_DIGIT("입력값은 숫자여야 합니다."),
    EXCEEDED_MAXIMUM_NUMBER_FORMAT(String.format("최대로 입력할 수 있는 수를 초과합니다. (최대: %d)", Long.MAX_VALUE));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return INITIAL_ERROR_TEXT.message + message;
    }
}
