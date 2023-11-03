package lotto.view;

public enum ExceptionMessages {

    STRING_TO_INTEGER("입력 값은 숫자로만 이루어져 있어야 합니다"),
    DUPLICATION_LIST("입력 값들은 서로 중복되지 않아야 합니다."),
    INPUT_LENGTH_WINNING_NUMBER("입력 값의 개수는 6개 여야 합니다."),
    INPUT_LENGTH_BONUS_NUMBER("입력 값의 개수는 1개 여야 합니다."),
    ERROR_INPUT_BONUS_NUMBER_RANGE("입력 값은 1,000의 배수여야 합니다."),
    EXCEED("입력 값은 100,000 이하의 값이어야 합니다."),
    NUMBER_IN_RANGE("입력 값의 범위는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_IN_LIST("입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
