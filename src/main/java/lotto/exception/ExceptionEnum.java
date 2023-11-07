package lotto.exception;

public enum ExceptionEnum {
    NOT_NUMBER_EXCEPTION("[error] 숫자를 입력해주세요");
    private final String message;

    ExceptionEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
