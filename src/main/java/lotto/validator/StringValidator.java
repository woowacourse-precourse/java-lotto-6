package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class StringValidator {
    private final String value;

    private StringValidator(String value) {
        this.value = value;
    }

    public static StringValidator of(String value) {
        return new StringValidator(value);
    }

    public StringValidator shouldNotEmpty(ErrorMessage errorMessage) {
        if (value == null || value.isEmpty()) {
            throw new InvalidInputException(errorMessage);
        }
        return this;
    }
}
