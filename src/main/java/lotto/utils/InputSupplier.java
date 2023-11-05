package lotto.utils;

public interface InputSupplier<T> {
    T get() throws IllegalArgumentException;
}
