package lotto.message;

public enum ErrorMessage implements Message {
    ERROR_PREFIX("[ERROR] %s"),
    NOT_INTEGER("숫자가 아닙니다."),
    NOT_POSITIVE("양수가 아닙니다."),
    NOT_MULTIPLE_OF_THOUSAND("1000의 배수가 아닙니다."),
    NOT_BLANK("공백과 빈 문자열을 허용하지 않습니다."),
    INVALID_SIZE("올바른 사이즈가 아닙니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
