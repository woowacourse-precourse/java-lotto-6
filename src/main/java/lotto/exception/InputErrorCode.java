package lotto.exception;

public enum InputErrorCode implements ErrorCode {

    INVALID_NUMERIC_INPUT("숫자만 입력해야 합니다."),
    SHOULD_SPLIT_BY_COMMA("쉼표(,)로 분리가능해야 합니다."),
    SHOULD_NOT_BLANK("입력을 해야 합니다."),
    SHOULD_BE_UNIQUE("고유한 숫자만을 입력해야 합니다."),


    ;


    static final String PREFIX = "[ERROR] ";

    final String message;


    InputErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX + message;
    }


}
