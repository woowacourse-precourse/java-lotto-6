package lotto.util.converter;

import lotto.util.exception.InvalidPurchaseAmountException;

public class PurchaseAmountConverter {
    private PurchaseAmountConverter() {
    }

    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidPurchaseAmountException(input, e);
        }
    }
}
