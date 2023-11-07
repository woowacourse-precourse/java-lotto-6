package lotto.vo;

import static lotto.error.ErrorMessage.NEGATIVE_PRICE;
import static lotto.error.ErrorMessage.NOT_DIGIT_PRICE;
import static lotto.error.ErrorMessage.NOT_THOUSAND_UNIT_PRICE;

public class PurchasePrice {

    private static final int THOUSAND_UNIT = 1_000;
    private static final int ZERO = 0;

    private final int value;

    public PurchasePrice(final String value) {
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
        if (value < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_PRICE.getMessage());
        }
    }

    private void validateThousandUnit(final int value) {
        if (value % THOUSAND_UNIT != ZERO) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT_PRICE.getMessage());
        }
    }

}
