package lotto.controller;

@FunctionalInterface
public interface ExceptionSupplier<T> {
    T get() throws IllegalArgumentException;
}
