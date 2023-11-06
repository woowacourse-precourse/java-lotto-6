package lotto.vo;

import static lotto.error.ErrorMessage.NEGATIVE_PRICE;
import static lotto.error.ErrorMessage.NOT_DIGIT_PRICE;
import static lotto.error.ErrorMessage.NOT_THOUSAND_UNIT_PRICE;

public class Price {

    private static final int THOUSAND_UNIT = 1_000;

    private final long value;

    public Price(final String value) {
        long parsedValue = parseLong(value);

        validatePositive(parsedValue);
        validateThousandUnit(parsedValue);

        this.value = parsedValue;
    }

    public long getValue() {
        return value;
    }

    private long parseLong(final String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_DIGIT_PRICE.getMessage());
        }
    }

    private void validatePositive(final long value) {
        if (value < 0) {
            throw new IllegalArgumentException(NEGATIVE_PRICE.getMessage());
        }
    }

    private void validateThousandUnit(final long value) {
        if (value % THOUSAND_UNIT != 0) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT_PRICE.getMessage());
        }
    }

}
