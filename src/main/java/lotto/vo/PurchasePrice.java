package lotto.vo;

import static lotto.error.ErrorMessage.NEGATIVE_PRICE;
import static lotto.error.ErrorMessage.NOT_DIGIT_PRICE;
import static lotto.error.ErrorMessage.NOT_THOUSAND_UNIT_PRICE;

public class PurchasePrice {

    private static final int THOUSAND_UNIT = 1_000;
    private static final int ZERO = 0;

    private final int price;

    public PurchasePrice(final String price) {
        int parsedValue = parseInt(price);

        validatePositive(parsedValue);
        validateThousandUnit(parsedValue);

        this.price = parsedValue;
    }

    public int getPrice() {
        return price;
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
