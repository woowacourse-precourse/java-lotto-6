package constant;

public enum ExceptionMessage {
    NUMERIC_REQUIRED("숫자를 입력해야 합니다."),
    INPUT_STRING("숫자가 아닌 문자를 입력했습니다."),
    NON_INTEGER_AMOUNT("구입 금액이 정수가 아닙니다."),
    ZERO_INTEGER_AMOUNT("구입 금액은 0원이 불가능합니다."),
    NON_MULTIPLE_OF_1000("구입 금액이 1000원 단위가 아닙니다."),
    OUT_OF_RANGE_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("로또 번호가 중복이 존재합니다."),
    INVALID_INPUT_SIZE("6개의 로또 번호를 입력해야 합니다"),
    ERROR_MESSAGE("[ERROR] ");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
