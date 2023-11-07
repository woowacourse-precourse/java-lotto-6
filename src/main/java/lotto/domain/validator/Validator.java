package lotto.domain.validator;

public interface Validator<T> {
    void validate(T input);
}
