package lotto.generator;

@FunctionalInterface
public interface Generator<T> {

	T generate();
}