package lotto;

public interface Validator {
    void validate(Object value);

    boolean support(Class<?> clazz);
}
