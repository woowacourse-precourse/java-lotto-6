package lotto.constant;

public interface ExceptionType<T> {
    static final String MESSAGE_FORMAT = "[ERROR] %s";

    String getMessage();

    T getException();
}
