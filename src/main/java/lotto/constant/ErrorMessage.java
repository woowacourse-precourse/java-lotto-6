package lotto.constant;

public enum ErrorMessage {
    INITIAL_ERROR_TEXT("[ERROR] "),
    BLANK_INPUT("입력값은 공백일 수 없습니다."),
    INPUT_NOT_DIGIT("입력값은 숫자여야 합니다."),
    EXCEEDED_MAXIMUM_NUMBER_FORMAT(String.format("최대로 입력할 수 있는 수를 초과합니다. (최대: %d)", Long.MAX_VALUE)),
    MONEY_LESS_THAN_ZERO("구매금액은 0 이하일 수 없습니다."),
    MONEY_WITH_REMAINDER("구매금액은 1개의 로또 금액으로 나누어 떨어져야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return INITIAL_ERROR_TEXT.message + message;
    }
}
