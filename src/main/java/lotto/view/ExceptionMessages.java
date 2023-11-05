package lotto.view;

public enum ExceptionMessages {

    STRING_TO_INTEGER("입력 값은 숫자로만 이루어져 있어야 합니다"),
    DUPLICATION_LIST("입력 값들은 서로 중복되지 않아야 합니다."),
    INPUT_COUNT("입력 값의 개수는 %d개 여야 합니다."),
    INPUT_MULTIPLE_NUMBER("입력 값은 %d의 배수여야 합니다."),
    EXCEED("입력 값은 %d 이하의 값이어야 합니다."),
    NUMBER_IN_RANGE("입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_IN_LIST("입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public String getMessage() {
        return exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }

    public void throwException(int param1) {
        String message = String.format(exceptionMessage, param1);
        throw new IllegalArgumentException(message);
    }

    public void throwException(int param1, int param2) {
        String message = String.format(exceptionMessage, param1, param2);
        throw new IllegalArgumentException(message);
    }

    public void throwException(int param1, int param2, int param3) {
        String message = String.format(exceptionMessage, param1, param2, param3);
        throw new IllegalArgumentException(message);
    }

}
