package lotto.validator;

import lotto.constants.ErrorMessages;

public interface Validator<T> {
    void validate(T data);
    default void throwException(ErrorMessages errorMessages) {
        throw new IllegalArgumentException(errorMessages.getMessage());
    }
}
