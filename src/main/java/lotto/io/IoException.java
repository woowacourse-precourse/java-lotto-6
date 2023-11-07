package lotto.io;

public enum IoException {
    ERROR("[ERROR] "),
    NOT_NUMBER(ERROR.message + "입력값이 숫자가 아닙니다."),
    ;

    private final String message;

    IoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
