package lotto.template;

public interface Operation<T> {
    T execute() throws IllegalArgumentException;
}
