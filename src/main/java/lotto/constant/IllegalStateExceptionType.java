package lotto.constant;

public enum IllegalStateExceptionType implements ExceptionType<IllegalStateException> {
    NO_MORE_ELEMENTS("원소가 더이상 존재하지 않습니다."),
    LOTTO_ALREADY_DISPENSED("이미 로또가 발행되었습니다.");

    private final String message;

    IllegalStateExceptionType(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalStateException getException() {
        return new IllegalStateException(message);
    }
}
