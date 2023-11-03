package lotto.exception;

public enum ErrorCode {

    EMPTY_VALUE("빈 문자열이 입력되었습니다."),
    NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    INCORRECT_UNIT("1000원 단위로 입력해야합니다."),
    ;


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
