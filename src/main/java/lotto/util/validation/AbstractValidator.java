package lotto.util.validation;

import static lotto.exception.ExceptionMessage.NOT_MUST_BE_NULL;

public abstract class AbstractValidator<T> implements Validator<T> {
    public void validateNotNull(final T target) {
        if (target == null) {
            throwFail(NOT_MUST_BE_NULL.format());
        }
    }

    public void throwFail(final String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
