package lotto.constants;

public enum ExceptionMessages {
    STRING_TO_INTEGER("입력 값은 양수만 허용됩니다."),
    INPUT_TO_EMPTY("입력 값은 공백이 허용되지 않습니다."),
    INPUT_TO_BLANK("잘못된 입력입니다."),
    DUPLICATION_LIST("입력 값들은 서로 중복되지 않아야 합니다."),
    INPUT_COUNT("입력 값의 개수는 %d개 여야 합니다."),
    INPUT_MULTIPLE_NUMBER("입력 값은 %d의 배수여야 합니다."),
    EXCEED("입력 값은 %d 이하의 값이어야 합니다."),
    NUMBER_IN_RANGE("입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_IN_LIST("입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다."),
    INPUT_ATTEMPT_EXCEEDED_MESSAGE("시도 횟수 초과");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public String getMessage() {
        return exceptionMessage;
    }

    public String getMessage(int param1) {
        return String.format(exceptionMessage, param1);
    }

    public String getMessage(int param1, int param2) {
        return String.format(exceptionMessage, param1, param2);
    }

    public void throwException() {
        System.out.println(exceptionMessage);
        throw new IllegalArgumentException(exceptionMessage);
    }

    public void throwException(int param1) {
        String message = String.format(exceptionMessage, param1);
        System.out.println(message);
        throw new IllegalArgumentException(message);
    }

    public void throwException(int param1, int param2) {
        String message = String.format(exceptionMessage, param1, param2);
        System.out.println(message);
        throw new IllegalArgumentException(message);
    }
}
