package lotto.domain.generator;

@FunctionalInterface
public interface NumberGenerator<T> {

    T generateNumbers();
}
