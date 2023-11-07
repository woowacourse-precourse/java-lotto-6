package lotto.exception;

public enum ErrorMessage {
    INVALID_AMOUNT("구입 금액은 1000원 단위만 입력 가능합니다."),
    NON_INTEGER("입력값이 정수가 아닙니다."),
    CONSECUTIVE_COMMAS("콤마가 연속으로 입력되었습니다."),
    LAST_COMMA("입력의 마지막이 콤마입니다."),
    INVALID_INTEGER_COUNT("정수는 6개만 입력 가능합니다."),
    NON_POSITIVE_INTEGER("양수의 정수만 입력 가능합니다.");


    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }
}
