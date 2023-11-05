package lotto.constant;

public interface ExceptionType<T> {
    String MESSAGE_FORMAT = "[ERROR] %s";

    String getMessage();

    T getException();
}
