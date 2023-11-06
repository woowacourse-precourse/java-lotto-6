package lotto.domain.validator;

public interface Validator<T> {
    boolean inputValidate(T input);
}
