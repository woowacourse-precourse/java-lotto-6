package lotto.vo;

import static lotto.error.ErrorMessage.NEGATIVE_PRICE;
import static lotto.error.ErrorMessage.NOT_DIGIT_PRICE;
import static lotto.error.ErrorMessage.NOT_THOUSAND_UNIT_PRICE;

public class Price {

    private static final int THOUSAND_UNIT = 1_000;

    private final int value;

    public Price(final String value) {
        int parsedValue = parseInt(value);

        validatePositive(parsedValue);
        validateThousandUnit(parsedValue);

        this.value = parsedValue;
    }

    public int getValue() {
        return value;
    }

    private int parseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_DIGIT_PRICE.getMessage());
        }
    }

    private void validatePositive(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(NEGATIVE_PRICE.getMessage());
        }
    }

    private void validateThousandUnit(final int value) {
        if (value % THOUSAND_UNIT != 0) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT_PRICE.getMessage());
        }
    }

}
