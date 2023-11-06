package lotto.domain.validation;

public enum ExceptionMessage {
    EXCEPTION_MESSAGE_PREFIX("[ERROR]"),
    NUMBER_FORMAT_EXCEPTION("1000원 단위의 숫자를 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
