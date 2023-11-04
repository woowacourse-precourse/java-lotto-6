package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class NumberValidator {
    private final int value;

    private NumberValidator(int value) {
        this.value = value;
    }

    public static NumberValidator of(int value) {
        return new NumberValidator(value);
    }

    public NumberValidator shouldPositive(ErrorMessage errorMessage) {
        if (value < 0) {
            throw new InvalidInputException(errorMessage);
        }
        return this;
    }

    public NumberValidator shouldInRange(int expectedMin, int expectedMax, ErrorMessage errorMessage) {
        if (value < expectedMin || value > expectedMax) {
            throw new InvalidInputException(errorMessage);
        }
        return this;
    }

    public NumberValidator shouldBeMultipleOf(int multiple, ErrorMessage errorMessage) {
        if (value % multiple != 0) {
            throw new InvalidInputException(errorMessage);
        }
        return this;
    }


}
