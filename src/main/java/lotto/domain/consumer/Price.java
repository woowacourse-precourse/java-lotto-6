package lotto.domain.consumer;

import lotto.exception.Price.PriceNot1KsException;
import lotto.exception.Price.PriceNotInRangeException;
import lotto.exception.Price.PriceNotPositiveIntegerException;

public record Price(int value) {

    private static final String NUMERIC_REGEX = "^[0-9]*$";

    public Price {
        validatePriceNumeric(value);
        validatePrice1Ks(value);
        validatePriceNotInRange(value);
    }

    private void validatePriceNumeric(int value) {
        String line = String.valueOf(value);

        if (!line.matches(NUMERIC_REGEX)) {
            throw new PriceNotPositiveIntegerException();
        }
    }

    private void validatePrice1Ks(int value) {
        if (value % 1000 != 0) {
            throw new PriceNot1KsException();
        }
    }

    private void validatePriceNotInRange(int value) {
        if (value <= 0) {
            throw new PriceNotInRangeException();
        }
    }
}
