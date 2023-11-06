package lotto.utils;

@FunctionalInterface
public interface Askable<M> {
    M ask() throws IllegalArgumentException;
}
