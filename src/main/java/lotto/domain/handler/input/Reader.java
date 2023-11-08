package lotto.domain.handler.input;

@FunctionalInterface
public interface Reader<T> {
    T read();
}
