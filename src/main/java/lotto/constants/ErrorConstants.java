package lotto.constants;

public enum ErrorConstants {
    ERROR_PREFIX("[ERROR] "),
    ERROR_NULL_INPUT("NULL 값이 입력 되었습니다."),
    ERROR_BLANK_INPUT("공백,빈 값이 입력 되었습니다."),
    ERROR_NON_NUMBER_TYPE_INPUT("숫자 타입의 값이 입력되지 않았습니다.");

    private final String message;

    ErrorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
