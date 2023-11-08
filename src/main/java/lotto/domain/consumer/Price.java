package lotto.domain.consumer;

import lotto.exception.Price.PriceNot1KsException;
import lotto.exception.Price.PriceNotPositiveIntegerException;

public record Price(int value) {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    public Price {
        validatePricePositiveInteger(value);
        validatePrice1Ks(value);
    }

    private void validatePricePositiveInteger(int value) {
        String line = String.valueOf(value);

        if (!line.matches(POSITIVE_INTEGER_REGEX)) {
            throw new PriceNotPositiveIntegerException();
        }
    }

    private void validatePrice1Ks(int value) {
        if (value % 1000 != 0) {
            throw new PriceNot1KsException();
        }
    }
}
