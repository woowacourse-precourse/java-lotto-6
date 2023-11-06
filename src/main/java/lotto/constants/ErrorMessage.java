package lotto.constants;

public enum ErrorMessage {
    ERROR_INVALID_NUMBER("올바를 숫자를 입력하지 않았습니다."),
    ERROR_INVALID_AMOUNT("올바른 금액을 입력하지 않았습니다."),
    ERROR_INVALID_FORMAT("올바른 형식에 맞춰 입력하지 않았습니다."),
    ERROR_OUT_OF_RANGE("숫자 범위를 벗어난 입력을 하였습니다."),
    ERROR_DUPLICATE_NUMBER("중복된 숫자를 입력하였습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
