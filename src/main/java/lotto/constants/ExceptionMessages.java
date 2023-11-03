package lotto.constants;

public enum ExceptionMessages {
    NULL_INPUT("null은 입력할 수 없습니다."),
    EMPTY_INPUT("값을 입력해주세요."),
    NOT_NUMERIC_INPUT("숫자를 입력해주세요."),
    WRONG_RANGE_INPUT("1,000원 이상의 구매 금액을 입력해주세요."),
    NOT_DIVISIBLE_INPUT("1,000원 단위의 구매 금액을 입력해주세요.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessages;

    ExceptionMessages(String exceptionMessages) {
        this.exceptionMessages = ERROR_TAG + exceptionMessages;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessages);
    }
}
