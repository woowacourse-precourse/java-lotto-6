package lotto.message;

public enum ExceptionMessage {
    INPUT_EMPTY_STRING_MESSAGE("값을 입력해야 합니다."),
    INPUT_ZERO_OR_LESS_MESSAGE("0보다 크거나 같은 숫자를 입력해야 합니다."),
    INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE("%d의 배수를 입력해야 합니다."),

    NOT_SAME_WITH_LOTTO_SIZE("로또 숫자는 %d개여야 합니다."),
    CONSIST_OF_DUPLICATE_NUMBER("로또는 모두 다른 수로 이루어져야 합니다."),
    IS_NOT_IN_RANGE("%d와 %d사이의 숫자로 이루어져야 합니다."),

    INPUT_NOT_NUMBER_MESSAGE("숫자를 입력해야 합니다."),
    INPUT_DUPLICATE_WITH_WINNING_LOTTO("로또 번호와 중복된 수가 아니여야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public String getMessage(Object... values) {
        return String.format(exceptionMessage, values);
    }

    public void throwException(Object ... values) {
        throw new IllegalArgumentException(String.format(exceptionMessage, values));
    }
}

