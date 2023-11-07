package lotto.exception;

public interface InputCallback<T> {
    T execute() throws IllegalArgumentException;
}
