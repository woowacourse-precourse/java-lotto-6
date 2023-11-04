package lotto.utils.validator;

@FunctionalInterface
public interface Validator<T> {
    void validate(T item);
}
