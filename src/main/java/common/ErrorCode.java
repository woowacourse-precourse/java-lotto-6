package common;

public enum ErrorCode {

    // Common
    NOT_NUMBER_STRING("숫자를 입력해 주세요."),

    // Amount
    AMOUNT_LESS_THAN_MINIMUM("1,000원 이상의 로또 구입 금액을 입력해 주세요."),
    AMOUNT_INVALID_UNIT("로또 구입 금액은 1,000원 단위로 입력해 주세요."),
    ;

    private static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX_ERROR_MESSAGE + message;
    }
}
