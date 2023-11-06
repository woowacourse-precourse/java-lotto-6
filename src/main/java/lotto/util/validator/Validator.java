package lotto.util.validator;

public interface Validator {
    void validate(Object value);

    boolean support(Class<?> clazz);
}
